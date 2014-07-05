package interpres.language.definitions;

import interpres.AsBytecode;

public class Definition {
  private String name;
  private AsBytecode value;
  private int scopeLevel;

  public Definition(String name, AsBytecode value, int scopeLevel) {
    this.name = name;
    this.value = value;
    this.scopeLevel = scopeLevel;
  }

  public Definition(String name, AsBytecode value) {
    this(name, value, 0);
  }

  public String getName() { return this.name; }
  public AsBytecode getValue() { return this.value; }
  public int getScopeLevel() { return this.scopeLevel; }
}


