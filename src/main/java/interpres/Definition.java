package interpres;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.function.BiFunction;

import interpres.ast.AST;

public class Definition {
  private String id;
  private Object value;
  private int scopeLevel;
  private Definition previous;

  public Definition(String id, Object value, int scopeLevel, Definition previous) {
    this.id = id;
    this.value = value;
    this.scopeLevel = scopeLevel;
    this.previous = previous;
  }

  public String getId(){
    return this.id;
  }

  public Object getValue() {
    return this.value;
  }

  public int getScopeLevel(){
    return this.scopeLevel;
  }

  public Definition getPrevious(){
    return this.previous;
  }

  public void setPrevious(Definition newPrevious){
    this.previous = newPrevious;
  }
}

