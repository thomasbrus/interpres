package interpres.ast;

public class IntegerNode extends Node {
  private Integer value;

  public IntegerNode(Integer value) {
    this.value = value;
  }

  public Object evaluate() {
    return null;
  }
}

