package interpres.ast;

import java.util.List;
import java.util.Arrays;
import java.util.function.BiFunction;

import interpres.DefinitionTable;

public class Symbol extends AST {
  private String name;

  public Symbol(String name) {
    this.name = name;
  }

  public BiFunction<DefinitionTable, List<AST>, Object> evaluate(DefinitionTable definitionTable) {
    return definitionTable.lookup(this.name);
  }

  public String toString() {
    return this.name.toString();
  }
}
