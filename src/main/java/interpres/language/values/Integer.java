package interpres.language.values;

import java.util.List;
import java.util.Arrays;

import interpres.ast.AST;

public class Integer extends Value {
  private java.lang.Integer representation;

  public Integer(java.lang.Integer representation) {
    this.representation = representation;
  }

  public java.lang.Integer getRepresentation() {
    return this.representation;
  }

  public List<java.lang.String> instructionSequence() {
    return Arrays.asList(this.representation.toString());
  }
}

