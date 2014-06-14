package interpres.ast;

public class ReferenceNode extends Node {
  private String name;

  public ReferenceNode(String name) {
    this.name = name;
  }

  public Object evaluate() {
    return null;
  }
}

