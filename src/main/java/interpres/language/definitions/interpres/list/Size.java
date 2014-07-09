package interpres.language.definitions.interpres.list;

import java.util.Arrays;

import interpres.ast.Symbol;
import interpres.ast.LambdaExpression;
import interpres.ast.ListExpression;
import interpres.ast.IntegerValue;

import interpres.language.definitions.Definition;

public class Size extends Definition {

  public Size() {
    super("interpres/list/size", new LambdaExpression((definitionTable, arguments) -> {
      ListExpression list = (ListExpression) arguments.get(0).evaluate(definitionTable);
      // FIXME: Should use #getItems(), use (core.list.flatten) to get instruction size
      return new IntegerValue(list.instructionSequence().size());
    }));
  }

}
