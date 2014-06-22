package interpres.instructions;

import java.util.Iterator;
import java.util.Collections;
import java.io.PrintStream;

public class EmptyInstructionSequence implements PrintableInstructionSequence {
  public Iterator<String> iterator() { return Collections.emptyIterator(); }
  public void printInstructionSequence(PrintStream printStream) {}
  public int length() { return 0; }
}


