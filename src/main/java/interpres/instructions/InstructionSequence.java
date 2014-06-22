package interpres.instructions;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.*;
import java.io.PrintStream;

public class InstructionSequence implements PrintableInstructionSequence {
  private List<String> instructions = new ArrayList<String>();

  public InstructionSequence() {}

  public InstructionSequence(List<String> instructions) {
    this.instructions = instructions;
  }

  public void add(String instruction) {
    this.instructions.add(instruction);
  }

  public Iterator<String> iterator() {
    return this.instructions.iterator();
  }

  public void printInstructionSequence(PrintStream printStream) {
    this.instructions.stream().forEach((instruction) -> printStream.println(instruction));
  }

  public int length() {
    return this.instructions.size();
  }
}

