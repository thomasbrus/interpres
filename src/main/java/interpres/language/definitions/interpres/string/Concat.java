package interpres.language.definitions.interpres.string;

import java.util.List;
import java.util.ArrayList;

import interpres.ast.AST;
import interpres.ast.StringValue;
import interpres.ast.LambdaExpression;

import interpres.language.definitions.Definition;

public class Concat extends Definition {

  public Concat() {
    super("interpres/string/concat", new LambdaExpression((definitionTable, arguments) -> {
      List<String> strings = new ArrayList<String>();

      for (AST argument : arguments) {
        StringValue concatenable = (StringValue) argument.evaluate(definitionTable);
        strings.add(concatenable.getLiteral());
      }

      return new StringValue(String.join("", strings));
    }));
  }

}

