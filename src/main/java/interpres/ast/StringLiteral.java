package interpres.ast;

import java.util.List;
import java.util.ArrayList;

import interpres.definitions.DefinitionTable;
import interpres.instructions.PrintableInstructionSequence;
import interpres.instructions.InstructionSequence;

public class StringLiteral extends AST {
  private String literal;

  public StringLiteral(String literal) {
    this.literal = literal;
  }

  public PrintableInstructionSequence evaluate(DefinitionTable definitionTable) {
    InstructionSequence instructions = new InstructionSequence();

    for (int i = literal.length() - 1; i >= 0; i--) {
      instructions.add("LOADL " + (int) literal.charAt(i));
    }

    return instructions;
  }

  public String quote() {
    return this.literal;
  }
}

