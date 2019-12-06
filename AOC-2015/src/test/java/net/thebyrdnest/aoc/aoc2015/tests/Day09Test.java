package net.thebyrdnest.aoc.aoc2015.tests;

import net.thebyrdnest.aoc.aoc2015.Day09;
import org.junit.jupiter.api.*;

public class Day09Test {

    Day09 solver;

    @BeforeAll
    public static void setupBeforeClass() throws Exception {

    }

    @AfterAll
    public static void teardownAfterClass() throws Exception {

    }

    @BeforeEach
    public void setupBeforeEach() throws Exception {
        solver = new Day09();

    }

    @AfterEach
    public void tearDownAfterEach() throws Exception {

    }

    @Test
    public void Example_1() throws Exception {
        String input = "London to Dublin = 464\n" +
                "London to Belfast = 518\n" +
                "Dublin to Belfast = 141";

        solver.parseInput(input.split("\n"));
        solver.printGrid();
        System.out.println("Min: " + solver.solve2());
        System.out.println(solver.minTrip);
    }

    @Test
    public void Problem_1() throws Exception {
        solver.parseInput(myInput.split("\n"));
        solver.printGrid();
        solver.solve();
        System.out.println("Min: " + solver.minTrip);
        System.out.println("Min: " + solver.minDistance);
        Assertions.assertEquals(141, solver.minDistance);

        System.out.println("Max: " + solver.maxTrip);
        System.out.println("Max: " + solver.maxDistance);
        Assertions.assertEquals(736, solver.maxDistance);
    }


    String myInput = "AlphaCentauri to Snowdin = 66\n" +
            "AlphaCentauri to Tambi = 28\n" +
            "AlphaCentauri to Faerun = 60\n" +
            "AlphaCentauri to Norrath = 34\n" +
            "AlphaCentauri to Straylight = 34\n" +
            "AlphaCentauri to Tristram = 3\n" +
            "AlphaCentauri to Arbre = 108\n" +
            "Snowdin to Tambi = 22\n" +
            "Snowdin to Faerun = 12\n" +
            "Snowdin to Norrath = 91\n" +
            "Snowdin to Straylight = 121\n" +
            "Snowdin to Tristram = 111\n" +
            "Snowdin to Arbre = 71\n" +
            "Tambi to Faerun = 39\n" +
            "Tambi to Norrath = 113\n" +
            "Tambi to Straylight = 130\n" +
            "Tambi to Tristram = 35\n" +
            "Tambi to Arbre = 40\n" +
            "Faerun to Norrath = 63\n" +
            "Faerun to Straylight = 21\n" +
            "Faerun to Tristram = 57\n" +
            "Faerun to Arbre = 83\n" +
            "Norrath to Straylight = 9\n" +
            "Norrath to Tristram = 50\n" +
            "Norrath to Arbre = 60\n" +
            "Straylight to Tristram = 27\n" +
            "Straylight to Arbre = 81\n" +
            "Tristram to Arbre = 90";
}
