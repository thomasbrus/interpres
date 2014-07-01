package interpres.language.definitions.core.symbol;

import java.util.List;
import java.util.ArrayList;

import interpres.ast.AST;
import interpres.language.definitions.Definition;

import interpres.language.values.Value;
import interpres.language.values.Lambda;
import interpres.language.values.Symbol;

public class Concat extends Definition {

  public Concat() {
    super("core.symbol.concat", new Lambda((definitionTable, arguments) -> {
      List<String> strings = new ArrayList<String>();

      for (AST argument : arguments) {
        Symbol concatenable = (Symbol) argument.evaluate(definitionTable);
        strings.add(concatenable.getIntern());
      }

      return new Symbol(String.join("", strings));
    }));
  }

}

