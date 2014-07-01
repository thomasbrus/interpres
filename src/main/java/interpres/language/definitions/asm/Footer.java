package interpres.language.definitions.asm;

import java.util.Collections;

import interpres.language.definitions.Definition;

import interpres.language.values.List;
import interpres.language.values.Lambda;

public class Footer extends Definition {

  public Footer() {
    super("asm.footer", new Lambda((definitionTable, arguments) -> {
      return new List(Collections.emptyList());
    }));
  }

}

