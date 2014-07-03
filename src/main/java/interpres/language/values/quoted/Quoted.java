package interpres.language.values.quoted;

import java.util.List;

import interpres.ast.AST;
import interpres.language.DefinitionTable;
import interpres.language.values.Value;

public abstract class Quoted extends Value {
  private AST unquotedAST;
  private Value quotedValue;

  public Quoted(AST sourceAST, Value quotedValue) {
    this.unquotedAST = unquotedAST;
    this.quotedValue = quotedValue;
  }

  public AST getUnquotedAST() {
    return this.unquotedAST;
  }

  public Value getQuotedValue() {
    return this.quotedValue;
  }

  public java.util.List<java.lang.String> bytecodeSequence() {
    return this.quotedValue.bytecodeSequence();
  }

  public Value unquote(DefinitionTable definitionTable) {
    return this.unquotedAST.evaluate(definitionTable);
  }

  public java.lang.String toString() {
    return this.quotedValue.toString();
  }
}

