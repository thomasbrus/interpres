package interpres.language.invocations.core;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import interpres.ast.AST;
import interpres.ast.LambdaExpression;
import interpres.ast.ListExpression;

import interpres.language.DefinitionTable;
import interpres.language.FormalArgumentsList;

import interpres.language.invocations.Invocation;

public class Lambda extends Invocation {
  public Lambda(DefinitionTable definitionTable, List<AST> arguments) {
    super(definitionTable, arguments);
  }

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

      letArguments.add(new ListExpression(localBindingASTs));
      letArguments.addAll(this.getExpressionASTs());

      return ListExpression.buildFunctionCall("core.let", letArguments).evaluate(this.getDefinitionTable());
    });
  }

  private List<AST> getExpressionASTs() {
    return this.getArguments().subList(1, this.getArguments().size());
  }

  private ListExpression getFormalArgumentAST() {
    return (ListExpression) this.getArguments().get(0);
  }
}

