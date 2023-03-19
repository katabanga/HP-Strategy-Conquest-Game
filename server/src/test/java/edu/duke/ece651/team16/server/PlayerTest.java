package edu.duke.ece651.team16.server;

import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import java.util.ArrayList;
import java.net.Socket;
import java.util.List;
import org.junit.jupiter.api.Test;
import edu.duke.ece651.team16.shared.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PlayerTest {
  @Test
  public void test_addTerritory() throws IOException {
    Conn c1 = mock(Conn.class);
    // when(c1.getSocket()).thenReturn(s1);

    // create a list for territories
    List<Territory> list = new ArrayList<Territory>();
    Player p = new Player("blue", c1, list, 2);

    Territory t1 = new Territory("Narnia");
    Territory t2 = new Territory("Gondor");
    list.add(t1);
    list.add(t2);

    p.addTerritories(list);

    assertEquals(p.getTerritories(), list);
    assertEquals(t1.getOwner(), p);
  }

  @Test
  public void test_getColor() throws IOException {
    Conn c1 = mock(Conn.class);
    List<Territory> list = new ArrayList<Territory>();
    Player p = new Player("blue", c1, list, 2);
    assertEquals(p.getColor(), "blue");
  }

  @Test
  public void test_getConnection() {
    Conn c1 = mock(Conn.class);
    List<Territory> list = new ArrayList<Territory>();
    Player p = new Player("blue", c1, list, 2);
    assertEquals(p.getConn(), c1);
  }

  @Test
  public void test_units() {
    Conn c1 = mock(Conn.class);
    List<Territory> list = new ArrayList<Territory>();
    Player p = new Player("blue", c1, list, 2);
    assertEquals(2, p.unplacedUnits());
  }

  @Test
  public void test_TerritoryNames() {
    Conn c1 = mock(Conn.class);
    List<Territory> list = new ArrayList<Territory>();
    list.add(new Territory("A"));
    list.add(new Territory("B"));
    Player p = new Player("blue", c1, list, 2);
    List<String> e1 = new ArrayList<String>();
    e1.add("A");
    e1.add("B");
    assertEquals(e1, p.getTerritoryNames());
  }

  @Test
  public void test_placeUnit() {
    Conn c1 = mock(Conn.class);
    List<Territory> list = new ArrayList<Territory>();
    list.add(new Territory("A"));
    Player p = new Player("blue", c1, list, 2);
    p.placeUnitsSameTerritory("A", 2);
    assertEquals(0, p.unplacedUnits());
    // assertEquals(null, p.findNextUnplacedUnit());
  }

  @Test
  public void test_placeUnit1() {
    Conn c1 = mock(Conn.class);
    List<Territory> list = new ArrayList<Territory>();
    Territory t1 = new Territory("A");
    list.add(t1);
    Player p = new Player("blue", c1, list, 2);

    // t1.addUnit(new BasicUnit(player, null, true, 2));

    Territory t2 = new Territory("B");
    assertEquals("You do not own this territory", p.placeUnitsSameTerritory("B",
        2));
    assertEquals(2, p.unplacedUnits());
    assertEquals("The amount of units you want to place is greater than the number of unplaced units",
        p.placeUnitsSameTerritory("A", 3));
    assertEquals(2, p.unplacedUnits());

    // assertEquals(null, p.findNextUnplacedUnit());
  }

  @Test
  public void testFindNextUnplacedUnits() {
    Conn c1 = mock(Conn.class);
    List<Territory> list = new ArrayList<Territory>();
    Territory territory = new Territory("A");
    list.add(territory);
    Player player = new Player("blue", c1, list, 3);
    int amount = 2;
    ArrayList<Unit> unplacedUnits = player.findNextUnplacedUnits(amount);
    assertEquals(amount, unplacedUnits.size());

    for (Unit u : unplacedUnits) {
      assertNull(u.getwhere());
    }
    player.placeUnitsSameTerritory("A", 2);

    ArrayList<Unit> unplacedUnits1 = player.findNextUnplacedUnits(1);
    assertEquals(1, unplacedUnits1.size());
  }

}
