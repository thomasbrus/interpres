package interpres.language.definitions;

import interpres.AsInstructionSequence;

public class Definition {
  private String name;
  private AsInstructionSequence value;
  private int scopeLevel;

  public Definition(String name, AsInstructionSequence value, int scopeLevel) {
    this.name = name;
    this.value = value;
    this.scopeLevel = scopeLevel;
  }

  public Definition(String name, AsInstructionSequence value) {
    this(name, value, 0);
  }

  public String getName() { return this.name; }
  public AsInstructionSequence getValue() { return this.value; }
  public int getScopeLevel() { return this.scopeLevel; }
}


