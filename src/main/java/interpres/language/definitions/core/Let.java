package interpres.language.definitions.core;

import interpres.language.definitions.Definition;
import interpres.language.values.Lambda;

public class Let extends Definition {

  public Let() {
    super("core.let", new Lambda((definitionTable, arguments) ->
      new interpres.language.invocations.core.Let(definitionTable, arguments).invoke()
    ));
  }

}

