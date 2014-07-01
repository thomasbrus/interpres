package interpres.language.values;

import java.util.List;
import java.util.Arrays;

import interpres.language.DefinitionTable;

public class Symbol extends Value {
  private java.lang.String intern;

  public Symbol(java.lang.String intern) {
    this.intern = intern;
  }

  public java.lang.String getIntern() {
    return this.intern;
  }

  public List<java.lang.String> bytecodeSequence() {
    return Arrays.asList(this.intern);
  }

  public Value unquote(DefinitionTable definitionTable) {
    return new interpres.ast.Symbol(this.intern).evaluate(definitionTable);
  }

  public java.lang.String toString() {
    return this.intern.toString();
  }
}

