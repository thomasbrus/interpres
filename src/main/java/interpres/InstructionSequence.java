package interpres;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.*;

public class InstructionSequence implements PrintableBytecode, Iterable<String> {
  List<String> instructions;

  public InstructionSequence() {
    this(new ArrayList<String>());
  }

  public InstructionSequence(List<String> instructions) {
    this.instructions = instructions;
  }

  public void add(String instruction) {
    this.instructions.add(instruction);
  }

  public Iterator<String> iterator() {
    return this.instructions.iterator();
  }

  public String getBytecode() {
    String newline = System.getProperty("line.separator");
    return this.instructions.stream().collect(Collectors.joining(newline));
  }
}

