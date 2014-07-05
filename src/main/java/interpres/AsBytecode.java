package interpres;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.io.PrintStream;

public interface AsBytecode extends Iterable<java.lang.String> {
  public List<java.lang.String> bytecodeSequence();

  default public Iterator<java.lang.String> iterator() {
    return this.bytecodeSequence().iterator();
  }

  default public void printBytecode(PrintStream printStream) {
    for (java.lang.String bytecode : this.bytecodeSequence()) {
      printStream.println(bytecode);
    }
  }
}

