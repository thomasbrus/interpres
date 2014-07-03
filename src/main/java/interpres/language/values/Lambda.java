package interpres.language.values;

import java.util.List;
import java.util.function.BiFunction;

import interpres.ast.AST;
import interpres.language.DefinitionTable;

public class Lambda extends Value {
  private BiFunction<DefinitionTable, List<AST>, Value> function;
  private AST lambdaAST;

  public Lambda(BiFunction<DefinitionTable, List<AST>, Value> function) {
    this(function, null);
  }

  public Lambda(BiFunction<DefinitionTable, List<AST>, Value> function, AST lambdaAST) {
    this.function = function;
    this.lambdaAST = lambdaAST;
  }

  public BiFunction<DefinitionTable, List<AST>, Value> getFunction() {
    return this.function;
  }

  public AST getUnquotedAST() {
    return this.lambdaAST;
  }
}

