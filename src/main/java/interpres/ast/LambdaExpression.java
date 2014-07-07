package interpres.ast;

import java.util.List;
import java.util.Collections;
import java.util.Arrays;
import java.util.function.BiFunction;

import interpres.language.DefinitionTable;

public class LambdaExpression extends AST {
  private BiFunction<DefinitionTable, List<AST>, AST> function;

  /**
   * Constructs a new LambdaExpression.
   *
   * @param function the actual function
   */
  public LambdaExpression(BiFunction<DefinitionTable, List<AST>, AST> function) {
    this.function = function;
  }

  /**
   * Generates an AST for this LambdaExpression.
   *
   * @param definitionTable the definition table used while evaluating the object
   */
  public AST evaluate(DefinitionTable definitionTable) {
    return this.function.apply(definitionTable, Collections.emptyList());
  }

  /**
   * Returnes the actual value of this LambdaExpression.
   *
   * @return the actual BiFunction
   */
  public BiFunction<DefinitionTable, List<AST>, AST> getFunction() {
    return this.function;
  }

  /**
   * Returns the instructions corresponding with this object.
   *
   * @return List of Strings containing the instructions belonging to this object
   */
  public List<String> instructionSequence() {
    return Arrays.asList(this.function.toString());
  }
}


