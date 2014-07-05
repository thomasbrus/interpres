package interpres.ast;

import java.util.List;
import java.util.Arrays;

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

  public List<String> instructionSequence() {
    return Arrays.asList(this.name);
  }
}

