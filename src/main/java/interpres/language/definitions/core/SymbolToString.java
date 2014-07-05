package interpres.language.definitions.core;

import java.util.List;
import java.util.ArrayList;

import interpres.ast.AST;
import interpres.ast.StringLiteral;

import interpres.language.definitions.Definition;

import interpres.language.values.Lambda;
import interpres.language.values.Symbol;

public class SymbolToString extends Definition {

  public SymbolToString() {
    super("core.symbol-to-string", new Lambda((definitionTable, arguments) -> {
      Symbol symbolValue = (Symbol) arguments.get(0).evaluate(definitionTable).getValue();
      return new StringLiteral(symbolValue.getIntern());
    }));
  }

}

