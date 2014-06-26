package interpres.language.definitions.core;

import interpres.language.definitions.Definition;

public class Lambda extends Definition {

  public Lambda() {
    super("core.lambda", new interpres.language.values.Lambda((definitionTable, arguments) ->
      new interpres.language.invocations.core.Lambda(definitionTable, arguments).invoke()
    ));
  }

}

