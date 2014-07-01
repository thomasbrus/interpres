package interpres.language.definitions.asm;

import java.util.Collections;

import interpres.language.definitions.Definition;

import interpres.language.values.List;
import interpres.language.values.Lambda;

public class Header extends Definition {

  public Header() {
    super("asm.header", new Lambda((definitionTable, arguments) -> {
      return new List(Collections.emptyList());
    }));
  }

}

