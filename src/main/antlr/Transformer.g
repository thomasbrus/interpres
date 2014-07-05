tree grammar Transformer;

options {
  tokenVocab = Grammar;
  output = AST;
  ASTLabelType = CommonTree;
}

@header {
  package interpres;
  import interpres.ast.*;
  import org.apache.commons.lang3.StringEscapeUtils;
}

@members {
  String sourceFileName;

  public Transformer(CommonTreeNodeStream nodes, String sourceFileName) {
    super(nodes);
    this.sourceFileName = sourceFileName;
  }
}

transform returns [AST ast]: program { $ast = $program.ast; };

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
    Integer lineNumber = -1;
    List<AST> items = new ArrayList<AST>();
  }
  @after {
    $ast = new ListExpression(items, new SourceLocation(this.sourceFileName, lineNumber));
  }
  :
  ^(LIST (expression {
    items.add($expression.ast);
    if (lineNumber == -1) lineNumber = $expression.tree.getLine();
  })*)
  ;

literal returns [AST ast]
  : ^(STRING string=String) {
    String literal = StringEscapeUtils.unescapeJava($string.text);
    $ast = new StringValue(literal.substring(1, literal.length() - 1));
  }
  | ^(CHARACTER character=Character) {
    $ast = new CharacterValue($character.text.charAt(1));
  }
  | ^(INTEGER integer=Integer) {
    $ast = new IntegerValue(java.lang.Integer.parseInt($integer.text));
  }
  | ^(SYMBOL symbol=Symbol) {
    $ast = new Symbol($symbol.text);
  }
  ;

quoted_expression returns [AST ast]
  : ^(QUOTED expression) { $ast = new QuoteExpression($expression.ast); }
  ;

unquoted_expression returns [AST ast]
  : ^(UNQUOTED expression) { $ast = new UnquoteExpression($expression.ast); }
  ;

