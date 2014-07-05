package interpres;

import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;

import java.io.IOException;
import java.io.InputStream;

import java.util.Arrays;

import interpres.ast.AST;
import interpres.ast.ListExpression;

import interpres.language.DefinitionTable;
import interpres.language.values.Value;
import interpres.language.values.List;

public class SourceLocation {
  private String fileName;
  private int lineNumber;

  public static SourceLocation UNKNOWN_SOURCE = new SourceLocation(null, -1);
  public static SourceLocation NATIVE_METHOD = new SourceLocation(null, -2);

  public SourceLocation(String fileName, int lineNumber) {
    this.fileName = fileName;
    this.lineNumber = lineNumber;
  }

  public String getFileName() {
    return this.fileName;
  }

  public int getLineNumber() {
    return this.lineNumber;
  }
}


