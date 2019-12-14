package net.thebyrdnest.aoc.aoc2019.tests;

import net.thebyrdnest.aoc.aoc2019.Day13;
import org.junit.jupiter.api.*;

public class Day13Test {


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
    public void Problem1() {

        Day13 solver = new Day13();
        int paddles = solver.solve1();
        Assertions.assertEquals(1747, paddles);
    }

    @Test
    public void Problem2() {
        int[] joystickMoves = {-1, 0, 1};
        Day13 solver = new Day13();
        solver.solve2(joystickMoves);
    }
}
