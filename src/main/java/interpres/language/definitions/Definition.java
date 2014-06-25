package interpres.language.definitions;

import interpres.language.values.Value;

public class Definition {
  private String name;
  private Value value;
  private int scopeLevel;

  public Definition(String name, Value value, int scopeLevel) {
    this.name = name;
    this.value = value;
    this.scopeLevel = scopeLevel;
  }

  public Definition(String name, Value value) {
    this(name, value, 0);
  }

  public String getName() { return this.name; }
  public Value getValue() { return this.value; }
  public int getScopeLevel() { return this.scopeLevel; }
}


