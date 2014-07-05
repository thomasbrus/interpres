package interpres.ast;

import java.util.List;
import java.util.Collections;
import java.util.Arrays;
import java.util.function.BiFunction;

import interpres.language.DefinitionTable;

public class LambdaExpression extends AST {
  private BiFunction<DefinitionTable, List<AST>, AST> function;

  public LambdaExpression(BiFunction<DefinitionTable, List<AST>, AST> function) {
    this.function = function;
  }

  public AST evaluate(DefinitionTable definitionTable) {
    return this.function.apply(definitionTable, Collections.emptyList());
  }

  public BiFunction<DefinitionTable, List<AST>, AST> getFunction() {
    return this.function;
  }

  public List<String> instructionSequence() {
    return Arrays.asList(this.function.toString());
  }
}


