package interpres.language;

import java.util.Arrays;

import interpres.ast.Symbol;
import interpres.ast.ListExpression;
import interpres.ast.QuotedExpression;

import interpres.language.values.Value;

public class SymbolResolver {
  private DefinitionTable definitionTable;

  public SymbolResolver(DefinitionTable definitionTable) {
    this.definitionTable = definitionTable;
  }

  public Value resolve(Symbol symbol) {
    String symbolName = symbol.getName();

    if (definitionTable.contains(symbolName))
      return definitionTable.lookup(symbolName);

    if (this.matchesIntegerFormat(symbol))
      return this.asInteger(symbol);

    // FIXME: Throw exception here?
    System.err.println("Couldn't resolve definition for " + symbolName);

    return null;
  }

  public boolean matchesIntegerFormat(Symbol symbol) {
    return symbol.getName().matches("[-+]?[1-9]+[0-9]*");
  }

  public Value asInteger(Symbol symbol) {
    return ListExpression.buildFunctionCall("asm.loadl",
        new QuotedExpression(symbol)
    ).evaluate(definitionTable);
  }
}

