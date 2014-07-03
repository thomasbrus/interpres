package interpres.ast;

import java.util.List;
import interpres.language.DefinitionTable;
import interpres.language.values.Value;
import interpres.language.values.quoted.Quoted;

public abstract class AST {
  public abstract Value evaluate(DefinitionTable definitionTable);

  public Quoted quote() {
    throw new UnsupportedOperationException("Quoting is not supported for " + this.getClass());
  }

  public boolean isQuotedSymbol() {
    return (this instanceof QuotedExpression &&
      ((QuotedExpression) this).getExpression() instanceof Symbol);
  }
}

