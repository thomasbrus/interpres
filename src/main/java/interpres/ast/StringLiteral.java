package interpres.ast;

import java.util.List;
import java.util.ArrayList;

import interpres.DefinitionTable;

public class StringLiteral extends AST {
  private String literal;

  public StringLiteral(String literal) {
    this.literal = literal;
  }

  public List<Object> evaluate(DefinitionTable definitionTable) {
    List<Object> instructions = new ArrayList<Object>();

    for (int i = literal.length() - 1; i >= 0; i--) {
      instructions.add("LOADL " + (int) literal.charAt(i));
    }

    return instructions;
  }

  public String toString() {
    return this.literal.toString();
  }
}
