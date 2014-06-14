package interpres.ast;

import java.util.List;
import org.antlr.runtime.tree.*;

public class SexpNode extends Node {
  private Node functionName;
  private List<Node> arguments;

  public SexpNode(Node functionName, List<Node> arguments) {
    this.functionName = functionName;
    this.arguments = arguments;
  }

  public Object evaluate() {
    return null;
  }
}

