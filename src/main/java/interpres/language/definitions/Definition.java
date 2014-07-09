package interpres.language.definitions;

import interpres.ast.AST;

public class Definition {
  private String name;
  private AST value;
  private int scopeLevel;

  public Definition(String name, AST value, int scopeLevel) {
    this.name = name;
    this.value = value;
    this.scopeLevel = scopeLevel;
  }

  public Definition(String name, AST value) {
    this(name, value, 0);
  }

  public String getName() { return this.name; }
  public AST getValue() { return this.value; }
  public int getScopeLevel() { return this.scopeLevel; }
}

