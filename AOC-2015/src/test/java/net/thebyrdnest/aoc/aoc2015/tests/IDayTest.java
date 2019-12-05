package net.thebyrdnest.aoc.aoc2015.tests;

import net.thebyrdnest.aoc.aoc2015.Day04;
import net.thebyrdnest.aoc.aoc2015.DayTemplate;
import org.junit.jupiter.api.*;

public abstract class IDayTest<T> {

    DayTemplate solver;

    String myInput = "ckczppom";

    @BeforeAll
    public static void setupBeforeClass() throws Exception {

    }

    @AfterAll
    public static void teardownAfterClass() throws Exception {

    }

    @BeforeEach
    public void setupBeforeEach() throws Exception {
        //solver = new T();
    }

    @AfterEach
    public void tearDownAfterEach() throws Exception {

    }

    @Test
    public abstract void Problem1() throws Exception;/* {

        Assertions.assertEquals(2081, solver.solve1(myInput));
    }*/

    @Test
    public abstract void Problem2() throws Exception;/* {

        Assertions.assertEquals(2341, solver.solve2(myInput));
    }*/
}
