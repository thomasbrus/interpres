package interpres.ast;

import java.util.List;
import interpres.definitions.DefinitionTable;
import interpres.instructions.PrintableInstructionSequence;

public abstract class AST {
  public abstract PrintableInstructionSequence evaluate(DefinitionTable definitionTable);
  public abstract Object quote();
  // FIXME: Should throw UnsupportedOperationException
  public Object unquote(DefinitionTable definitionTable) { return null; }
}
