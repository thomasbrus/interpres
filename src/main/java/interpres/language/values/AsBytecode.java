package interpres.language.values;

import java.util.Iterator;
import java.util.List;

public interface AsBytecode extends Iterable<java.lang.String> {
  public List<java.lang.String> bytecodeSequence();
  public int length();
}

