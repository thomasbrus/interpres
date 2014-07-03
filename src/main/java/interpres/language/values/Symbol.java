package interpres.language.values;

import java.util.List;
import java.util.Arrays;

import interpres.ast.AST;

public class Symbol extends Value {
  private java.lang.String intern;
  private AST symbolAST;

  public Symbol(java.lang.String intern) {
    this(intern, null);
  }
  
  public Symbol(java.lang.String intern, AST symbolAST) {
    this.intern = intern;
    this.symbolAST = symbolAST;
  }

  public java.lang.String getIntern() {
    return this.intern;
  }

  public List<java.lang.String> bytecodeSequence() {
    return Arrays.asList(this.intern);
  }

  public AST getUnquotedAST() {
    return this.symbolAST;
  }

  public java.lang.String toString() {
    return this.intern.toString();
  }
}

