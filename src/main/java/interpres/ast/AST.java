package interpres.ast;

import java.util.List;
import java.util.ArrayList;

import interpres.SourceLocation;
import interpres.AsBytecode;

import interpres.language.DefinitionTable;
import interpres.language.values.Value;

public abstract class AST implements AsBytecode {
  private SourceLocation sourceLocation;

  public AST() {
    this.sourceLocation = SourceLocation.UNKNOWN_SOURCE;
  }

  public AST(SourceLocation sourceLocation) {
    this.sourceLocation = sourceLocation;
  }

  public abstract AsBytecode evaluate(DefinitionTable definitionTable);

  public SourceLocation getSourceLocation() {
    return this.sourceLocation;
  }

  public int getSourceLineNumber() {
    return this.sourceLocation.getLineNumber();
  }

  public String getSourceFileName() {
    return this.sourceLocation.getFileName();
  }

  public AsBytecode quote() {
    return this;
  }

  public Value unquote(DefinitionTable definitionTable) {
    throw new UnsupportedOperationException("Unquoting is not supported for " + this.getClass());
  }

  public List<java.lang.String> bytecodeSequence() {
    return new ArrayList<java.lang.String>();
  }

  public boolean isQuotedSymbol() {
    return (this instanceof QuoteExpression &&
      ((QuoteExpression) this).getExpression() instanceof Symbol);
  }
}

