package interpres;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Iterator;

@RunWith(JUnit4.class)
public class DefinitionTableTest {
  DefinitionTable definitionTable;
  DummyDefinition firstDefinition;
  DummyDefinition secondDefinition;
  DummyDefinition thirdDefinition;

  private static class DummyDefinition implements PrintableBytecode {
    public String getBytecode() { return ""; }
    public Iterator<String> iterator() { return null; }
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

    assertEquals(this.thirdDefinition, this.definitionTable.lookup("x"));
  }

  @Test public void defineIgnoresScoping() {
    this.definitionTable.enterScope();
    this.definitionTable.define("x", this.firstDefinition);
    this.definitionTable.leaveScope();

    assertEquals(this.firstDefinition, this.definitionTable.lookup("x"));
  }

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

