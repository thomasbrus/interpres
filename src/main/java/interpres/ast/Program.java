package interpres.ast;

import java.util.List;
import java.util.ArrayList;

import interpres.language.DefinitionTable;

import interpres.language.values.Value;
import interpres.language.values.String;

public class Program extends AST {
  private List<AST> expressions;

  public Program(List<AST> expressions) {
    this.expressions = expressions;
  }

  public Value evaluate(DefinitionTable definitionTable) {
    List<Value> instructions = new ArrayList<Value>();

    for (AST expression : this.expressions) {
      for (java.lang.String instruction : expression.evaluate(definitionTable)) {
        instructions.add(new String(instruction));
      }
    }

    return new interpres.language.values.List(instructions);
  }

  public Value quote() {
    // return this.expressions;
    return null; // FIXME
  }
}
