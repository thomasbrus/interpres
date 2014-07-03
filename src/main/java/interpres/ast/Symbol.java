package interpres.ast;

import interpres.language.DefinitionTable;
import interpres.language.SymbolResolver;
import interpres.language.values.Value;
import interpres.language.values.quoted.Quoted;

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

  public Quoted quote() {
    try {
      return new interpres.language.values.quoted.Integer(this, Integer.parseInt(this.name));
    } catch (NumberFormatException e) {
      return new interpres.language.values.quoted.Symbol(this, this.name);
    }
  }
}

