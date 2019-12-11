package net.thebyrdnest.aoc.aoc2019.tests;

import net.thebyrdnest.aoc.aoc2019.Robot;
import org.junit.jupiter.api.*;

public class RobotTest {


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
        char[][] hull = new char[1000][1000];
        for (int i=0; i < 1000; i++)
            for (int j=0; j < 1000; j++)
                hull[i][j] = ' ';

        Robot hullPainter = new Robot();
        int squares = hullPainter.paintHull(hull, 500, 500);
        Assertions.assertEquals(5, squares);
    }
}
