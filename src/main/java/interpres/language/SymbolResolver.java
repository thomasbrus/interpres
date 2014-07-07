package interpres.language;

import interpres.ast.AST;
import interpres.ast.Symbol;
import interpres.ast.ListExpression;

public class SymbolResolver {
  private DefinitionTable definitionTable;

  public static class IrresolvableSymbolException extends RuntimeException {
    /**
     * Constructs a new IrresolvableSymbolException.
     * @param symbol the symbol that could not be resolved
     */
    public IrresolvableSymbolException(Symbol symbol) {
      super("Could not resolve symbol: " + symbol.getName());
    }
  }
  
  /**
   * Constructs a new SymbolResolver.
   *
   * @param definitionTable the DefinitionTable to work with
   */
  public SymbolResolver(DefinitionTable definitionTable) {
    this.definitionTable = definitionTable;
  }

  /**
   * Resolves a symbol into an AST.
   *
   * @param definitionTable the DefinitionTable to work with
   * @return the corresponding AST
   * @throws IrresolvableSymbolException if !definitionTable.contains(symbol)
   */
  public AST resolve(Symbol symbol) {
    if (definitionTable.contains(symbol))
      return definitionTable.lookup(symbol);

    throw new IrresolvableSymbolException(symbol);
  }
}
