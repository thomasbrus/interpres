package interpres.instructions;

import java.util.Iterator;
import java.io.PrintStream;

public interface PrintableInstructionSequence extends Iterable<String> {
  public void printInstructionSequence(PrintStream printStream);
  public int length();
}

