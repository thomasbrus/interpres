package interpres.language.values;

import java.util.List;
import java.util.Arrays;

public class Character extends Value {
  private java.lang.Character value;

  public Character(java.lang.Character value) {
    this.value = value;
  }

  public java.lang.Character getValue() {
    return this.value;
  }

  public List<java.lang.String> bytecodeSequence() {
    return Arrays.asList(this.value.toString());
  }

  public java.lang.String toString() {
    return this.value.toString();
  }
}

