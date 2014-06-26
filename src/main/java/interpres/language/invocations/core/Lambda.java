package interpres.language.invocations.core;

import java.util.List;
import java.util.ArrayList;

import interpres.ast.AST;
import interpres.ast.ListExpression;

import interpres.language.DefinitionTable;

import interpres.language.values.Value;
import interpres.language.invocations.Invocation;

public class Lambda extends Invocation {
  public Lambda(DefinitionTable definitionTable, List<AST> arguments) {
    super(definitionTable, arguments);
  }

  public Value invoke() {
    return new interpres.language.values.Lambda((lambdaDefinitionTable, actualArguments) -> {
      List<AST> letArguments = new ArrayList<AST>();
      List<AST> localBindingASTs = new ArrayList<AST>();

      for (int i = 0; i < this.getFormalArguments().size(); i++) {
        localBindingASTs.add(this.getFormalArguments().get(i));
        localBindingASTs.add(actualArguments.get(i));
      }

      letArguments.add(new ListExpression(localBindingASTs));
      letArguments.addAll(this.getExpressionASTs());

      return ListExpression.buildFunctionCall(
        "core.let", letArguments
      ).evaluate(this.getDefinitionTable());
    });
  }

  private List<AST> getExpressionASTs() {
    return this.getArguments().subList(1, this.getArguments().size());
  }

  private List<AST> getFormalArguments() {
    return ((ListExpression) this.getArguments().get(0)).getItems();
  }
}

