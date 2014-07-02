package interpres.language.definitions;

import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.antlr.runtime.RecognitionException;

import interpres.ast.StringLiteral;
import interpres.language.definitions.Definition;

import interpres.App;
import interpres.language.values.Lambda;
import interpres.language.values.Void;

public class Require extends Definition {

  public Require() {
    super("require", new Lambda((definitionTable, arguments) -> {
      try {
        java.lang.String filename = ((StringLiteral) arguments.get(0)).getLiteral();
        InputStream inputStream = new FileInputStream(filename);
        return new App(definitionTable).evaluate(inputStream);
      } catch (FileNotFoundException e) {
        System.err.println(e);
      } catch (IOException e) {
        // TODO: Rethrow interpres exception
      } catch (RecognitionException e) {
      }

      return new Void();
    }));
  }

}

