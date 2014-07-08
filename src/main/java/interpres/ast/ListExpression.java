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

  /**
   * Constructs a new ListExpression.
   *
   * @param items the items of this ListExpression
   */
  public ListExpression(List<AST> items) {
    this(items, SourceLocation.NATIVE_METHOD);
  }

  /**
   * Constructs a new ListExpression.
   *
   * @param items the items of this ListExpression
   * @param sourceLocation the SourceLocation of this expression
   */
  public ListExpression(List<AST> items, SourceLocation sourceLocation) {
    super(sourceLocation);
    this.items = items;
  }

  /**
   * Builds a new ListExpression based on a lists of arguments.
   * 
   * @param name the name of the function call
   * @param arguments the corresponding arguments
   * @return a new ListExpression containing the function call
   */
  public static ListExpression buildFunctionCall(String name, List<AST> arguments) {
    List<AST> items = new ArrayList<AST>();
    items.add(new Symbol(name));
    items.addAll(arguments);
    return new ListExpression(items);
  }

  /**
   * Builds a new ListExpression based on a single argument.
   * 
   * @param name the name of the function call
   * @param argument the corresponding argument
   * @return a new ListExpression containing the function call
   */
  public static ListExpression buildFunctionCall(String name, AST argument) {
    return buildFunctionCall(name, Arrays.asList(argument));
  }

  /**
   * Builds a new ListExpression with a given name.
   *
   * @param name the name of the function call
   * @return a new ListExpression containing the function call
   */
  public static ListExpression buildFunctionCall(String name) {
    return buildFunctionCall(name, Collections.emptyList());
  }

  /**
   * Evaluates the current ListExpression. 
   *
   * @param definitionTable the definition table used while evaluating the object
   * @return the generated AST
   */
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

  /**
   * Returns the items of this ListExpression.
   *
   * @return items of this object
   */
  public List<AST> getItems() {
    return this.items;
  }

  /**
   * Returns a specific item of this ListExpression.
   *
   * @param index the index of the item
   * @return the AST of the item
   */
  public AST getItem(int index) {
    return this.items.get(index);
  }

  /**
   * Returns the function name of the current ListExpression.
   *
   * @return the name of this function
   */
  public String getFunctionName() {
    return this.getFunction().getName();
  }

  /**
   * Returns the instructions corresponding with this object.
   *
   * @return List of Strings containing the instructions belonging to this object
   */
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

