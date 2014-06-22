package interpres.ast;

import java.util.Arrays;
import java.util.List;

import interpres.definitions.DefinitionTable;
import interpres.instructions.PrintableInstructionSequence;
import interpres.instructions.InstructionSequence;

public class IntegerLiteral extends AST {
  private Integer value;

  public IntegerLiteral(Integer value) {
    this.value = value;
  }

  public PrintableInstructionSequence evaluate(DefinitionTable definitionTable) {
    return new InstructionSequence(Arrays.asList("LOADL " + this.value));
  }

  public Integer quote() {
    return this.value;
  }
}

