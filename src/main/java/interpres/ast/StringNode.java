package interpres.ast;

public class StringNode extends Node {
  private String literal;

  public StringNode(String literal) {
    this.literal = literal;
  }

  public Object evaluate() {
    return null;
  }
}

