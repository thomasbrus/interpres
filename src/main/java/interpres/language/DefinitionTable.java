package interpres.language;

import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.ListIterator;

import interpres.ast.AST;
import interpres.language.values.Value;
import interpres.language.definitions.Definition;

public class DefinitionTable {
  private int scopeLevel;
  private LinkedList<Definition> definitions = new LinkedList<Definition>();

  public void define(String name, Value value) {
    int insertionIndex = 0;

    for (int i = this.definitions.size() - 1; i >= 0; i--) {
      if (this.definitions.get(i).getScopeLevel() == 0) {
        insertionIndex = i + 1; break;
      }
    }

    this.definitions.add(insertionIndex, new Definition(name, value, 0));
  }

  public void define(Definition definition) {
    this.define(definition.getName(), definition.getValue());
  }

  public void bind(String name, Value value) {
    this.definitions.addLast(new Definition(name, value, this.scopeLevel));
  }

  public Value lookup(String name) {
    Iterator<Definition> it = this.definitions.descendingIterator();

    while (it.hasNext()) {
      Definition definition = it.next();
      if (definition.getName().equals(name)) return definition.getValue();
    }

    return null;
  }

  public boolean contains(String name) {
    return this.definitions.stream().anyMatch(definition ->
      definition.getName().equals(name));
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


