package interpres.language.definitions.core;

import java.util.List;
import java.util.ArrayList;

import interpres.ast.AST;

import interpres.language.definitions.Definition;

import interpres.language.values.Lambda;
import interpres.language.values.Symbol;
import interpres.language.values.String;

public class StringToSymbol extends Definition {

  public StringToSymbol() {
    super("core.string-to-symbol", new Lambda((definitionTable, arguments) -> {
      String stringValue = (String) arguments.get(0).evaluate(definitionTable);
      return new Symbol(stringValue.getLiteral());
    }));
  }

}

