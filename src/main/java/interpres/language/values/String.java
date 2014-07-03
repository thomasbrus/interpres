package interpres.language.values;

import java.util.List;
import java.util.Arrays;

import interpres.ast.AST;

public class String extends Value {
  private java.lang.String literal;
  private AST stringAST;

  public String(java.lang.String literal) {
    this(literal, null);
  }

  public String(java.lang.String literal, AST stringAST) {
    this.literal = literal;
    this.stringAST = stringAST;
  }

  public java.lang.String getLiteral() {
    return this.literal;
  }

  public List<java.lang.String> bytecodeSequence() {
    return Arrays.asList(this.literal);
  }

  public AST getUnquotedAST() {
    return this.stringAST;
  }

  public java.lang.String toString() {
    return this.literal.toString();
  }
}

