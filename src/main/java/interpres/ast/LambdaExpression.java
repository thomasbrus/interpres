package interpres.ast;

import java.util.List;
import java.util.Collections;
import java.util.Arrays;
import java.util.function.BiFunction;

import interpres.language.DefinitionTable;

public class LambdaExpression extends AST {
  private BiFunction<DefinitionTable, List<AST>, AST> function;
  private int arity;

  public LambdaExpression(BiFunction<DefinitionTable, List<AST>, AST> function, int arity) {
    this.function = function;
    this.arity = arity;
  }

  public AST evaluate(DefinitionTable definitionTable) {
    return this.function.apply(definitionTable, Collections.emptyList());
  }

  public BiFunction<DefinitionTable, List<AST>, AST> getFunction() {
    return this.function;
  }

  public int getArity() {
    return arity;
  }

  public List<String> instructionSequence() {
    return Arrays.asList(this.function.toString());
  }
}


