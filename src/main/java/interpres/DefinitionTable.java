package interpres;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.function.BiFunction;
import java.io.*;

import interpres.ast.AST;

public class DefinitionTable {
  private Definition mostRecentDefinition;
  private int scopeLevel;

  public void define(String name, Object definition) {
    if(this.mostRecentDefinition == null) {
      Definition newDefinition = new Definition(name, definition, 0, null);
      this.mostRecentDefinition = newDefinition;
    } else {
      Definition currentDefinition = this.mostRecentDefinition;
      while(currentDefinition != null){
        if(currentDefinition.getPrevious() != null && currentDefinition.getPrevious().getScopeLevel() == 0){
          Definition newDefinition = new Definition(name, definition, 0, currentDefinition.getPrevious());
          currentDefinition.setPrevious(newDefinition);
          this.mostRecentDefinition = newDefinition;
          return;
        } else
        if(currentDefinition.getPrevious() == null){
          Definition newDefinition = new Definition(name, definition, 0, null);
          currentDefinition.setPrevious(newDefinition);
          this.mostRecentDefinition = newDefinition;
          return;
        }
       currentDefinition = currentDefinition.getPrevious();
      }
  private static class Definition {
    private String id;
    private Object value;
    private int scopeLevel;

    public Definition(String id, Object value, int scopeLevel) {
      this.id = id;
      this.value = value;
      this.scopeLevel = scopeLevel;
    }

    public String getId() { return this.id; }
    public Object getValue() { return this.value; }
    public int getScopeLevel() { return this.scopeLevel; }
  }

  public void bind(String name, Object definition) {
    Definition newDefinition = new Definition(name, definition, this.scopeLevel, this.mostRecentDefinition);
    this.mostRecentDefinition = newDefinition;
  }


  public Object lookup(String name) {
    Definition currentDefinition = this.mostRecentDefinition;
    while(currentDefinition != null){
      if(currentDefinition.getId().equals(name)) return currentDefinition.getValue();
      currentDefinition = currentDefinition.getPrevious();
    }
    return null;
  }

  public void enterScope(){
    this.scopeLevel++;
  }

  public void leaveScope(){
    Definition currentDefinition = this.mostRecentDefinition;
    while(currentDefinition != null && currentDefinition.getScopeLevel() == this.scopeLevel){
      currentDefinition = currentDefinition.getPrevious();
    }
    this.scopeLevel--;
    this.mostRecentDefinition = currentDefinition;
  }
}

