package interpres.ast;

import interpres.AsInstructionSequence;

import interpres.language.DefinitionTable;
import interpres.language.values.Value;

public class VirtualExpression extends AST {
  private AsInstructionSequence value;

  public VirtualExpression(AsInstructionSequence value) {
    this.value = value;
  }

  public AsInstructionSequence evaluate(DefinitionTable definitionTable) {
    return this.value;
  }
}

