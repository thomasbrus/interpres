package interpres.ast;

public class IntegerNode extends Node {
  private Integer literal;

  public IntegerNode(Integer literal) {
    this.literal = literal;
  }

  public Object evaluate() {
    return null;
  }
}

