package interpres.language.definitions.core.list;

import java.util.Collections;

import interpres.ast.AST;
import interpres.ast.LambdaExpression;
import interpres.ast.ListExpression;

import interpres.language.definitions.Definition;

public class Reverse extends Definition {

  public Reverse() {
    super("core.list.reverse", new LambdaExpression((definitionTable, arguments) -> {
      ListExpression reversableList = (ListExpression) arguments.get(0).evaluate(definitionTable);
      // FIXME: Shouldn't modify original list (?)
      Collections.reverse(reversableList.getItems());
      return reversableList;
    }, 1));
  }

}

