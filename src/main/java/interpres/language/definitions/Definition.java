package interpres.language.definitions;

import interpres.ast.AST;

public class Definition {
  private String name;
  private AST value;
  private int scopeLevel;

  /**
   * Constructs a new Definition object.
   *
   * @param name the name of the definition
   * @param value the AST corresponding to the definition
   * @param scopeLevel the scope level on which the definition is made
   */
  public Definition(String name, AST value, int scopeLevel) {
    this.name = name;
    this.value = value;
    this.scopeLevel = scopeLevel;
  }

  /**
   * Constructs a new Definition object.
   *
   * @param name the name of the definition
   * @param value the AST corresponding to the definition
   */
  public Definition(String name, AST value) {
    this(name, value, 0);
  }

  /**
   * Returns the name of the definition.
   * 
   * @return name of the definition
   */
  public String getName() { return this.name; }

    /**
   * Returns the AST of the definition.
   * 
   * @return AST of the definition
   */
  public AST getValue() { return this.value; }

    /**
   * Returns the scope level of the definition.
   * 
   * @return scope level of the definition
   */
  public int getScopeLevel() { return this.scopeLevel; }
}

