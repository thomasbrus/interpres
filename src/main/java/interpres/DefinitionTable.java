package interpres;

import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.ListIterator;

import interpres.ast.AST;

public class DefinitionTable {
  private int scopeLevel;
  private LinkedList<Definition> definitions = new LinkedList<Definition>();

  private static class Definition {
    private String name;
    private PrintableBytecode value;
    private int scopeLevel;

    public Definition(String name, PrintableBytecode value, int scopeLevel) {
      this.name = name;
      this.value = value;
      this.scopeLevel = scopeLevel;
    }

    public String getName() { return this.name; }
    public PrintableBytecode getValue() { return this.value; }
    public int getScopeLevel() { return this.scopeLevel; }
  }

  public void define(String name, PrintableBytecode value) {
    int insertionIndex = 0;

    for (int i = this.definitions.size() - 1; i >= 0; i--) {
      if (this.definitions.get(i).getScopeLevel() == 0) {
        insertionIndex = i + 1; break;
      }
    }

    this.definitions.add(insertionIndex, new Definition(name, value, 0));
  }

  public void bind(String name, PrintableBytecode value) {
    this.definitions.addLast(new Definition(name, value, this.scopeLevel));
  }

  public PrintableBytecode lookup(String name) {
    Iterator<Definition> it = this.definitions.descendingIterator();

    while (it.hasNext()) {
      Definition definition = it.next();
      if (definition.getName().equals(name)) return definition.getValue();
    }

    return null;
  }

  public void enterScope() {
    this.scopeLevel++;
  }

  public void leaveScope() {
    Iterator<Definition> it = this.definitions.descendingIterator();

    while (it.hasNext() && it.next().getScopeLevel() == this.scopeLevel) {
      it.remove();
    }

    this.scopeLevel--;
  }
}

