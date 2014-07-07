package interpres.language.definitions.interpres.list;

import java.util.Arrays;

import interpres.ast.Symbol;
import interpres.ast.LambdaExpression;
import interpres.ast.ListExpression;
import interpres.ast.IntegerValue;

import interpres.language.definitions.Definition;

public class At extends Definition {

  public At() {
    super("interpres/list/at", new LambdaExpression((definitionTable, arguments) -> {
      ListExpression listExpression = (ListExpression) arguments.get(0).evaluate(definitionTable);
      IntegerValue indexValue = (IntegerValue) arguments.get(1).evaluate(definitionTable);
      return listExpression.getItem(indexValue.getValue());
    }));
  }

}
