package interpres.language.values;

import java.util.List;
import java.util.function.BiFunction;

import interpres.ast.AST;
import interpres.language.DefinitionTable;

public class Lambda extends Value {
  private BiFunction<DefinitionTable, List<AST>, Value> function;

  public Lambda(BiFunction<DefinitionTable, List<AST>, Value> function) {
    this.function = function;
  }

  public BiFunction<DefinitionTable, List<AST>, Value> getFunction() {
    return this.function;
  }
}

