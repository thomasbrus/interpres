package interpres.language.invocations;

import java.util.List;

import interpres.ast.AST;
import interpres.language.DefinitionTable;

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

  public abstract AST invoke();
}

