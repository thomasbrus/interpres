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

public class Map extends Invocation {
  private LambdaExpression lambda;
  private ListExpression list;

  /**
   * Creates a new Map object.
   *
   * @param definitionTable the definition table to work with
   * @param arguments the arguments corresponding with this Map
   */
  public Map(DefinitionTable definitionTable, java.util.List<AST> arguments) {
    super(definitionTable, arguments);
    this.lambda = (LambdaExpression) this.getLambdaAST().evaluate(definitionTable);
    this.list = (ListExpression) this.getListAST().evaluate(definitionTable);
  }

  /**
   * Invokes the map expression and generates the corresponding
   * AST.
   *
   * @return AST corresponding with the Map expression
   */
  public ListExpression invoke() {
    return new ListExpression(this.list.getItems().stream().map(item -> {
      return this.lambda.getFunction().apply(
        this.getDefinitionTable(), Arrays.asList(new QuoteExpression(item))
      );
    }).collect(Collectors.toList()));
  }

  private AST getLambdaAST() {
    return this.getArguments().get(0);
  }

  private AST getListAST() {
    return this.getArguments().get(1);
  }
}

