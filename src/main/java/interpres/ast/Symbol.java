package interpres.ast;

import interpres.definitions.DefinitionTable;
import interpres.instructions.PrintableInstructionSequence;
import interpres.instructions.InstructionSequence;

public class Symbol extends AST {
  private String name;

  public Symbol(String name) {
    this.name = name;
  }

  public PrintableInstructionSequence evaluate(DefinitionTable definitionTable) {
    return definitionTable.lookup(this.name);
  }

  public String getName() {
    return this.name;
  }

  public String quote() {
    return this.name;
  }
}

