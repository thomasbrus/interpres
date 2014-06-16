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
    $ast = new Program(expressions);
  }
  :
  ^(PROGRAM (expression { expressions.add($expression.ast); })*)
  ;

expression returns [AST ast]
  : list { $ast = $list.ast; }
  | literal { $ast = $literal.ast; }
  | quoted_expression { $ast = $quoted_expression.ast; }
  | unquoted_expression { $ast = $unquoted_expression.ast; }
  ;

list returns [AST ast]
  @init {
    List<AST> items = new ArrayList<AST>();
  }
  @after {
    if (items.isEmpty()) {
      $ast = new QuotedExpression(new ListExpression(items));
    } else {
      $ast = new ListExpression(items);
    }
  }
  :
  ^(LIST (expression { items.add($expression.ast); })*)
  ;

literal returns [AST ast]
  : ^(STRING string=String) {
    String literal = $string.text;
    $ast = new StringLiteral(literal.substring(1, literal.length() - 1));
  }
  | ^(SYMBOL symbol=Symbol) {
    $ast = new Symbol($symbol.text);
  }
  ;

quoted_expression returns [AST ast]
  : ^(QUOTED expression) { $ast = new QuotedExpression($expression.ast); }
  ;

unquoted_expression returns [AST ast]
  : ^(UNQUOTED expression) { $ast = new UnquotedExpression($expression.ast); }
  ;

