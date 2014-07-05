package interpres.language.definitions.asm;

import java.util.Collections;

import interpres.ast.LambdaExpression;
import interpres.ast.ListExpression;
import interpres.language.definitions.Definition;

public class Footer extends Definition {

  public Footer() {
    super("asm.footer", new LambdaExpression((definitionTable, arguments) -> {
      return new ListExpression(Collections.emptyList());
    }));
  }

}

