package net.thebyrdnest.aoc.aoc2015.tests;

import net.thebyrdnest.aoc.aoc2015.Day13;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

public class Day13Test {

    Day13 solver;

    @BeforeAll
    public static void setupBeforeClass() throws Exception {

    }

    @AfterAll
    public static void teardownAfterClass() throws Exception {

    }

    @BeforeEach
    public void setupBeforeEach() throws Exception {
        solver = new Day13();

    }

    @AfterEach
    public void tearDownAfterEach() throws Exception {

    }

    @Test
    public void Example_2() {
        String[] data = ("Alice would gain 54 happiness units by sitting next to Bob.\n" +
                "Alice would lose 79 happiness units by sitting next to Carol.\n" +
                "Alice would lose 2 happiness units by sitting next to David.\n" +
                "Bob would gain 83 happiness units by sitting next to Alice.\n" +
                "Bob would lose 7 happiness units by sitting next to Carol.\n" +
                "Bob would lose 63 happiness units by sitting next to David.\n" +
                "Carol would lose 62 happiness units by sitting next to Alice.\n" +
                "Carol would gain 60 happiness units by sitting next to Bob.\n" +
                "Carol would gain 55 happiness units by sitting next to David.\n" +
                "David would gain 46 happiness units by sitting next to Alice.\n" +
                "David would lose 7 happiness units by sitting next to Bob.\n" +
                "David would gain 41 happiness units by sitting next to Carol.").split("\n");
        solver.loadData(data);

        int happyness = solver.calcHappyness("BCDA");

        Assertions.assertEquals(330, happyness);


    }

    @Test
    public void Problem_1() {
        solver.loadData(myInput.split("\n"));
        // 579 is too low
        Assertions.assertEquals(733, solver.solve1());
    }

    @Test
    public void Problem_2() {
        myInput += "\nSam would gain 0 happiness units by sitting next to Alice.\n" +
                "Sam would gain 0 happiness units by sitting next to Bob.\n" +
                "Sam would gain 0 happiness units by sitting next to Carol.\n" +
                "Sam would gain 0 happiness units by sitting next to David.\n" +
                "Sam would gain 0 happiness units by sitting next to Eric.\n" +
                "Sam would gain 0 happiness units by sitting next to Frank.\n" +
                "Sam would gain 0 happiness units by sitting next to George.\n" +
                "Sam would gain 0 happiness units by sitting next to Mallory.\n" +
                "Alice would gain 0 happiness units by sitting next to Sam.\n" +
                "Bob would gain 0 happiness units by sitting next to Sam.\n" +
                "Carol would gain 0 happiness units by sitting next to Sam.\n" +
                "David would gain 0 happiness units by sitting next to Sam.\n" +
                "Eric would gain 0 happiness units by sitting next to Sam.\n" +
                "Frank would gain 0 happiness units by sitting next to Sam.\n" +
                "George would gain 0 happiness units by sitting next to Sam.\n" +
                "Mallory would gain 0 happiness units by sitting next to Sam.";
        solver.loadData(myInput.split("\n"));
        // 579 is too low
        Assertions.assertEquals(725, solver.solve1());
    }

    String myInput = "Alice would gain 2 happiness units by sitting next to Bob.\n" +
            "Alice would gain 26 happiness units by sitting next to Carol.\n" +
            "Alice would lose 82 happiness units by sitting next to David.\n" +
            "Alice would lose 75 happiness units by sitting next to Eric.\n" +
            "Alice would gain 42 happiness units by sitting next to Frank.\n" +
            "Alice would gain 38 happiness units by sitting next to George.\n" +
            "Alice would gain 39 happiness units by sitting next to Mallory.\n" +
            "Bob would gain 40 happiness units by sitting next to Alice.\n" +
            "Bob would lose 61 happiness units by sitting next to Carol.\n" +
            "Bob would lose 15 happiness units by sitting next to David.\n" +
            "Bob would gain 63 happiness units by sitting next to Eric.\n" +
            "Bob would gain 41 happiness units by sitting next to Frank.\n" +
            "Bob would gain 30 happiness units by sitting next to George.\n" +
            "Bob would gain 87 happiness units by sitting next to Mallory.\n" +
            "Carol would lose 35 happiness units by sitting next to Alice.\n" +
            "Carol would lose 99 happiness units by sitting next to Bob.\n" +
            "Carol would lose 51 happiness units by sitting next to David.\n" +
            "Carol would gain 95 happiness units by sitting next to Eric.\n" +
            "Carol would gain 90 happiness units by sitting next to Frank.\n" +
            "Carol would lose 16 happiness units by sitting next to George.\n" +
            "Carol would gain 94 happiness units by sitting next to Mallory.\n" +
            "David would gain 36 happiness units by sitting next to Alice.\n" +
            "David would lose 18 happiness units by sitting next to Bob.\n" +
            "David would lose 65 happiness units by sitting next to Carol.\n" +
            "David would lose 18 happiness units by sitting next to Eric.\n" +
            "David would lose 22 happiness units by sitting next to Frank.\n" +
            "David would gain 2 happiness units by sitting next to George.\n" +
            "David would gain 42 happiness units by sitting next to Mallory.\n" +
            "Eric would lose 65 happiness units by sitting next to Alice.\n" +
            "Eric would gain 24 happiness units by sitting next to Bob.\n" +
            "Eric would gain 100 happiness units by sitting next to Carol.\n" +
            "Eric would gain 51 happiness units by sitting next to David.\n" +
            "Eric would gain 21 happiness units by sitting next to Frank.\n" +
            "Eric would gain 55 happiness units by sitting next to George.\n" +
            "Eric would lose 44 happiness units by sitting next to Mallory.\n" +
            "Frank would lose 48 happiness units by sitting next to Alice.\n" +
            "Frank would gain 91 happiness units by sitting next to Bob.\n" +
            "Frank would gain 8 happiness units by sitting next to Carol.\n" +
            "Frank would lose 66 happiness units by sitting next to David.\n" +
            "Frank would gain 97 happiness units by sitting next to Eric.\n" +
            "Frank would lose 9 happiness units by sitting next to George.\n" +
            "Frank would lose 92 happiness units by sitting next to Mallory.\n" +
            "George would lose 44 happiness units by sitting next to Alice.\n" +
            "George would lose 25 happiness units by sitting next to Bob.\n" +
            "George would gain 17 happiness units by sitting next to Carol.\n" +
            "George would gain 92 happiness units by sitting next to David.\n" +
            "George would lose 92 happiness units by sitting next to Eric.\n" +
            "George would gain 18 happiness units by sitting next to Frank.\n" +
            "George would gain 97 happiness units by sitting next to Mallory.\n" +
            "Mallory would gain 92 happiness units by sitting next to Alice.\n" +
            "Mallory would lose 96 happiness units by sitting next to Bob.\n" +
            "Mallory would lose 51 happiness units by sitting next to Carol.\n" +
            "Mallory would lose 81 happiness units by sitting next to David.\n" +
            "Mallory would gain 31 happiness units by sitting next to Eric.\n" +
            "Mallory would lose 73 happiness units by sitting next to Frank.\n" +
            "Mallory would lose 89 happiness units by sitting next to George.";

}
