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
}

