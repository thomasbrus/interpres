package interpres.ast;

public class ReferenceNode extends Node {
  private String literal;

  public ReferenceNode(String literal) {
    this.literal = literal;
  }

  public Object evaluate() {
    return null;
  }
}

