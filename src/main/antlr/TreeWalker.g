tree grammar TreeWalker;

options {
  tokenVocab = Grammar;
  output = AST;
  ASTLabelType = CommonTree;
}

@header {
  package interpres;
  import interpres.ast.*;
}

walk returns [AST ast]: program { $ast = $program.ast; };

// Transformer rules
// =============================================================================

program returns [AST ast]
  @init {
    List<AST> expressions = new ArrayList<AST>();
  }
  @after {
    $ast = new ListExpression(expressions);
  }
  :
  ^(LIST (expression { expressions.add($expression.ast); })*)
  ;

expression returns [AST ast]
  : sexp { $ast = $sexp.ast; }
  | list { $ast = $list.ast; }
  | atom { $ast = $atom.ast; }
  ;

sexp returns [AST ast]
  @init {
    AST functionName;
    List<AST> arguments = new ArrayList<AST>();
  }
  @after {
    $ast = new SymbolicExpression(functionName, arguments);
  }
  :
  ^(SEXPR
    sexp_function_name { functionName = $sexp_function_name.ast; }
    (sexp_argument { arguments.add($sexp_argument.ast); })*)
  ;

sexp_function_name returns [AST ast]: expression { $ast = $expression.ast; };

sexp_argument returns [AST ast]: expression { $ast = $expression.ast; };

list returns [AST ast]
  @init {
    List<AST> items = new ArrayList<AST>();
  }
  @after {
    $ast = new ListExpression(items);
  }
  :
  ^(LIST (list_item { items.add($list_item.ast); })*)
  ;

list_item returns [AST ast]: expression { $ast = $expression.ast; };

atom returns [AST ast]
  : ^(STRING string=QUOTED_VALUE) {
    String literal = $string.text;
    $ast = new StringLiteral(literal.substring(1, literal.length() - 1));
  }
  | ^(REFERENCE reference=IDENTIFIER) {
    $ast = new Reference($reference.text);
  }
  ;

