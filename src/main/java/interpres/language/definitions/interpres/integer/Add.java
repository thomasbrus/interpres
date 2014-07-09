package interpres.language.definitions.interpres.integer;

import interpres.ast.IntegerValue;
import interpres.ast.LambdaExpression;

import interpres.language.definitions.Definition;

public class Add extends Definition {

  public Add() {
    super("interpres/integer/add", new LambdaExpression((definitionTable, arguments) -> {
      IntegerValue firstInteger = (IntegerValue) arguments.get(0).evaluate(definitionTable);
      IntegerValue secondInteger = (IntegerValue) arguments.get(1).evaluate(definitionTable);
      return new IntegerValue(firstInteger.getValue() + secondInteger.getValue());
    }));
  }

}


