package interpres.language.definitions.core;

import interpres.language.definitions.Definition;
import interpres.language.values.Lambda;

public class Bind extends Definition {

  public Bind() {
    super("core.bind", new Lambda((definitionTable, arguments) ->
      new interpres.language.invocations.core.Bind(definitionTable, arguments).invoke()
    ));
  }

}

