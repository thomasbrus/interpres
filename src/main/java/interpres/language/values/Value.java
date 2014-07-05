package interpres.language.values;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.io.PrintStream;

import interpres.AsInstructionSequence;
import interpres.ast.AST;
import interpres.language.DefinitionTable;

public abstract class Value implements AsInstructionSequence {
  public List<java.lang.String> instructionSequence() {
    return new ArrayList<java.lang.String>();
  }

  public Value getValue() {
    return this;
  }
}

