package interpres.ast;

import java.util.List;
import java.util.Arrays;

import interpres.language.DefinitionTable;
import interpres.language.SymbolResolver;

public class Symbol extends AST {
  private String name;

  /**
   * Constructs a new Symbol.
   *
   * @param name the name of the Symbol
   */
  public Symbol(String name) {
    this.name = name;
  }

  /**
   * Generates an AST for this Symbol.
   *
   * @param definitionTable the definition table used while evaluating the object
   */
  public AST evaluate(DefinitionTable definitionTable) {
     return new SymbolResolver(definitionTable).resolve(this);
  }

  /**
   * Returnes the name of this Symbol.
   *
   * @return the name of this object
   */
  public String getName() {
    return this.name;
  }

  /**
   * Returns the instructions corresponding with this object.
   *
   * @return List of Strings containing the instructions belonging to this object
   */
  public List<String> instructionSequence() {
    return Arrays.asList(this.name);
  }
}

