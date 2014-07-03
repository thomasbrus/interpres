package interpres.language.values;

import java.util.List;
import java.util.Arrays;

import interpres.ast.AST;

public class Integer extends Value {
  private java.lang.Integer representation;
  private AST integerAST;

  public Integer(java.lang.Integer representation) {
    this(representation, null);
  }

  public Integer(java.lang.Integer representation, AST integerAST) {
    this.representation = representation;
    this.integerAST = integerAST;
  }

  public java.lang.Integer getRepresentation() {
    return this.representation;
  }

  public List<java.lang.String> bytecodeSequence() {
    return Arrays.asList(this.representation.toString());
  }

  public AST getUnquotedAST() {
    return this.integerAST;
  }

  public java.lang.String toString() {
    return this.representation.toString();
  }
}

