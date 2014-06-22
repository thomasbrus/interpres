package interpres.definitions;

import interpres.instructions.PrintableInstructionSequence;

public class Definition {
  private String name;
  private PrintableInstructionSequence value;
  private int scopeLevel;

  public Definition(String name, PrintableInstructionSequence value, int scopeLevel) {
    this.name = name;
    this.value = value;
    this.scopeLevel = scopeLevel;
  }

  public String getName() { return this.name; }
  public PrintableInstructionSequence getValue() { return this.value; }
  public int getScopeLevel() { return this.scopeLevel; }
}

