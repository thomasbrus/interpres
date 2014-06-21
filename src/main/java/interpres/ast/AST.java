package interpres.ast;

import java.util.List;
import interpres.DefinitionTable;
import interpres.PrintableBytecode;

public abstract class AST {
  public abstract PrintableBytecode evaluate(DefinitionTable definitionTable);
}

