package interpres.ast;

import java.util.List;
import java.util.ArrayList;

import interpres.language.DefinitionTable;

import interpres.language.values.Value;
import interpres.language.values.String;

public class StringLiteral extends AST {
  private java.lang.String literal;

  public StringLiteral(java.lang.String literal) {
    this.literal = literal;
  }

  public Value evaluate(DefinitionTable definitionTable) {
    List<Value> instructions = new ArrayList<Value>();

    for (int i = literal.length() - 1; i >= 0; i--) {
      instructions.add(new String("LOADL " + (int) literal.charAt(i)));
    }

    return new interpres.language.values.List(instructions);
  }

  public String quote() {
    return new String(this.literal);
  }
}

