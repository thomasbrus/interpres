package interpres.language.definitions.asm;

import java.util.Collections;

import interpres.ast.LambdaExpression;
import interpres.ast.ListExpression;
import interpres.language.definitions.Definition;

public class Header extends Definition {

  public Header() {
    super("asm.header", new LambdaExpression((definitionTable, arguments) -> {
      return new ListExpression(Collections.emptyList());
    }, 0));
  }

}

