package interpres.language.values;

public class List extends Value {
  private java.util.List<java.lang.String> items;

  // TODO: Figure out if this must be of type String
  public List(java.util.List<java.lang.String> items) {
    this.items = items;
  }

  public java.util.List<java.lang.String> getItems() {
    return this.items;
  }

  public java.util.List<java.lang.String> bytecodeSequence() {
    return this.items;
  }
}

