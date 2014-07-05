package interpres.ast;

import java.util.List;

import interpres.AsInstructionSequence;

import interpres.language.DefinitionTable;
import interpres.language.SymbolResolver;
import interpres.language.values.Value;

public class Symbol extends AST {
  private String name;

  public Symbol(String name) {
    this.name = name;
  }

  public AsInstructionSequence evaluate(DefinitionTable definitionTable) {
     return new SymbolResolver(definitionTable).resolve(this);
  }

  public String getName() {
    return this.name;
  }

  public Value getValue() {
    try {
      Integer integer = Integer.parseInt(this.name);
      return new interpres.language.values.Integer(integer);
    } catch (NumberFormatException e) {
      return new interpres.language.values.Symbol(this.name);
    }
  }
}

