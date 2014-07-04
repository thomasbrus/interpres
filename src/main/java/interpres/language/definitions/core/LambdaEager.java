package interpres.language.definitions.core;

import interpres.language.definitions.Definition;

public class LambdaEager extends Definition {

  public LambdaEager() {
    super("core.lambda-eager", new interpres.language.values.Lambda((definitionTable, arguments) ->
      new interpres.language.invocations.core.LambdaEager(definitionTable, arguments).invoke()
    ));
  }

}

