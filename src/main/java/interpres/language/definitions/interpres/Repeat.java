package interpres.language.definitions.interpres;

import java.util.Collections;

import interpres.ast.LambdaExpression;
import interpres.ast.ListExpression;
import interpres.ast.IntegerValue;

import interpres.language.definitions.Definition;

public class Repeat extends Definition {

  public Repeat() {
    super("interpres/repeat", new LambdaExpression((definitionTable, arguments) -> {
      IntegerValue countLiteral = (IntegerValue) arguments.get(0).evaluate(definitionTable);

      return ListExpression.buildFunctionCall(
        "interpres/list", Collections.nCopies(countLiteral.getValue(), arguments.get(1))
      ).evaluate(definitionTable);
    }));
  }

}

