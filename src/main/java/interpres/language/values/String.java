package interpres.language.values;

import java.util.List;
import java.util.Arrays;

import interpres.ast.AST;

public class String extends Value {
  private java.lang.String literal;

  public String(java.lang.String literal) {
    this.literal = literal;
  }

  public java.lang.String getLiteral() {
    return this.literal;
  }

  public List<java.lang.String> instructionSequence() {
    return Arrays.asList(this.literal);
  }

  public java.lang.String toString() {
    return this.literal.toString();
  }
}

