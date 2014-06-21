package interpres.ast;

import java.util.Arrays;
import java.util.List;

import interpres.DefinitionTable;
import interpres.PrintableBytecode;
import interpres.InstructionSequence;

public class IntegerLiteral extends AST {
  private Integer value;

  public IntegerLiteral(Integer value) {
    this.value = value;
  }

  public PrintableBytecode evaluate(DefinitionTable definitionTable) {
    return new InstructionSequence(Arrays.asList("LOADL " + this.value));
  }

  public String toString() {
    return this.value.toString();
  }
}

