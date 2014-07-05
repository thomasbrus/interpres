package interpres;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.io.PrintStream;

import interpres.language.values.Value;

public interface AsInstructionSequence extends Iterable<java.lang.String> {
  public List<java.lang.String> instructionSequence();

  default public Iterator<java.lang.String> iterator() {
    return this.instructionSequence().iterator();
  }

  default public void printInstructionSequence(PrintStream printStream) {
    for (java.lang.String bytecode : this.instructionSequence()) {
      printStream.println(bytecode);
    }
  }

  default public Value getValue() {
    throw new UnsupportedOperationException(
      "Unable to convert " + this + " to interpres.language.values.Value"
    );
  };
}

