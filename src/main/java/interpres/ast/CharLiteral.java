package interpres.ast;

import java.util.List;
import java.util.ArrayList;

import interpres.language.DefinitionTable;

import interpres.language.values.Value;
import interpres.language.values.Character;


public class CharLiteral extends AST {
  private java.lang.Character literal;

  public CharLiteral(java.lang.Character literal) {
    this.literal = literal;
  }

  public Value evaluate(DefinitionTable definitionTable) {
    return ListExpression.buildFunctionCall("asm.loadc", new QuotedExpression(this))
      .evaluate(definitionTable);
  }

  public java.lang.Character getLiteral() {
    return this.literal;
  }

  public Value quote() {
    return new interpres.language.values.Character(this.literal);
  }
}

