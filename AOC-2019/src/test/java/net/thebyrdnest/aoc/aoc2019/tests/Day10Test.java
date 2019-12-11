package net.thebyrdnest.aoc.aoc2019.tests;

import net.thebyrdnest.aoc.aoc2019.Day10;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Day10Test {


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
    public void Example_1_1() {
        Day10 solver = new Day10();
        String[] input = (
                ".#..#\n" +
                ".....\n" +
                "#####\n" +
                "....#\n" +
                "...##").split("\n");

        Assertions.assertEquals(8, solver.solve1(input));
    }

    @Test
    public void Example_1_2() {
        Day10 solver = new Day10();
        String[] input = (
                "......#.#.\n" +
                "#..#.#....\n" +
                "..#######.\n" +
                ".#.#.###..\n" +
                ".#..#.....\n" +
                "..#....#.#\n" +
                "#..#....#.\n" +
                ".##.#..###\n" +
                "##...#..#.\n" +
                ".#....####").split("\n");

        Assertions.assertEquals(33, solver.solve1(input));
    }

    @Test
    public void Example_1_3() {
        Day10 solver = new Day10();
        String[] input = (
                "#.#...#.#.\n" +
                ".###....#.\n" +
                ".#....#...\n" +
                "##.#.#.#.#\n" +
                "....#.#.#.\n" +
                ".##..###.#\n" +
                "..#...##..\n" +
                "..##....##\n" +
                "......#...\n" +
                ".####.###.").split("\n");

        Assertions.assertEquals(35, solver.solve1(input));
    }

    @Test
    public void Example_1_4() {
        Day10 solver = new Day10();
        String[] input = (
                ".#..#..###\n" +
                "####.###.#\n" +
                "....###.#.\n" +
                "..###.##.#\n" +
                "##.##.#.#.\n" +
                "....###..#\n" +
                "..#.#..#.#\n" +
                "#..#.#.###\n" +
                ".##...##.#\n" +
                ".....#.#..").split("\n");

        Assertions.assertEquals(41, solver.solve1(input));
    }

    @Test
    public void Example_1_5() {
        Day10 solver = new Day10();
        String[] input = (
                ".#..##.###...#######\n" +
                "##.############..##.\n" +
                ".#.######.########.#\n" +
                ".###.#######.####.#.\n" +
                "#####.##.#.##.###.##\n" +
                "..#####..#.#########\n" +
                "####################\n" +
                "#.####....###.#.#.##\n" +
                "##.#################\n" +
                "#####.##.###..####..\n" +
                "..######..##.#######\n" +
                "####.##.####...##..#\n" +
                ".#####..#.######.###\n" +
                "##...#.##########...\n" +
                "#.##########.#######\n" +
                ".####.#.###.###.#.##\n" +
                "....##.##.###..#####\n" +
                ".#.#.###########.###\n" +
                "#.#.#.#####.####.###\n" +
                "###.##.####.##.#..##").split("\n");

        Assertions.assertEquals(210, solver.solve1(input));
    }

    @Test
    public void Problem1() {
        Day10 solver = new Day10();
        Assertions.assertEquals(2870072642l, solver.solve1(myInput));

    }

    @Disabled
    @Test
    public void Problem2() {
        Day10 solver = new Day10();
        Assertions.assertEquals(58534, solver.solve2(myInput));

    }

    String[] myInput = (".###.#...#.#.##.#.####..\n" +
            ".#....#####...#.######..\n" +
            "#.#.###.###.#.....#.####\n" +
            "##.###..##..####.#.####.\n" +
            "###########.#######.##.#\n" +
            "##########.#########.##.\n" +
            ".#.##.########.##...###.\n" +
            "###.#.##.#####.#.###.###\n" +
            "##.#####.##..###.#.##.#.\n" +
            ".#.#.#####.####.#..#####\n" +
            ".###.#####.#..#..##.#.##\n" +
            "########.##.#...########\n" +
            ".####..##..#.###.###.#.#\n" +
            "....######.##.#.######.#\n" +
            "###.####.######.#....###\n" +
            "############.#.#.##.####\n" +
            "##...##..####.####.#..##\n" +
            ".###.#########.###..#.##\n" +
            "#.##.#.#...##...#####..#\n" +
            "##.#..###############.##\n" +
            "##.###.#####.##.######..\n" +
            "##.#####.#.#.##..#######\n" +
            "...#######.######...####\n" +
            "#....#.#.#.####.#.#.#.##").split("\n");
}
