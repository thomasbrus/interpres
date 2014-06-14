tree grammar TreeWalker;

options {
  tokenVocab = Grammar;
  output = AST;
  ASTLabelType = CommonTree;
}

@header {
  package interpres;
  import interpres.ast.*;
  import interpres.ast.Node;
}

walk returns [Node node]: program { $node = $program.node; };

// Transformer rules
// =============================================================================

program returns [Node node]
  @init {
    List<Node> expressions = new ArrayList<Node>();
  }
  @after {
    $node = new ListNode(expressions);
  }
  :
  ^(LIST (expression { expressions.add($expression.node); })*)
  ;

expression returns [Node node]: sexp | list | atom;

sexp returns [Node node]
  @init {
    Node functionName;
    List<Node> arguments = new ArrayList<Node>();
  }
  @after {
    $node = new SexpNode(functionName, arguments);
  }
  :
  ^(SEXPR
    sexp_function_name { functionName = $sexp_function_name.node; }
    (sexp_argument { arguments.add($sexp_argument.node); })*)
  ;

sexp_function_name returns [Node node]: expression;

sexp_argument returns [Node node]: expression;

list returns [Node node]
  @init {
    List<Node> items = new ArrayList<Node>();
  }
  @after {
    $node = new ListNode(items);
  }
  :
  ^(LIST (list_item { items.add($list_item.node); })*)
  ;

list_item returns [Node node]: expression;

atom returns [Node node]:
  ^(STRING string) { $node = new StringNode($string.text); }
  ^(REFERENCE reference) { $node = new ReferenceNode($reference.text); }
  ;

string: QUOTED_VALUE;
reference: IDENTIFIER;

