package interpres.ast;

import java.util.List;
import java.util.Arrays;

public class Reference extends AST {
  private String name;

  // public static class IrresolvableReference extends Exception {
  //   private static final long serialVersionUID = 1L;

  //   public IrresolvableReference(String referenceName) {
  //     super(String.format("Could not resolve '%s', no definition was found", referenceName));
  //   }
  // }

  public Reference(String name) {
    this.name = name;
  }

  public AST resolve() {
    // 1. Try and fetch the definition from the definition table
    // if (definitionTable.isDefined(this.name)
    //   return definitionTable.lookup(this.name);

    // 2. In case no definition was found, try to resolve dynamically
    if (this.name.matches("[-+]?[1-9]+[0-9]*"))
      return new IntegerLiteral(Integer.parseInt(this.name));

    // 3. Could not be resolved, throw error
    // throw new IrresolvableReference(this.name);

    return null;
  }

  public List<Object> evaluate() {
    return resolve().evaluate();
  }
}
