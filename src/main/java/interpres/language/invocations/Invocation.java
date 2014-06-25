package interpres.language.invocations;

import java.util.List;

import interpres.ast.AST;
import interpres.language.DefinitionTable;
import interpres.language.values.Value;

public abstract class Invocation {
  private DefinitionTable definitionTable;
  private List<AST> arguments;

  public Invocation(DefinitionTable definitionTable, List<AST> arguments) {
    this.definitionTable = definitionTable;
    this.arguments = arguments;
  }

  public List<AST> getArguments() {
    return this.arguments;
  }

  public DefinitionTable getDefinitionTable() {
    return this.definitionTable;
  }

  public abstract Value invoke();
}

