package interpres.language.definitions.core;

import interpres.language.definitions.Definition;

import interpres.language.values.Value;
import interpres.language.values.Symbol;
import interpres.language.values.Lambda;
import interpres.language.values.List;

public class Bind extends Definition {

  public Bind() {
    super("core.bind", new Lambda((definitionTable, arguments) -> {
      Symbol nameSymbol = (Symbol) arguments.get(0).evaluate(definitionTable);
      Value value = arguments.get(1).evaluate(definitionTable);
      definitionTable.bind(nameSymbol.getIntern(), value);
      return List.buildEmpty();
    }));
  }

}
