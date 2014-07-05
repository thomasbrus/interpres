package interpres.ast;

import java.util.List;

import interpres.SourceLocation;
import interpres.language.DefinitionTable;
import interpres.language.values.Value;

public abstract class AST {
  private SourceLocation sourceLocation;

  public AST() {
    this.sourceLocation = SourceLocation.UNKNOWN_SOURCE;
  }

  public AST(SourceLocation sourceLocation) {
    this.sourceLocation = sourceLocation;
  }

  public abstract Value evaluate(DefinitionTable definitionTable);

  public SourceLocation getSourceLocation() {
    return this.sourceLocation;
  }

  public int getSourceLineNumber() {
    return this.sourceLocation.getLineNumber();
  }

  public String getSourceFileName() {
    return this.sourceLocation.getFileName();
  }

  public Value quote() {
    throw new UnsupportedOperationException("Quoting is not supported for " + this.getClass());
  }

  public Value unquote(DefinitionTable definitionTable) {
    return this.evaluate(definitionTable).unquote(definitionTable);
  }

  public boolean isQuotedSymbol() {
    return (this instanceof QuoteExpression &&
      ((QuoteExpression) this).getExpression() instanceof Symbol);
  }
}
