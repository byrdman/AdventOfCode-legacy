package net.thebyrdnest.aoc.aoc2019.tests;

import net.thebyrdnest.aoc.aoc2019.Day12;
import net.thebyrdnest.aoc.utils.Moon;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

public class Day12Test {
    String[] myData = ( "<x=-4, y=-9, z=-3>\n" +
            "<x=-13, y=-11, z=0>\n" +
            "<x=-17, y=-7, z=15>\n" +
            "<x=-16, y=4, z=2>").split("\n");

    @BeforeAll
    public static void setupBeforeClass() throws Exception {

    }

    @AfterAll
    public static void teardownAfterClass() throws Exception {

    }

    @BeforeEach
    public void setupBeforeEach() throws Exception {

    }

    @AfterEach
    public void tearDownAfterEach() throws Exception {

    }

    @Test
    public void testConstruct() {
        /*<x=-1, y=0, z=2>
<x=2, y=-10, z=-7>
<x=4, y=-8, z=8>
<x=3, y=5, z=-1>*/
        Moon moon = new Moon("<x=-1, y=0, z=2>");
        Assertions.assertEquals(-1, moon.getPosX());
        Assertions.assertEquals(0, moon.getPosY());
        Assertions.assertEquals(2, moon.getPosZ());
    }

    @Test
    public void testApplyGravity() {
        ArrayList<Moon> moons = new ArrayList<>();
        ArrayList<Moon> newMoons = new ArrayList<>();
        moons.add(new Moon("<x=-1, y=0, z=2>"));
        moons.add(new Moon("<x=2, y=-10, z=-7>"));
        moons.add(new Moon("<x=4, y=-8, z=8>"));
        moons.add(new Moon("<x=3, y=5, z=-1>"));

        for (Moon moon : moons) {
            for (Moon otherMoon : moons) {
                if (!moon.equals(otherMoon))
                    moon.applyGravity(otherMoon);
            }
            newMoons.add(moon);
        }

        Moon moon = newMoons.get(0);
        Assertions.assertEquals(3, moon.getVelX());
        Assertions.assertEquals(-1, moon.getVelY());
        Assertions.assertEquals(-1, moon.getVelZ());

        moon = newMoons.get(1);
        Assertions.assertEquals(1, moon.getVelX());
        Assertions.assertEquals(3, moon.getVelY());
        Assertions.assertEquals(3, moon.getVelZ());

        moon = newMoons.get(2);
        Assertions.assertEquals(-3, moon.getVelX());
        Assertions.assertEquals(1, moon.getVelY());
        Assertions.assertEquals(-3, moon.getVelZ());

        moon = newMoons.get(3);
        Assertions.assertEquals(-1, moon.getVelX());
        Assertions.assertEquals(-3, moon.getVelY());
        Assertions.assertEquals(1, moon.getVelZ());
    }

    @Test
    public void Example1() {
        Day12 solver = new Day12();
        int energy = solver.solve1(("<x=-1, y=0, z=2>\n" +
                "<x=2, y=-10, z=-7>\n" +
                "<x=4, y=-8, z=8>\n" +
                "<x=3, y=5, z=-1>").split("\n"), 10);

        Assertions.assertEquals(179, energy);
    }

    @Test
    public void Problem1() {

        Day12 solver = new Day12();
        Assertions.assertEquals(1, solver.solve1(myData, 1000));
    }

    @Test
    public void Example2_1() {
        Day12 solver = new Day12();
        Assertions.assertEquals(2772, solver.solve2(("<x=-1, y=0, z=2>\n" +
                "<x=2, y=-10, z=-7>\n" +
                "<x=4, y=-8, z=8>\n" +
                "<x=3, y=5, z=-1>").split("\n")));
    }

    @Test
    public void Example2_2() {
        Day12 solver = new Day12();
        Assertions.assertEquals(4686774924l, solver.solve2(("<x=-8, y=-10, z=0>\n" +
                "<x=5, y=5, z=10>\n" +
                "<x=2, y=-7, z=3>\n" +
                "<x=9, y=-8, z=-3>").split("\n")));
    }

}
