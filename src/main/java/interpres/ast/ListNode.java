package interpres.ast;

import java.util.List;
import org.antlr.runtime.tree.*;

public class ListNode extends Node {
  private List<Node> expressions;

  public ListNode(List<Node> expressions) {
    this.expressions = expressions;
  }

  public Object evaluate() {
    return "[ ... ]";
  }
}

