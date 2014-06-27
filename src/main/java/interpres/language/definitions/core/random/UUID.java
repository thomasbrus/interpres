package interpres.language.definitions.core.random;

import interpres.language.definitions.Definition;
import interpres.language.values.Lambda;
import interpres.language.values.String;

public class UUID extends Definition {

  public UUID() {
    super("core.random.uuid", new Lambda((definitionTable, arguments) -> {
      return new String(java.util.UUID.randomUUID().toString());
    }));
  }

}


