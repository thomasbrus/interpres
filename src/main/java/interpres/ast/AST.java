package interpres.ast;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.PrintStream;

import interpres.SourceLocation;
import interpres.language.DefinitionTable;

public abstract class AST implements Iterable<java.lang.String> {
  private SourceLocation sourceLocation;

  /**
   * Constructs a new AST.   
   */
  public AST() {
    this.sourceLocation = SourceLocation.UNKNOWN_SOURCE;
  }

  /**
   * Constructs a new AST.   
   *
   * @param sourceLocation the SourceLocation to work with
   */
  public AST(SourceLocation sourceLocation) {
    this.sourceLocation = sourceLocation;
  }

  /**
   * Evaluates the current AST.  
   *
   * @param definitionTable the definition table used while evaluating the object
   * @return the generated AST
   */
  public abstract AST evaluate(DefinitionTable definitionTable);

  /**
   * Returns the source location of this object.
   *
   * @return source location of this AST
   */
  public SourceLocation getSourceLocation() {
    return this.sourceLocation;
  }

  /**
   * Returns the line number corresponding with this object.
   *
   * @return line number belonging to this object
   */
  public int getSourceLineNumber() {
    return this.sourceLocation.getLineNumber();
  }

  /**
   * Returns the file name corresponding with this object.
   *
   * @return file name belonging to this object
   */
  public String getSourceFileName() {
    return this.sourceLocation.getFileName();
  }

  /**
   * Returns the instructions corresponding with this object.
   *
   * @return List of Strings containing the instructions belonging to this object
   */
  public List<String> instructionSequence() {
    return new ArrayList<String>();
  }

  /**
   * Returns the iterator corresponding with the instructions of this object.
   * 
   * @return Iterator of the instruction sequence
   */
  public Iterator<String> iterator() {
    return this.instructionSequence().iterator();
  }

  /**
   * Prints the instruction sequence to the given PrintStream.
   *
   * @param printStream the stream to print the instructions to
   */
  public void printInstructionSequence(PrintStream printStream) {
    for (java.lang.String bytecode : this.instructionSequence()) {
      printStream.println(bytecode);
    }
  }

  /**
   * Indicates whether or not the current object is a quoted symbol or not.
   *
   * @return boolean that indicates whether this object is a quoted symbol
   */
  public boolean isQuotedSymbol() {
    return (this instanceof QuoteExpression &&
      ((QuoteExpression) this).getExpression() instanceof Symbol);
  }
}

