package interpres.language.definitions.core;

import interpres.ast.LambdaExpression;
import interpres.language.definitions.Definition;

public class Let extends Definition {

  public Let() {
    super("core.let", new LambdaExpression((definitionTable, arguments) ->
      new interpres.language.invocations.core.Let(definitionTable, arguments).invoke(),
    2));
  }

}

