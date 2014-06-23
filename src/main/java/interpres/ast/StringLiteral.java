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
    return ListExpression.buildFunctionCall("asm.loads", new QuotedExpression(this)).evaluate(definitionTable);
  }

  public String quote() {
    return this.literal;
  }
}

