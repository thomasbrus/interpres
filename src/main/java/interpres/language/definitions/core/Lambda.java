package interpres.language.definitions.core;

import java.util.List;
import java.util.stream.Collectors;

import interpres.ast.AST;
import interpres.ast.Symbol;
import interpres.ast.ListExpression;

import interpres.language.definitions.Definition;

import interpres.language.values.Value;
import interpres.language.values.Void;

public class Lambda extends Definition {

  public Lambda() {
    super("core.lambda", new interpres.language.values.Lambda((definitionTable, arguments) -> {
      List<AST> formalArguments = ((ListExpression) arguments.get(0)).getItems();
      List<AST> expressions = arguments.subList(1, arguments.size());

      return new interpres.language.values.Lambda((lambdaDefinitionTable, actualArguments) -> {
        lambdaDefinitionTable.enterScope();

        for (int i = 0; i < formalArguments.size(); i++) {
          String localBindingName = ((Symbol) formalArguments.get(i)).getName();
          Value localBindingValue = actualArguments.get(i).evaluate(lambdaDefinitionTable);
          lambdaDefinitionTable.bind(localBindingName, localBindingValue);
        }

        List<Value> evaluatedExpressions = expressions.stream().map(e ->
          e.evaluate(lambdaDefinitionTable)).collect(Collectors.toList());

        lambdaDefinitionTable.leaveScope();

        return evaluatedExpressions.get(evaluatedExpressions.size() - 1);
      });
    }), 0);
  }

}

