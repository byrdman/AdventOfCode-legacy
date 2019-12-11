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

    @Disabled
    @Test
    public void Problem1() {
        int maxSize = 10;
        char[][] hull = new char[maxSize][maxSize];
        for (int i=0; i < maxSize; i++)
            for (int j=0; j < maxSize; j++)
                hull[i][j] = '.';

        Robot hullPainter = new Robot();
        int squares = hullPainter.paintHull(hull, maxSize/2, maxSize/2);
        Assertions.assertEquals(5, squares);
    }
}
