package edu.duke.ece651.team16.server;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.*;

public class MapTest {
    @Test
    public void test_getColorList() {
        Map m1 = new Map(2);
        ArrayList<String> e1 = new ArrayList<String>();
        e1.add("red");
        e1.add("blue");
        assertEquals(e1, m1.getColorList());
        Map m2 = new Map(3);
        e1.add("yellow");
        assertEquals(e1, m2.getColorList());
        Map m3 = new Map(4);
        e1.add("green");
        assertEquals(e1, m3.getColorList());
    }

    @Test
    public void test_createBasic() {
        Map m1 = new Map(2);
        HashMap<String, List<Territory>> e1 = new HashMap<String, List<Territory>>();
        Territory red = new Territory("A");
        Territory blue = new Territory("B");
        red.setNeighbors(Arrays.asList(blue));
        e1.put("red", Arrays.asList(red));
        e1.put("blue", Arrays.asList(blue));
        e1.get("red").toString();
        assertNotEquals(m1, m1.createBasicMap().get("blue"));
        assertEquals(e1.get("red"), m1.createBasicMap().get("red"));
        assertEquals(e1.get("blue"), m1.createBasicMap().get("blue"));
        m1.createDukeMap();
        Map m2 = new Map(-1);
        m2.createDukeMap();
        Map m3 = new Map(3);
        m3.createDukeMap();
        Map m4 = new Map(4);
        m4.createDukeMap();
    }

}