package interpres.language.values;

import java.util.stream.Collectors;

public class List extends Value {
  private java.util.List<Value> items;

  public List(java.util.List<Value> items) {
    this.items = items;
  }

  public java.util.List<Value> getItems() {
    return this.items;
  }

  public java.util.List<java.lang.String> bytecodeSequence() {
    return this.items.stream().map(Object::toString).collect(Collectors.toList());
  }

  public java.lang.String toString() {
    return this.items.toString();
  }
}

