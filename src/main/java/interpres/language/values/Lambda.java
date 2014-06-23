package interpres.language.values;

import java.util.List;
import java.util.function.BiFunction;

import interpres.ast.AST;
import interpres.language.DefinitionTable;

public class Lambda extends Value {
  public Lambda(BiFunction<DefinitionTable, List<AST>, Value> lambda) {
    super(lambda);
  }

  @SuppressWarnings("unchecked")
  public BiFunction<DefinitionTable, List<AST>, Value> getValue() {
    return (BiFunction<DefinitionTable, List<AST>, Value>) super.getValue();
  }
}

