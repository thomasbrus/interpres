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

program returns [Node node]: ^(LIST expressions=expression+) { $node = new ListNode($expressions.tree); };

expression: sexp | list | atom;

sexp returns [Node node]: ^(SEXPR expressions=expression+) { $node = new SexpNode($expressions.tree); };

list returns [Node node]: ^(LIST expressions=expression*) { $node = new ListNode($expressions.tree); };

atom: string | reference | integer;

string returns [Node node]: ^(STRING literal=~(DOUBLE_QUOTE)*) { $node = new StringNode($literal.text); };
integer returns [Node node]: ^(INTEGER literal=NUMBER) { $node = new IntegerNode(Integer.parseInt($literal.text)); };
reference returns [Node node]: ^(REFERENCE literal=IDENTIFIER) { $node = new ReferenceNode($literal.text); };

