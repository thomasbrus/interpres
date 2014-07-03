package interpres.language.values.quoted;

import java.util.List;
import java.util.function.BiFunction;

import interpres.ast.AST;
import interpres.language.DefinitionTable;
import interpres.language.values.Value;

public class Lambda extends Quoted {
  public Lambda(AST unquotedAST, BiFunction<DefinitionTable, List<AST>, Value> function) {
    super(unquotedAST, new interpres.language.values.Lambda(function));
  }

  public BiFunction<DefinitionTable, List<AST>, Value> getFunction() {
    return ((interpres.language.values.Lambda) this.getQuotedValue()).getFunction();
  }
}

