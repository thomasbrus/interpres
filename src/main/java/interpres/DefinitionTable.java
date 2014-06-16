package interpres;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.function.BiFunction;

import interpres.ast.AST;

public class DefinitionTable {
  // TODO: Allow non-lambda definitions
  // TODO: Dynamically resolve names that matches [0-9]+ to IntegerLiterals

  private HashMap<String, BiFunction<DefinitionTable, List<AST>, Object>> definitions;

  public DefinitionTable() {
    this.definitions = new HashMap<String, BiFunction<DefinitionTable, List<AST>, Object>>();
  }

  public void define(String name, BiFunction<DefinitionTable, List<AST>, Object> definition) {
    this.definitions.put(name, definition);
  }

  public BiFunction<DefinitionTable, List<AST>, Object> lookup(String name) {
    return this.definitions.get(name);
  }

  private boolean canResolve(String name) {
    return this.definitions.containsKey(name);
  }
}

