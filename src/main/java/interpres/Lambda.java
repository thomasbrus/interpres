package interpres;

import java.util.List;
import java.util.Iterator;
import java.util.function.BiFunction;
import java.util.Collections;

import interpres.ast.AST;

public class Lambda implements PrintableBytecode {
  BiFunction<DefinitionTable, List<AST>, InstructionSequence> fn;

  public Lambda(BiFunction<DefinitionTable, List<AST>, InstructionSequence> fn) {
    this.fn = fn;
  }

  public InstructionSequence apply(DefinitionTable dt, List<AST> arguments) {
    return fn.apply(dt, arguments);
  }
  
  public Iterator<String> iterator() {
    return Collections.emptyIterator();
  }

  public String getBytecode() {
    return "";
  }
}

