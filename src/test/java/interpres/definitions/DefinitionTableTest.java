package interpres.definitions;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Iterator;
import java.io.PrintStream;

import interpres.instructions.PrintableInstructionSequence;

@RunWith(JUnit4.class)
public class DefinitionTableTest {
  private DefinitionTable definitionTable;
  private DummyDefinition firstDefinition;
  private DummyDefinition secondDefinition;
  private DummyDefinition thirdDefinition;

  private static class DummyDefinition implements PrintableInstructionSequence {
    public void printInstructionSequence(PrintStream printStream) {}
    public Iterator<String> iterator() { return null; }
    public int length() { return 0; }
  }

  @Before public void setUpEmptyDefinitionTable() {
    this.definitionTable = new DefinitionTable();
    this.firstDefinition = new DummyDefinition();
    this.secondDefinition = new DummyDefinition();
    this.thirdDefinition = new DummyDefinition();
  }

  @Test public void defineAddsADefinition() {
    this.definitionTable.define("x", this.firstDefinition);
    assertEquals(this.firstDefinition, this.definitionTable.lookup("x"));
  }

  @Test public void defineOverridesPreviousDefinitions() {
    this.definitionTable.define("x", this.firstDefinition);
    this.definitionTable.define("x", this.secondDefinition);
    this.definitionTable.define("x", this.thirdDefinition);

    assertNotEquals(this.secondDefinition, this.definitionTable.lookup("x"));
    assertEquals(this.thirdDefinition, this.definitionTable.lookup("x"));
  }

  @Test public void defineIgnoresScoping() {
    this.definitionTable.enterScope();
    this.definitionTable.define("x", this.firstDefinition);
    this.definitionTable.leaveScope();

    assertEquals(this.firstDefinition, this.definitionTable.lookup("x"));
  }

  // TODO: Add #define(Definition) tests

  @Test public void bindAddsADefinition() {
    this.definitionTable.bind("y", this.firstDefinition);
    assertEquals(this.firstDefinition, this.definitionTable.lookup("y"));
  }

  @Test public void bindOverridesPreviousDefinitions() {
    this.definitionTable.define("y", this.firstDefinition);

    this.definitionTable.enterScope();
    this.definitionTable.bind("y", this.firstDefinition);

    assertEquals(this.firstDefinition, this.definitionTable.lookup("y"));

    this.definitionTable.enterScope();
    this.definitionTable.bind("y", this.thirdDefinition);

    assertEquals(this.thirdDefinition, this.definitionTable.lookup("y"));

    this.definitionTable.leaveScope();
    this.definitionTable.leaveScope();
  }

  @Test public void bindAcknowledgesScoping() {
    this.definitionTable.enterScope();
    this.definitionTable.bind("y", this.firstDefinition);
    this.definitionTable.bind("z", this.secondDefinition);

    assertEquals(this.firstDefinition, this.definitionTable.lookup("y"));

    this.definitionTable.leaveScope();

    assertEquals(null, this.definitionTable.lookup("y"));
  }

  @Test public void lookupFindsADefinition() {
    this.definitionTable.define("x", this.firstDefinition);
    assertEquals(this.firstDefinition, this.definitionTable.lookup("x"));

    this.definitionTable.bind("y", this.secondDefinition);
    assertEquals(this.secondDefinition, this.definitionTable.lookup("y"));
  }

  @Test public void lookupReturnsNullWhenNothingFound() {
    assertEquals(null, this.definitionTable.lookup("y"));
  }

  // TODO: Add more #lookup tests
  // TODO: Add #enterScope and #leaveScope tests
}

