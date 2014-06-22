package interpres.definitions.core;

import java.util.List;
import java.util.stream.Collectors;

import interpres.ast.AST;
import interpres.ast.Symbol;
import interpres.ast.ListExpression;

import interpres.definitions.Definition;
import interpres.instructions.EmptyInstructionSequenceLambda;
import interpres.instructions.PrintableInstructionSequence;

public class Lambda extends Definition {

  public Lambda() {
    super("core.lambda", new EmptyInstructionSequenceLambda((definitionTable, arguments) -> {
      List<AST> formalArguments = ((ListExpression) arguments.get(0)).getItems();
      List<AST> expressions = arguments.subList(1, arguments.size());

      return new EmptyInstructionSequenceLambda((lambdaDefinitionTable, actualArguments) -> {
        lambdaDefinitionTable.enterScope();

        for (int i = 0; i < formalArguments.size(); i++) {
          String localBindingName = ((Symbol) formalArguments.get(i)).getName();
          PrintableInstructionSequence localBindingValue = actualArguments.get(i).evaluate(lambdaDefinitionTable);
          lambdaDefinitionTable.bind(localBindingName, localBindingValue);
        }

        List<PrintableInstructionSequence> evaluatedExpressions = expressions.stream().map(e ->
          e.evaluate(lambdaDefinitionTable)).collect(Collectors.toList());

        lambdaDefinitionTable.leaveScope();

        return evaluatedExpressions.get(evaluatedExpressions.size() - 1);
      });
    }), 0);
  }

}

