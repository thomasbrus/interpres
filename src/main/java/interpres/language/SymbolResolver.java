package interpres.language;

import java.util.Arrays;

import interpres.ast.Symbol;
import interpres.ast.ListExpression;
import interpres.ast.QuoteExpression;

import interpres.language.values.Value;
import interpres.language.values.Integer;

public class SymbolResolver {
  private DefinitionTable definitionTable;

  public static class IrresolvableSymbolException extends RuntimeException {
    public IrresolvableSymbolException(Symbol symbol) {
      super("Could not resolve symbol: " + symbol.getName());
    }
  }

  public SymbolResolver(DefinitionTable definitionTable) {
    this.definitionTable = definitionTable;
  }

  public Value resolve(Symbol symbol) {
    if (definitionTable.contains(symbol))
      return definitionTable.lookup(symbol);

    if (symbol.quote() instanceof Integer)
      return this.asInteger(symbol);

    throw new IrresolvableSymbolException(symbol);
  }

  public Value asInteger(Symbol symbol) {
    return ListExpression.buildFunctionCall(
      "asm.loadl", new QuoteExpression(symbol)
    ).evaluate(definitionTable);
  }
}
