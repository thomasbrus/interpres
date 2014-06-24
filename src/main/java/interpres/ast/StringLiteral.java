package interpres.ast;

import java.util.List;
import java.util.ArrayList;

import interpres.language.DefinitionTable;
import interpres.language.values.Value;

public class StringLiteral extends AST {
  private String literal;

  public StringLiteral(String literal) {
    this.literal = literal;
  }

  public Value evaluate(DefinitionTable definitionTable) {
    List<Object> instructions = new ArrayList<Object>();

    for (int i = literal.length() - 1; i >= 0; i--) {
      instructions.add("LOADL " + (int) literal.charAt(i));
    }

    return new interpres.language.values.List(instructions);
  }

  public String quote() {
    return this.literal;
  }
}

