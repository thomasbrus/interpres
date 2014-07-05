package interpres.ast;

import interpres.AsBytecode;

import interpres.language.DefinitionTable;
import interpres.language.values.Value;

public class VirtualExpression extends AST {
  private AsBytecode value;

  public VirtualExpression(AsBytecode value) {
    this.value = value;
  }

  public AsBytecode evaluate(DefinitionTable definitionTable) {
    return this.value;
  }
}

