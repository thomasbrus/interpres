package interpres.language.values;

import java.util.List;
import java.util.Arrays;

public class Integer extends Value {
  private java.lang.Integer value;

  public Integer(java.lang.Integer value) {
    this.value = value;
  }

  public java.lang.Integer getValue() {
    return this.value;
  }

  public List<java.lang.String> bytecodeSequence() {
    return Arrays.asList(this.value.toString());
  }
}

