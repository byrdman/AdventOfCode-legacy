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

        double solution = solver.solve1(input);
        System.out.println(solver.printBest());
        Assertions.assertEquals(210, solution);
    }

    @Disabled
    @Test
    public void Example_2_1() {
        // disabled because solver2 returns the 200th astroid, but there aren't 200 in this example

        Day10 solver = new Day10();
        String[] input = (
                ".#....#####...#..\n" +
                "##...##.#####..##\n" +
                "##...#...#.#####.\n" +
                "..#.....#...###..\n" +
                "..#.#.....#....##"
                ).split("\n");


        double solution = solver.solve2(input);
        System.out.println(solver.printBest()); // should be (8,3)
        Assertions.assertEquals(802, solution);
    }

    @Test
    public void Example_2_2() {
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

        double solution = solver.solve2(input);
        System.out.println(solver.printBest());
        Assertions.assertEquals(802, solution);
    }

    @Test
    public void Problem1() {
        Day10 solver = new Day10();
        Assertions.assertEquals(280, solver.solve1(myInput));

    }

    @Test
    public void Problem2() {
        Day10 solver = new Day10();
        Assertions.assertEquals(706, solver.solve2(myInput));

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
