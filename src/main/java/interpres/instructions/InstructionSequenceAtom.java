package interpres.instructions;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.*;
import java.io.PrintStream;

public class InstructionSequenceAtom<ValueType> extends EmptyInstructionSequenceAtom<ValueType> implements PrintableInstructionSequence, Iterable<String> {
  private ValueType value = null;
  private List<String> instructions = new ArrayList<String>();

  public InstructionSequenceAtom(ValueType value) {
    super(value);
  }

  public InstructionSequenceAtom(List<String> instructions, ValueType value) {
    super(value);
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

