package interpres.ast;

import java.util.List;
import interpres.DefinitionTable;

public abstract class AST {
  public abstract Object evaluate(DefinitionTable definitionTable);
}

