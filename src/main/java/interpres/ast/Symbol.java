package interpres.ast;

import interpres.AsBytecode;

import interpres.language.DefinitionTable;
import interpres.language.SymbolResolver;
import interpres.language.values.Value;

public class Symbol extends AST {
  private String name;

  public Symbol(String name) {
    this.name = name;
  }

  public AsBytecode evaluate(DefinitionTable definitionTable) {
     return new SymbolResolver(definitionTable).resolve(this);
  }

  public String getName() {
    return this.name;
  }
}

