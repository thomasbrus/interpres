package interpres.ast;

import java.util.List;
import org.antlr.runtime.tree.*;

public class ListNode extends Node {
  private CommonTree expressions;

  public ListNode(CommonTree expressions) {
    this.expressions = expressions;
  }

  public Object evaluate() {
    return "[ ... ]";
  }
}

