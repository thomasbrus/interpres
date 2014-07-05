package interpres.language;

import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.ListIterator;

import interpres.AsBytecode;

import interpres.ast.AST;
import interpres.ast.Symbol;

import interpres.language.definitions.Definition;

public class DefinitionTable {
  private int scopeLevel;
  private LinkedList<Definition> definitions = new LinkedList<Definition>();

  public void define(String name, AsBytecode value) {
    int insertionIndex = 0;

    for (int i = this.definitions.size() - 1; i >= 0; i--) {
      if (this.definitions.get(i).getScopeLevel() == 0) {
        insertionIndex = i + 1; break;
      }
    }

    this.definitions.add(insertionIndex, new Definition(name, value));
  }

  public void define(Definition definition) {
    this.define(definition.getName(), definition.getValue());
  }

  public void bind(String name, AsBytecode value) {
    this.definitions.addLast(new Definition(name, value, this.scopeLevel));
  }

  public AsBytecode lookup(String name) {
    Iterator<Definition> it = this.definitions.descendingIterator();

    while (it.hasNext()) {
      Definition definition = it.next();
      if (definition.getName().equals(name)) return definition.getValue();
    }

    return null;
  }

  public AsBytecode lookup(Symbol symbol) {
    return this.lookup(symbol.getName());
  }

  public boolean contains(String name) {
    return this.definitions.stream().anyMatch(definition ->
      definition.getName().equals(name));
  }

  public boolean contains(Symbol symbol) {
    return this.contains(symbol.getName());
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


