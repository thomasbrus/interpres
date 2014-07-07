package interpres.language.definitions.interpres.list;

import java.util.List;
import java.util.ArrayList;

import interpres.ast.AST;
import interpres.ast.LambdaExpression;
import interpres.ast.ListExpression;

import interpres.language.definitions.Definition;

public class Reverse extends Definition {

  /**
   * Constructs a new Reverse object.
   * Returns a ListExpression with given arguments in a reversed order.
   */
  public Reverse() {
    super("interpres/list/reverse", new LambdaExpression((definitionTable, arguments) -> {
      List<AST> reversedList = new ArrayList<AST>();
      ListExpression originalList = (ListExpression) arguments.get(0).evaluate(definitionTable);

      for (AST item : originalList.getItems()) {
        reversedList.add(0, item);
      }

      return new ListExpression(reversedList);
    }));
  }

}

