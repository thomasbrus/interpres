package interpres.ast;

import java.util.List;
import interpres.language.DefinitionTable;
import interpres.language.values.Value;

public abstract class AST {
  public abstract Value evaluate(DefinitionTable definitionTable);
  public abstract Value quote();
  // FIXME: Should throw UnsupportedOperationException
  public Object unquote(DefinitionTable definitionTable) { return null; }
}
