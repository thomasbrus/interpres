package interpres.ast;

import java.util.List;
import java.util.stream.*;
import org.antlr.runtime.tree.*;

public class ListExpression extends AST {
  private List<AST> items;

  public ListExpression(List<AST> items) {
    this.items = items;
  }

  public List<Object> evaluate() {
    return this.items.stream().map(AST::evaluate).collect(Collectors.toList());
  }
}

