package interpres;

import java.util.List;
import java.util.Iterator;

public class InstructionSequence implements PrintableBytecode, Iterable<String> {
  List<String> instructions;

  public InstructionSequence() {
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
    return "...";
  }
}

