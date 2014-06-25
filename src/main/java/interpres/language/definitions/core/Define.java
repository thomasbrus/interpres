package interpres.language.definitions.core;

import java.util.Arrays;

import interpres.ast.Symbol;

import interpres.language.definitions.Definition;

import interpres.language.values.Value;
import interpres.language.values.Lambda;
import interpres.language.values.Void;

public class Define extends Definition {

  public Define() {
    super("core.define", new Lambda((definitionTable, arguments) -> {
      Symbol symbol = (Symbol) arguments.get(0);
      Value value = arguments.get(1).evaluate(definitionTable);
      definitionTable.define(symbol.getName(), value);
      return new Void();
    }), 0);
  }

}
