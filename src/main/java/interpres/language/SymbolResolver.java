package interpres.language;

import interpres.RuntimeException;

import interpres.ast.AST;
import interpres.ast.Symbol;
import interpres.ast.ListExpression;

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

  public AST resolve(Symbol symbol) {
    if (definitionTable.contains(symbol))
      return definitionTable.lookup(symbol);

    throw new IrresolvableSymbolException(symbol);
  }
}
