package interpres.language.definitions.core;

import java.util.Arrays;

import interpres.ast.AST;
import interpres.language.definitions.Definition;
import interpres.language.values.Lambda;

public class Quote extends Definition {

  public Quote() {
    super("core.quote", new Lambda((definitionTable, arguments) -> {
      AST quotable = arguments.get(0);
      return quotable.quote();
    }), 0);
  }

}

