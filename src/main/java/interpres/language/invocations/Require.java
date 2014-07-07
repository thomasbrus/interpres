package interpres.language.invocations;

import java.util.List;
import java.util.Iterator;
import java.util.stream.Collectors;

import java.io.File;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.IOException;

import java.nio.file.Path;
import org.antlr.runtime.RecognitionException;

import interpres.Evaluator;

import interpres.ast.AST;
import interpres.ast.StringValue;
import interpres.ast.LambdaExpression;

import interpres.language.definitions.Definition;
import interpres.language.DefinitionTable;
import interpres.RuntimeException;

public class Require extends Invocation {
  private Path basePath;

  public static class FileNotFoundException extends RuntimeException {
  /**
   * Constructs a new FileNotFoundException.
   *
   * @param message Message to 
   */
    public FileNotFoundException(String message) {
      super(message);
    }
  }

  /**
   * Constructs a new Require object.
   *
   * @param definitionTable the definition table to work with
   * @param arguments 
   * @param basePath 
   */
  public Require(DefinitionTable definitionTable, List<AST> arguments, Path basePath) {
    super(definitionTable, arguments);
    this.basePath = basePath;
  }

  /**
   * Loads the give file and tries to generate an AST.
   *
   * @throws FileNotFoundException if given file not found
   * @return AST of the
   */
  public AST invoke() {
    try {
      return (AST) this.evaluateFile(new File(this.resolvedFilename()));
    } catch (java.io.FileNotFoundException e) {
      throw new FileNotFoundException(e.getMessage());
    }
  }

  /** 
   * Returns the filename of the Require call.
   *
   * @return filename of the require
   */
  public String getFileName() {
    return ((StringValue) this.getArguments().get(0)).getLiteral();
  }

  /** 
   * Returns the resolved filename of the Require call.
   *
   * @return resolved filename of the require
   */
  public String resolvedFilename() {
    return this.basePath.resolve(this.getFileName()).toString();
  }

  private AST evaluateFile(File file) throws java.io.FileNotFoundException {
    AST resultValue;
    FileInputStream fileInputStream = new FileInputStream(this.resolvedFilename());

    this.getDefinitionTable().define(new interpres.language.definitions.Require(file.getParent()));

    resultValue = new Evaluator(this.getDefinitionTable(), file.getName()).evaluate(fileInputStream);

    this.getDefinitionTable().define(new interpres.language.definitions.Require(this.basePath));

    return resultValue;
  }
}

