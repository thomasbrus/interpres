package interpres.language.invocations;

import java.util.List;

import interpres.ast.AST;
import interpres.language.DefinitionTable;

public abstract class Invocation {
  private DefinitionTable definitionTable;
  private List<AST> arguments;

  /**
   * Constructs a new Invocation object.
   * 
   * @param definitionTable the definition table to work with
   * @param arguments the arguments of this invokation
   */
  public Invocation(DefinitionTable definitionTable, List<AST> arguments) {
    this.definitionTable = definitionTable;
    this.arguments = arguments;
  }

  /**
   * Returns the list of arguments of this Invocation.
   * 
   * @return list with arguments
   */
  public List<AST> getArguments() {
    return this.arguments;
  }


  /**
   * Returns the defintion table of this Invocation.
   * 
   * @return definition table
   */
  public DefinitionTable getDefinitionTable() {
    return this.definitionTable;
  }

  
  public abstract AST invoke();
}

