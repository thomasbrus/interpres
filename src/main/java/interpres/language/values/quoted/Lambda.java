package interpres.language.values.quoted;

import java.util.List;
import java.util.function.BiFunction;

import interpres.ast.AST;
import interpres.language.DefinitionTable;
import interpres.language.values.Value;

public class Lambda extends interpres.language.values.Lambda implements Unquotable {
  private AST lambdaAST;

  public Lambda(AST unquotedAST, BiFunction<DefinitionTable, List<AST>, Value> function) {
    super(function);
    this.lambdaAST = lambdaAST;
  }

  public AST getUnquotedAST() {
    return this.lambdaAST;
  }
}

