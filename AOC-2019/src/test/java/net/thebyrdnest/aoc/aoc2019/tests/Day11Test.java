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

        Day11 hullPainter = new Day11();
        //hullPainter.setDebugFlag(true);
        int squares = hullPainter.paintHull();
        //1723 is too low, 2571 is too high, 2472 is incorrect
        Assertions.assertEquals(1747, squares);
    }

    @Test
    public void Problem2() {
        String expected = ".####..##...##..###..#..#.#..#.#....###....\n" +
                          "....#.#..#.#..#.#..#.#..#.#.#..#....#..#...\n" +
                          "...#..#....#....#..#.####.##...#....###....\n" +
                          "..#...#....#.##.###..#..#.#.#..#....#..#...\n" +
                          ".#....#..#.#..#.#.#..#..#.#.#..#....#..#...\n" +
                          ".####..##...###.#..#.#..#.#..#.####.###....\n";

        Day11 hullPainter = new Day11();
        hullPainter.setPanelColor(0,0,'#');
        int squares = hullPainter.paintHull();
        //ZCGRHKLB
        String answer = hullPainter.printHull();
        Assertions.assertEquals(expected, answer);
    }
}
