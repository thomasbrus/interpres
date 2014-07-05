package interpres.language;

import java.util.Arrays;
import org.apache.commons.lang3.StringUtils;

import interpres.ast.AST;
import interpres.ast.Symbol;
import interpres.ast.ListExpression;
import interpres.ast.IntegerValue;

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

    if (StringUtils.isNumeric(symbol.getName()))
      return new IntegerValue(Integer.parseInt(symbol.getName())).evaluate(definitionTable);

    throw new IrresolvableSymbolException(symbol);
  }
}
