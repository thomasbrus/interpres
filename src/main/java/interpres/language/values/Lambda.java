package interpres.language.values;

import java.util.List;
import java.util.function.BiFunction;

import interpres.AsBytecode;
import interpres.ast.AST;
import interpres.language.DefinitionTable;

public class Lambda extends Value {
  private BiFunction<DefinitionTable, List<AST>, AsBytecode> function;

  public Lambda(BiFunction<DefinitionTable, List<AST>, AsBytecode> function) {
    this.function = function;
  }

  public BiFunction<DefinitionTable, List<AST>, AsBytecode> getFunction() {
    return this.function;
  }
}

