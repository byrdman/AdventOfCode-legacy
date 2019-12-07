package net.thebyrdnest.aoc.aoc2015.tests;

import net.thebyrdnest.aoc.aoc2015.Day10;
import org.junit.jupiter.api.*;

public class Day10Test {

    Day10 solver;

    @BeforeAll
    public static void setupBeforeClass() throws Exception {

    }

    @AfterAll
    public static void teardownAfterClass() throws Exception {

    }

    @BeforeEach
    public void setupBeforeEach() throws Exception {
        solver = new Day10();

    }

    @AfterEach
    public void tearDownAfterEach() throws Exception {

    }

    @Test
    public void Example_1() {
        String input = "1";

        Assertions.assertEquals("11", solver.lookAndSay(input, 1));
    }

    @Test
    public void Example_2() {
        String input = "11";
        Assertions.assertEquals("21", solver.lookAndSay(input, 1));
    }

    @Test
    public void Example_3() {
        String input = "21";
        Assertions.assertEquals("1211", solver.lookAndSay(input, 1));
    }

    @Test
    public void Example_4() {
        String input = "1211";

        String answer = solver.lookAndSay(input, 1);
        Assertions.assertEquals("111221", solver.lookAndSay(input, 1));
    }

    @Test
    public void Example_5() {
        String input = "111221";

        Assertions.assertEquals("312211", solver.lookAndSay(input, 1));
    }

    @Test
    public void Example_6() {
        String input = "1";

        Assertions.assertEquals("312211", solver.lookAndSay(input, 5));
    }

    @Test
    public void Problem_1() {
        Assertions.assertEquals(492982, solver.lookAndSay("1321131112", 40).length());
        Assertions.assertEquals(6989950, solver.lookAndSay("1321131112", 50).length());
    }
}
