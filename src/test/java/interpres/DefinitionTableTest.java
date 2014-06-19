package interpres;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class DefinitionTableTest {
  DefinitionTable definitionTable;

  @Before public void setUpEmptyDefinitionTable() {
    this.definitionTable = new DefinitionTable();
  }

  @Test public void defineAddsADefinition() {
    this.definitionTable.define("x", 4);
    assertEquals(4, this.definitionTable.lookup("x"));
  }

  @Test public void defineOverridesPreviousDefinitions() {
    this.definitionTable.define("x", 4);
    this.definitionTable.define("x", 5);

    assertEquals(5, this.definitionTable.lookup("x"));
  }

  @Test public void defineIgnoresScoping() {
    this.definitionTable.enterScope();
    this.definitionTable.define("x", 4);
    this.definitionTable.leaveScope();

    assertEquals(4, this.definitionTable.lookup("x"));
  }

  @Test public void bindAddsADefinition() {
    this.definitionTable.bind("y", 3);
    assertEquals(3, this.definitionTable.lookup("y"));
  }

  @Test public void bindOverridesPreviousDefinitions() {
    this.definitionTable.define("y", 3);

    this.definitionTable.enterScope();
    this.definitionTable.bind("y", 4);

    assertEquals(4, this.definitionTable.lookup("y"));

    this.definitionTable.enterScope();
    this.definitionTable.bind("y", 5);

    assertEquals(5, this.definitionTable.lookup("y"));

    this.definitionTable.leaveScope();
    this.definitionTable.leaveScope();
  }

  @Test public void bindAcknowledgesScoping() {
    this.definitionTable.enterScope();
    this.definitionTable.bind("y", 3);

    assertEquals(3, this.definitionTable.lookup("y"));

    this.definitionTable.leaveScope();

    assertEquals(null, this.definitionTable.lookup("y"));
  }
}

