package interpres.language.values;

import java.util.stream.Collectors;

public class List extends Value {
  private java.util.List<Object> items;

  // TODO: Try if this could be changed to List<Value> instead
  public List(java.util.List<Object> items) {
    this.items = items;
  }

  public java.util.List<Object> getItems() {
    return this.items;
  }

  public java.util.List<java.lang.String> bytecodeSequence() {
    return this.items.stream().map(Object::toString).collect(Collectors.toList());
  }
}

