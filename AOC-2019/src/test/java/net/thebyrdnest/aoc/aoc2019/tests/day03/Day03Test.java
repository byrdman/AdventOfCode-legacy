package net.thebyrdnest.aoc.aoc2019.tests.day03;

import net.thebyrdnest.aoc.aoc2019.day03.*;
import org.junit.jupiter.api.*;

public class Day03Test {

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
    public void testPrint() throws Exception {
        Day03 day03 = new Day03(10,10, 1, 1);
        StringBuffer sbExpected = new StringBuffer("+----------+\n" +
                "|..........|\n" +
                "|..........|\n" +
                "|..........|\n" +
                "|..........|\n" +
                "|..........|\n" +
                "|..........|\n" +
                "|..........|\n" +
                "|..........|\n" +
                "|.o........|\n" +
                "|..........|\n" +
                "+----------+");
        StringBuffer sbResult = day03.printGrid();

        Assertions.assertEquals(sbExpected.toString(), sbResult.toString());
    }
}
