package interpres.ast;

import java.util.List;
import interpres.language.DefinitionTable;
import interpres.language.values.Value;

public abstract class AST {
  public abstract Value evaluate(DefinitionTable definitionTable);

  public Value quote() {
    throw new UnsupportedOperationException("Quoting is not supported for " + this);
  }

  public Value unquote(DefinitionTable definitionTable) {
    throw new UnsupportedOperationException("Unquoting is not supported for " + this);
  }
}

