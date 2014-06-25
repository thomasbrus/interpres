package interpres.language.values;

import java.util.ArrayList;

public class List extends Value {
  private java.util.List<Value> items;

  public List(java.util.List<Value> items) {
    this.items = items;
  }

  public java.util.List<Value> getItems() {
    return this.items;
  }

  public java.util.List<java.lang.String> bytecodeSequence() {
    java.util.List<java.lang.String> bytecodeSequence = new ArrayList<java.lang.String>();

    for (Value item : this.items) {
      bytecodeSequence.addAll(item.bytecodeSequence());
    }

    return bytecodeSequence;
  }

  public java.lang.String toString() {
    return this.items.toString();
  }
}

