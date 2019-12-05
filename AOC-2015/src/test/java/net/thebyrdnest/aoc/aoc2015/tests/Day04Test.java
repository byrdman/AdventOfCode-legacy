package net.thebyrdnest.aoc.aoc2015.tests;

import net.thebyrdnest.aoc.aoc2015.*;
import org.junit.jupiter.api.*;

public class Day04Test {

    Day04 solver;
    String myInput = "ckczppom";

    @BeforeAll
    public static void setupBeforeClass() throws Exception {

    }

    @AfterAll
    public static void teardownAfterClass() throws Exception {

    }

    @BeforeEach
    public void setupBeforeEach() throws Exception {
        solver = new Day04();

    }

    @AfterEach
    public void tearDownAfterEach() throws Exception {

    }

    @Test
    public void Problem1() throws Exception {

        Assertions.assertEquals(117946, solver.solve1(myInput));
    }

    @Test
    public void Problem2() throws Exception {

        Assertions.assertEquals(3938038, solver.solve2(myInput));
    }
}
