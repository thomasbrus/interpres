package interpres.language;

import java.util.Arrays;
import org.apache.commons.lang3.StringUtils;

import interpres.AsBytecode;

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

  public AsBytecode resolve(Symbol symbol) {
    if (definitionTable.contains(symbol))
      return definitionTable.lookup(symbol);

    if (StringUtils.isNumeric(symbol.getName()))
      return ListExpression.buildFunctionCall(
        "asm.loadl", new QuoteExpression(symbol)
      ).evaluate(definitionTable);

    throw new IrresolvableSymbolException(symbol);
  }
}
