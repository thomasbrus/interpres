package interpres.language.definitions.core;

import java.util.Arrays;

import interpres.ast.AST;
import interpres.ast.ListExpression;
import interpres.language.definitions.Definition;

import interpres.language.values.Lambda;
import interpres.language.values.String;
import interpres.language.values.Integer;
import interpres.language.values.List;

public class Quote extends Definition {

  public Quote() {
    super("core.quote", new Lambda((definitionTable, arguments) -> {
      AST quotable = arguments.get(0);

      if (quotable instanceof ListExpression) {
        return new List(((ListExpression) quotable).quote());
      }

      return new String(quotable.quote().toString());
    }), 0);
  }

}

