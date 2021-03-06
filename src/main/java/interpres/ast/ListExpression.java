package interpres.ast;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

import interpres.SourceLocation;
import interpres.RuntimeException;
import interpres.TypeMismatchException;

import interpres.language.DefinitionTable;
import interpres.language.SymbolResolver;

public class ListExpression extends AST {
  private List<AST> items;

  public ListExpression(List<AST> items) {
    this(items, SourceLocation.NATIVE_METHOD);
  }

  public ListExpression(List<AST> items, SourceLocation sourceLocation) {
    super(sourceLocation);
    this.items = items;
  }

  public static ListExpression buildFunctionCall(String name, List<AST> arguments) {
    List<AST> items = new ArrayList<AST>();
    items.add(new Symbol(name));
    items.addAll(arguments);
    return new ListExpression(items);
  }

  public static ListExpression buildFunctionCall(String name, AST argument) {
    return buildFunctionCall(name, Arrays.asList(argument));
  }

  public static ListExpression buildFunctionCall(String name) {
    return buildFunctionCall(name, Collections.emptyList());
  }

  public AST evaluate(DefinitionTable definitionTable) {
    try {
      LambdaExpression lambda = (LambdaExpression) this.getFunction().evaluate(definitionTable);
      return lambda.getFunction().apply(definitionTable, this.getArguments());
    } catch (ClassCastException classCastException) {
      throw new TypeMismatchException(classCastException.getMessage());
    } catch (RuntimeException runtimeException) {
      throw runtimeException.registerFunctionCall(
        this.getFunctionName(), this.getSourceFileName(), this.getSourceLineNumber()
      );
    }
  }

  public List<AST> getItems() {
    return this.items;
  }

  public AST getItem(int index) {
    return this.items.get(index);
  }

  public String getFunctionName() {
    return this.getFunction().getName();
  }

  public List<String> instructionSequence() {
    List<java.lang.String> instructionSequence = new ArrayList<String>();

    for (AST item : this.items) {
      instructionSequence.addAll(item.instructionSequence());
    }

    return instructionSequence;
  }

  private Symbol getFunction() {
    return (Symbol) this.items.get(0);
  }

  private List<AST> getArguments() {
    return this.items.subList(1, this.items.size());
  }
}

