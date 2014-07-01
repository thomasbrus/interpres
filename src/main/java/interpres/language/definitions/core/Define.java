package interpres.language.definitions.core;

import java.util.Arrays;

import interpres.language.definitions.Definition;

import interpres.language.values.Value;
import interpres.language.values.Symbol;
import interpres.language.values.Lambda;
import interpres.language.values.Void;

public class Define extends Definition {

  public Define() {
    super("core.define", new Lambda((definitionTable, arguments) -> {
      Symbol nameSymbol = (Symbol) arguments.get(0).evaluate(definitionTable);
      Value value = arguments.get(1).evaluate(definitionTable);
      definitionTable.define(nameSymbol.getIntern(), value);
      return new Void();
    }));
  }

}
