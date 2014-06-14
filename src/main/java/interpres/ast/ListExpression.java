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
    Stream<Object> things = this.items.stream().map(i -> i.evaluate());
    return things.collect(Collectors.toList());
  }
}

