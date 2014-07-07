package interpres.language.invocations.interpres.list;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.stream.Collectors;

import interpres.ast.AST;
import interpres.ast.QuoteExpression;
import interpres.ast.LambdaExpression;
import interpres.ast.ListExpression;

import interpres.language.definitions.Definition;
import interpres.language.DefinitionTable;

import interpres.language.invocations.Invocation;

public class Reduce extends Invocation {
  private LambdaExpression lambda;
  private AST initialValue;
  private ListExpression list;

  /**
   * Creates a new Reduce object.
   *
   * @param definitionTable the definition table to work with
   * @param arguments the arguments corresponding with this Reduce
   */
  public Reduce(DefinitionTable definitionTable, java.util.List<AST> arguments) {
    super(definitionTable, arguments);
    this.lambda = (LambdaExpression) this.getLambdaAST().evaluate(definitionTable);
    this.initialValue = this.getInitialValueAST().evaluate(definitionTable);
    this.list = (ListExpression) this.getListAST().evaluate(definitionTable);
  }

  /**
   * Invokes the reduce expression and generates the corresponding
   * AST.
   *
   * @return AST corresponding with the Reduce expression
   */
  public AST invoke() {
    return this.list.getItems().stream().reduce(
      this.initialValue,
      (memo, item) -> this.lambda.getFunction().apply(
        this.getDefinitionTable(),
        Arrays.asList(new QuoteExpression(memo), new QuoteExpression(item))
      )
    );
  }

  private AST getLambdaAST() {
    return this.getArguments().get(0);
  }

  private AST getInitialValueAST() {
    return this.getArguments().get(1);
  }

  private AST getListAST() {
    return this.getArguments().get(2);
  }
}

