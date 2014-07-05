package interpres.language.definitions.core.list;

import java.util.ArrayList;

import interpres.ast.AST;
import interpres.ast.LambdaExpression;
import interpres.ast.ListExpression;
import interpres.language.definitions.Definition;

public class Concat extends Definition {

  public Concat() {
    super("core.list.concat", new LambdaExpression((definitionTable, arguments) -> {
      java.util.List<AST> concatenatedItems = new ArrayList<AST>();

      for (AST argument : arguments) {
        concatenatedItems.addAll(((ListExpression) argument.evaluate(definitionTable)).getItems());
      }

      return new ListExpression(concatenatedItems);
    }));
  }

}

