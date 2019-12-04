package net.thebyrdnest.aoc.aoc2017.tests;

import net.thebyrdnest.aoc.aoc2017.*;
import org.junit.jupiter.api.*;

public class Day03Tests {
    Day03 solver;

    @BeforeAll
    public static void setupBeforeClass() throws Exception {

    }

    @AfterAll
    public static void teardownAfterClass() throws Exception {

    }

    @BeforeEach
    public void setupBeforeEach() throws Exception {
        solver = new Day03();
    }

    @AfterEach
    public void tearDownAfterEach() throws Exception {

    }

    @Test
    public void ring1() throws Exception {
        Assertions.assertEquals(2, solver.findRing(2));
    }

    @Test
    public void leg1() throws Exception {
        Assertions.assertEquals(3, solver.findLegMax(2, 2));
    }

    @Test
    public void leg2() throws Exception {
        Assertions.assertEquals(49, solver.findLegMax(4, 44));
    }

    @Test
    public void Example1_1() throws Exception {
        Assertions.assertEquals(1, solver.solve1(2));
    }

    @Test
    public void Example1_2() throws Exception {
        Assertions.assertEquals(6, solver.solve1(49));
    }

    @Test
    public void Example2_1() throws Exception {
        Assertions.assertEquals(2, solver.solve2(2));
    }

    @Test
    public void Problem_1() throws Exception {
        Assertions.assertEquals(326, solver.solve1(361527));
    }

    @Test
    public void Problem_2() throws Exception {
        Assertions.assertEquals(226, solver.solve2(361527));
    }
}
