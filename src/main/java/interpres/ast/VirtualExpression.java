package interpres.ast;

import interpres.language.DefinitionTable;
import interpres.language.values.Value;

public class VirtualExpression extends AST {
  private Value value;

  public VirtualExpression(Value value) {
    this.value = value;
  }

  public Value evaluate(DefinitionTable definitionTable) {
    return this.value;
  }

  // public Value quote() {
  //   return this.value.quote();
  // }
}

