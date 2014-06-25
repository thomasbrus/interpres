package interpres.language.definitions.core;

import java.util.List;
import java.util.ArrayList;
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
        List<AST> letArguments = new ArrayList<AST>();
        List<AST> localBindingASTs = new ArrayList<AST>();

        for (int i = 0; i < formalArguments.size(); i++) {
          localBindingASTs.add(formalArguments.get(i));
          localBindingASTs.add(actualArguments.get(i));
        }

        letArguments.add(new ListExpression(localBindingASTs));
        letArguments.addAll(expressions);

        return ListExpression.buildFunctionCall(
          "core.let", letArguments
        ).evaluate(definitionTable);
      });
    }));
  }

}

