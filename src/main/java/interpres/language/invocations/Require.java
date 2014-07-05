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
import interpres.AsBytecode;

import interpres.ast.AST;
import interpres.ast.StringLiteral;

import interpres.language.definitions.Definition;
import interpres.language.DefinitionTable;
import interpres.language.RuntimeException;

import interpres.language.values.Lambda;

public class Require extends Invocation {
  private Path basePath;

  public static class FileNotFoundException extends RuntimeException {
    public FileNotFoundException(String message) {
      super(message);
    }
  }

  public Require(DefinitionTable definitionTable, List<AST> arguments, Path basePath) {
    super(definitionTable, arguments);
    this.basePath = basePath;
  }

  public AsBytecode invoke() {
    try {
      return this.evaluateFile(new File(this.resolvedFilename()));
    } catch (java.io.FileNotFoundException e) {
      throw new FileNotFoundException(e.getMessage());
    }
  }

  public String getFileName() {
    return ((StringLiteral) this.getArguments().get(0)).getLiteral();
  }

  public String resolvedFilename() {
    return this.basePath.resolve(this.getFileName()).toString();
  }

  private AsBytecode evaluateFile(File file) throws java.io.FileNotFoundException {
    AsBytecode resultValue;
    FileInputStream fileInputStream = new FileInputStream(this.resolvedFilename());

    this.getDefinitionTable().define(new interpres.language.definitions.Require(file.getParent()));

    resultValue = new Evaluator(this.getDefinitionTable(), file.getName()).evaluate(fileInputStream);

    this.getDefinitionTable().define(new interpres.language.definitions.Require(this.basePath));

    return resultValue;
  }
}

