package interpres;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.function.BiFunction;

import interpres.ast.AST;

public class Definition {
  private String id;
  private Object definition;
  private int level;
  private Definition previous;

  public Definition(String id, Object definition, int level, Definition previous) {
    this.id = id;
    this.definition = definition;
    this.level = level;
    this.previous = previous;
  }

  public String getId(){
    return this.id;
  }

  public Object getDefintion() {
    return this.definition;
  }

  public int getLevel(){
    return this.level;
  }

  public Definition getPrevious(){
    return this.previous;
  }

  public void setPrevious(Definition newPrevious){
    this.previous = newPrevious;
  }
}

