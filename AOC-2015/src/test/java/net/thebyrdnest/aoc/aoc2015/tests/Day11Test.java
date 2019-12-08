package net.thebyrdnest.aoc.aoc2015.tests;

import net.thebyrdnest.aoc.aoc2015.Day11;
import org.junit.jupiter.api.*;

public class Day11Test {

    Day11 solver;

    @BeforeAll
    public static void setupBeforeClass() throws Exception {

    }

    @AfterAll
    public static void teardownAfterClass() throws Exception {

    }

    @BeforeEach
    public void setupBeforeEach() throws Exception {
        solver = new Day11();

    }

    @AfterEach
    public void tearDownAfterEach() throws Exception {

    }

    @Test
    public void Example_1() {
        Assertions.assertFalse(solver.isValid("hijklmmn".toCharArray()));
    }

    @Test
    public void Example_2() {
        Assertions.assertFalse(solver.isValid("abbceffg".toCharArray()));
    }

    @Test
    public void Example_3() {
        Assertions.assertFalse(solver.isValid("abbcegjk".toCharArray()));
    }

    @Test
    public void Example_4() {
        Assertions.assertTrue(solver.isValid("abcdffaa".toCharArray()));
    }

    @Test
    public void Example_5() {
        Assertions.assertEquals("abcdffaa", solver.nextPwd("abcdefgh"));
    }

    @Test
    public void Example_6() {
        Assertions.assertEquals("ghjaabcc", solver.nextPwd("ghijklmn"));
    }

    @Test
    public void Problem_1() {
        Assertions.assertEquals("cqjxxyzz", solver.nextPwd("cqjxjnds"));
    }

    @Test
    public void Problem_2() {
        Assertions.assertEquals("cqkaabcc", solver.nextPwd("cqjxxyzz"));
    }
}
