package interpres.ast;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.PrintStream;

import interpres.SourceLocation;
import interpres.language.DefinitionTable;

public abstract class AST implements Iterable<java.lang.String> {
  private SourceLocation sourceLocation;

  public AST() {
    this.sourceLocation = SourceLocation.UNKNOWN_SOURCE;
  }

  public AST(SourceLocation sourceLocation) {
    this.sourceLocation = sourceLocation;
  }

  public abstract AST evaluate(DefinitionTable definitionTable);

  public SourceLocation getSourceLocation() {
    return this.sourceLocation;
  }

  public int getSourceLineNumber() {
    return this.sourceLocation.getLineNumber();
  }

  public String getSourceFileName() {
    return this.sourceLocation.getFileName();
  }

  public List<String> instructionSequence() {
    return new ArrayList<String>();
  }

  public Iterator<String> iterator() {
    return this.instructionSequence().iterator();
  }

  public void printInstructionSequence(PrintStream printStream) {
    for (java.lang.String bytecode : this.instructionSequence()) {
      printStream.println(bytecode);
    }
  }

  public boolean isQuotedSymbol() {
    return (this instanceof QuoteExpression &&
      ((QuoteExpression) this).getExpression() instanceof Symbol);
  }
}

