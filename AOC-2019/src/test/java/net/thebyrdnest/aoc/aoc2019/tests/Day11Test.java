package net.thebyrdnest.aoc.aoc2019.tests;

import net.thebyrdnest.aoc.aoc2019.Day11;
import org.junit.jupiter.api.*;

public class Day11Test {


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
        int maxSize = 1000;
        char[][] hull = new char[1000][1000];
        for (int i=0; i < 1000; i++)
            for (int j=0; j < 1000; j++)
                hull[i][j] = '.';

        Day11 hullPainter = new Day11();
        int squares = hullPainter.paintHull(hull, 100, 900);
        //1723 is too low, 2571 is too high, 2472 is incorrect
        Assertions.assertEquals(5, squares);
    }
}
