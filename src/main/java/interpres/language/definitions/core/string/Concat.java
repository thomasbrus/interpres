package interpres.language.definitions.core.string;

import java.util.List;
import java.util.ArrayList;

import interpres.ast.AST;
import interpres.ast.StringLiteral;

import interpres.language.definitions.Definition;

import interpres.language.values.Value;
import interpres.language.values.Lambda;
import interpres.language.values.String;

public class Concat extends Definition {

  public Concat() {
    super("core.string.concat", new Lambda((definitionTable, arguments) -> {
      List<java.lang.String> strings = new ArrayList<java.lang.String>();

      for (AST argument : arguments) {
        String concatenable = (String) argument.evaluate(definitionTable).getValue();
        strings.add(concatenable.getLiteral());
      }

      return new StringLiteral(java.lang.String.join("", strings));
    }));
  }

}

