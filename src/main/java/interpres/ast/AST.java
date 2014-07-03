package interpres.ast;

import java.util.List;
import interpres.language.DefinitionTable;
import interpres.language.values.Value;

public abstract class AST {
  public abstract Value evaluate(DefinitionTable definitionTable);

  public Value quote() {
    throw new UnsupportedOperationException("Quoting is not supported for " + this.getClass());
  }

  public boolean isQuotedSymbol() {
    return (this instanceof QuoteExpression &&
      ((QuoteExpression) this).getExpression() instanceof Symbol);
  }

  public Value unquote(DefinitionTable definitionTable) {
    return this.evaluate(definitionTable).unquote(definitionTable);
  }
}
