package interpres.ast;

import java.util.List;



import interpres.language.DefinitionTable;
import interpres.language.SymbolResolver;

public class Symbol extends AST {
  private String name;

  public Symbol(String name) {
    this.name = name;
  }

  public AST evaluate(DefinitionTable definitionTable) {
     return new SymbolResolver(definitionTable).resolve(this);
  }

  public String getName() {
    return this.name;
  }
}

