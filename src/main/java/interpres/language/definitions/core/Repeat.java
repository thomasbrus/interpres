package interpres.language.definitions.core;

import java.util.Collections;

import interpres.ast.LambdaExpression;
import interpres.ast.ListExpression;
import interpres.ast.IntegerValue;

import interpres.language.definitions.Definition;

public class Repeat extends Definition {

  public Repeat() {
    super("core.repeat", new LambdaExpression((definitionTable, arguments) -> {
      IntegerValue countLiteral = (IntegerValue) arguments.get(0).evaluate(definitionTable);

      return ListExpression.buildFunctionCall(
        "core.list", Collections.nCopies(countLiteral.getValue(), arguments.get(1))
      ).evaluate(definitionTable);
    }));
  }

}

