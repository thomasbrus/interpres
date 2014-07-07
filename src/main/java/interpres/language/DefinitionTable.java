package interpres.language;

import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.ListIterator;

import interpres.ast.AST;
import interpres.ast.Symbol;

import interpres.language.definitions.Definition;

public class DefinitionTable {
  private int scopeLevel;
  private LinkedList<Definition> definitions = new LinkedList<Definition>();

  /**
   * Adds a new entry to the definition table on global scope level.
   *
   * @param name the name of the entry
   * @param value the corresponding AST 
   */
  public void define(String name, AST value) {
    int insertionIndex = 0;

    for (int i = this.definitions.size() - 1; i >= 0; i--) {
      if (this.definitions.get(i).getScopeLevel() == 0) {
        insertionIndex = i + 1; break;
      }
    }

    this.definitions.add(insertionIndex, new Definition(name, value));
  }

  /**
   * Adds a new entry to the definition table on global scope level.
   *
   * @param definition the definition entry
   */
  public void define(Definition definition) {
    this.define(definition.getName(), definition.getValue());
  }

  /**
   * Adds a new entry to the definition table at the current scope level.
   *
   * @param name the name of the entry
   * @param value the corresponding AST 
   */
  public void bind(String name, AST value) {
    this.definitions.addLast(new Definition(name, value, this.scopeLevel));
  }

  /**
   * Looks up the given name in the defintion table. If a definition was found,
   * the corresponding AST of its first occurence is returned. Thus, in case of
   * multiple definitions, the latest definition on the highest scope level will
   * be returned.
   *
   * @param name the name of the entry to look up 
   * @return the corresponding AST if found, null if not found
   */
  public AST lookup(String name) {
    Iterator<Definition> it = this.definitions.descendingIterator();

    while (it.hasNext()) {
      Definition definition = it.next();
      if (definition.getName().equals(name)) return definition.getValue();
    }

    return null;
  }

  /**
   * Looks up the given symbol in the defintion table. If a definition was found,
   * the corresponding AST of its first occurence is returned. Thus, in case of
   * multiple definitions, the latest definition on the highest scope level will
   * be returned.
   *
   * @param symbol the symbol to look up
   * @return the corresponding AST if found, null if not found
   */
  public AST lookup(Symbol symbol) {
    return this.lookup(symbol.getName());
  }

  /**
   * Determines whether or not a definition with a given name exists in the 
   * definition table.
   *
   * @param name the name of the entry to look up
   * @return boolean that indicates whether the look up was successful
   */
  public boolean contains(String name) {
    return this.definitions.stream().anyMatch(definition ->
      definition.getName().equals(name));
  }

  /**
   * Determines whether or not a definition with a given name exists in the 
   * definition table.
   *
   * @param symbol the symbol to look up
   * @return boolean that indicates whether the look up was successful
   */
  public boolean contains(Symbol symbol) {
    return this.contains(symbol.getName());
  }

  /**
   * Enters a new scope.
   */
  public void enterScope() {
    this.scopeLevel++;
  }

  /**
   * Leaves the current scope. Definitions at this scope level are removed.
   */
  public void leaveScope() {
    Iterator<Definition> it = this.definitions.descendingIterator();

    while (it.hasNext() && it.next().getScopeLevel() == this.scopeLevel) {
      it.remove();
    }

    this.scopeLevel--;
  }
}


