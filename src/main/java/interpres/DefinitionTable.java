package interpres;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.function.BiFunction;
import java.io.*;

import interpres.ast.AST;

public class DefinitionTable {
  // TODO: Allow non-lambda definitions
 private Definition latest;
  private int level;

  public DefinitionTable() { }

  public void define(String name, Object definition) {
    if(this.latest == null) {
      Definition newDefinition = new Definition(name, definition, 0, null);
      this.latest = newDefinition;
    } else {
      Definition currentDefinition = latest;
      while(currentDefinition != null){
        if(currentDefinition.getPrevious() != null && currentDefinition.getPrevious().getLevel() == 0){
          Definition newDefinition = new Definition(name, definition, 0, currentDefinition.getPrevious());
          currentDefinition.setPrevious(newDefinition);
          return;
        } else
        if(currentDefinition.getPrevious() == null){
          Definition newDefinition = new Definition(name, definition, 0, null);
          currentDefinition.setPrevious(newDefinition);
          return;
        }
       currentDefinition = currentDefinition.getPrevious();
      }
    }
  }

  public void bind(String name, Object definition) {
    Definition newDefinition = new Definition(name, definition, this.level, this.latest);
    this.latest = newDefinition;
  }


  public Object lookup(String name) {
    Definition currentDefinition = latest;
    while(currentDefinition != null){
      if(currentDefinition.getId().equals(name)) return currentDefinition;
      currentDefinition = currentDefinition.getPrevious();
    }
    return null;
  }

  public void enterScope(){
    this.level++;
  }

  public void leaveScope(){
    Definition currentDefinition = this.latest;
    while(currentDefinition != null && currentDefinition.getLevel() == this.level){
      currentDefinition = currentDefinition.getPrevious();
    }
    this.level--;
    this.latest = currentDefinition;
  }
}

