package interpres.ast;

import java.util.Arrays;
import java.util.List;

import interpres.DefinitionTable;

public class IntegerLiteral extends AST {
  private Integer value;

  public IntegerLiteral(Integer value) {
    this.value = value;
  }

  public Object evaluate(DefinitionTable definitionTable) {
    return Arrays.asList("LOADL " + this.value);
  }

  public String toString() {
    return this.value.toString();
  }
}

