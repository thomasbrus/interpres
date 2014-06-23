package interpres.language.values;

public class List extends Value {
  public List(java.util.List<java.lang.String> items) {
    super(items);
    this.instructions = items;
  }
}

