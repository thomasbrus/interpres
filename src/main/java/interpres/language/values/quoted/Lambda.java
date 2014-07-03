package interpres.language.values.quoted;

import java.util.List;
import java.util.function.BiFunction;

import interpres.ast.AST;
import interpres.language.DefinitionTable;
import interpres.language.values.Value;

public class Lambda extends Quoted {
  public Lambda(AST unquotedAST, interpres.language.values.Lambda lambdaValue) {
    super(unquotedAST, lambdaValue);
  }

  public BiFunction<DefinitionTable, List<AST>, Value> getFunction() {
    return ((interpres.language.values.Lambda) this.getQuotedValue()).getFunction();
  }
}

