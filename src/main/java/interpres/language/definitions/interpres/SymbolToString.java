package interpres.language.definitions.interpres;

import java.util.List;
import java.util.ArrayList;

import interpres.ast.LambdaExpression;
import interpres.ast.Symbol;
import interpres.ast.StringValue;

import interpres.language.definitions.Definition;

public class SymbolToString extends Definition {

  public SymbolToString() {
    super("interpres/symbol-to-string", new LambdaExpression((definitionTable, arguments) -> {
      Symbol symbolValue = (Symbol) arguments.get(0).evaluate(definitionTable);
      return new StringValue(symbolValue.getName());
    }));
  }

}

