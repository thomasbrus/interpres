package interpres.language.invocations.interpres;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import interpres.ast.AST;
import interpres.ast.LambdaExpression;
import interpres.ast.ListExpression;
import interpres.ast.QuoteExpression;

import interpres.language.DefinitionTable;
import interpres.language.FormalArgumentsList;

import interpres.language.invocations.Invocation;

public class Lambda extends Invocation {
  /**
   * Constructs a new Lambda object.
   *
   * @param definitionTable the definition table to work with
   * @param arguments the arguments corresponding with this lambda
   */
  public Lambda(DefinitionTable definitionTable, List<AST> arguments) {
    super(definitionTable, arguments);
  }

  /**
   * Generates a new LambdaExpression based on the given arguments.
   *
   * @return LambdaExpression
   */
  public AST invoke() {
    return new interpres.ast.LambdaExpression((lambdaDefinitionTable, actualArguments) -> {
      List<AST> letArguments = new ArrayList<AST>();
      List<AST> localBindingASTs = new ArrayList<AST>();

      FormalArgumentsList formalArgs = new FormalArgumentsList(this.getFormalArgumentAST());
      formalArgs.bindActualArguments(actualArguments);

      for (Map.Entry<AST, AST> binding : formalArgs.getBindings().entrySet()) {
        localBindingASTs.add(binding.getKey());
        localBindingASTs.add(binding.getValue());
      }

      letArguments.add(new QuoteExpression(new ListExpression(localBindingASTs)));
      letArguments.addAll(this.getExpressionASTs());

      return ListExpression.buildFunctionCall("interpres/let", letArguments).evaluate(this.getDefinitionTable());
    });
  }

  private List<AST> getExpressionASTs() {
    return this.getArguments().subList(1, this.getArguments().size());
  }

  private ListExpression getFormalArgumentAST() {
    return (ListExpression) this.getArguments().get(0);
  }
}

