package interpres.language.definitions.core;

import interpres.language.definitions.Definition;
import interpres.language.values.Lambda;
import interpres.language.values.Value;

public class Unquote extends Definition {

  public Unquote() {
    super("core.unquote", new Lambda((definitionTable, arguments) -> {
      Value unquotable = arguments.get(0).evaluate(definitionTable);
      return unquotable.unquote(definitionTable);
    }));
  }

}

