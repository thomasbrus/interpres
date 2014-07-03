package interpres.language.values;

import java.util.List;
import java.util.Arrays;

public class Character extends Value {
  private java.lang.Character representation;

  public Character(java.lang.Character representation) {
    this.representation = representation;
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

