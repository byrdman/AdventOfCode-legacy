package net.thebyrdnest.aoc.aoc2019.tests.day04;

import net.thebyrdnest.aoc.aoc2019.day04.Day04;

import org.junit.jupiter.api.*;

public class Day04Test {
    Day04 solver;

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

    // valid
    @Test
    public void Example1_1() throws Exception {
        Assertions.assertTrue(solver.checkRules("111111", 6));
    }

    // invalid - descending numbers
    @Test
    public void Example1_2() throws Exception {
        Assertions.assertFalse(solver.checkRules("223450", 6));
    }

    // invalid - no double
    @Test
    public void Example1_3() throws Exception {
        Assertions.assertFalse(solver.checkRules("123789", 6));
    }

    // invalid - too short
    @Test
    public void Example1_4() throws Exception {
        Assertions.assertFalse(solver.checkRules("11111", 6));
    }

    // valid
    @Test
    public void Example1_5() throws Exception {
        Assertions.assertTrue(solver.checkRules("123788", 6));
    }



    //  invalid - not a double
    @Test
    public void Example2_1() throws Exception {
        Assertions.assertFalse(solver.checkRules("111111", 2));
    }

    // invalid - descending numbers
    @Test
    public void Example2_2() throws Exception {
        Assertions.assertFalse(solver.checkRules("223450", 2));
    }

    // invalid - no double
    @Test
    public void Example2_3() throws Exception {
        Assertions.assertFalse(solver.checkRules("123789", 2));
    }

    // invalid - too short
    @Test
    public void Example2_4() throws Exception {
        Assertions.assertFalse(solver.checkRules("11111", 2));
    }

    // valid
    @Test
    public void Example2_5() throws Exception {
        Assertions.assertTrue(solver.checkRules("123788", 2));
    }

    // valid
    @Test
    public void Example2_6() throws Exception {
        Assertions.assertTrue(solver.checkRules("111188", 2));
    }

    @Test
    public void Problem1() throws Exception {
        Assertions.assertEquals(460, solver.solve("382345-843167", 6));
    }

    @Test
    public void Problem2() throws Exception {
        Assertions.assertEquals(290, solver.solve("382345-843167", 2));
    }
}
