package interpres.language.definitions.core.string;

import java.util.List;
import java.util.ArrayList;

import interpres.ast.AST;
import interpres.ast.StringValue;
import interpres.ast.LambdaExpression;

import interpres.language.definitions.Definition;

public class Concat extends Definition {

  public Concat() {
    super("core.string.concat", new LambdaExpression((definitionTable, arguments) -> {
      List<java.lang.String> strings = new ArrayList<java.lang.String>();

      for (AST argument : arguments) {
        StringValue concatenable = (StringValue) argument.evaluate(definitionTable);
        strings.add(concatenable.getLiteral());
      }

      return new StringValue(java.lang.String.join("", strings));
    }));
  }

}

