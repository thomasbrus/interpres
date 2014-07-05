package interpres.language.definitions.core.integer;

import interpres.ast.IntegerValue;
import interpres.ast.LambdaExpression;

import interpres.language.definitions.Definition;

public class Subtract extends Definition {

  public Subtract() {
    super("core.integer.subtract", new LambdaExpression((definitionTable, arguments) -> {
      IntegerValue firstInteger = (IntegerValue) arguments.get(0).evaluate(definitionTable);
      IntegerValue secondInteger = (IntegerValue) arguments.get(1).evaluate(definitionTable);
      return new IntegerValue(firstInteger.getValue() - secondInteger.getValue());
    }));
  }

}


