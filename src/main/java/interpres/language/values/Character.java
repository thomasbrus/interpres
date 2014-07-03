package interpres.language.values;

import java.util.List;
import java.util.Arrays;

import interpres.ast.AST;

public class Character extends Value {
  private java.lang.Character representation;
  private AST characterAST;

  public Character(java.lang.Character representation) {
    this.representation = representation;
  }

  public Character(java.lang.Character representation, AST characterAST) {
    this.representation = representation;
    this.characterAST = characterAST;
  }

  public java.lang.Character getRepresentation() {
    return this.representation;
  }

  public List<java.lang.String> bytecodeSequence() {
    return Arrays.asList(this.representation.toString());
  }

  public java.lang.String toString() {
    return this.representation.toString();
  }
}

