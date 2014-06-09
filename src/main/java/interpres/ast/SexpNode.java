package interpres.ast;

import java.util.List;
import org.antlr.runtime.tree.*;

public class SexpNode extends Node {
  private CommonTree expressions;

  public SexpNode(CommonTree expressions) {
    this.expressions = expressions;
  }
}

