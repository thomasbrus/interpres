package interpres.language.values;

import java.util.Iterator;
import java.util.List;
import java.io.PrintStream;

public interface AsBytecode extends Iterable<java.lang.String> {
  public List<java.lang.String> bytecodeSequence();
  public void printBytecode(PrintStream printStream);
}

