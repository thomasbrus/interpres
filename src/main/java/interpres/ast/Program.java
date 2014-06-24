package interpres.ast;

import java.util.List;
import java.util.ArrayList;

import interpres.language.DefinitionTable;
import interpres.language.values.Value;

public class Program extends AST {
  private List<AST> expressions;

  public Program(List<AST> expressions) {
    this.expressions = expressions;
  }

  public Value evaluate(DefinitionTable definitionTable) {
    List<Object> instructions = new ArrayList<Object>();

    for (AST expression : this.expressions) {
      for (String instruction : expression.evaluate(definitionTable)) {
        instructions.add(instruction);
      }
    }

    return new interpres.language.values.List(instructions);
  }

  public List<AST> quote() {
    return this.expressions;
  }
}
