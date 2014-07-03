package interpres.ast;

import interpres.language.DefinitionTable;
import interpres.language.SymbolResolver;
import interpres.language.values.Value;

public class Symbol extends AST {
  private String name;

  public Symbol(String name) {
    this.name = name;
  }

  public Value evaluate(DefinitionTable definitionTable) {
     return new SymbolResolver(definitionTable).resolve(this);
  }

  public String getName() {
    return this.name;
  }

  public Value quote() {
    try {
      return new interpres.language.values.Integer(Integer.parseInt(this.name), this);
    } catch (NumberFormatException e) {
      return new interpres.language.values.Symbol(this.name, this);
    }
  }
}

