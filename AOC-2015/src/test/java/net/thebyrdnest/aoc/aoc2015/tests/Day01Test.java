package net.thebyrdnest.aoc.aoc2015.tests;

import net.thebyrdnest.aoc.aoc2015.Day01;
import org.junit.jupiter.api.*;

public class Day01Test {

    Day01 prob;

    @BeforeAll
    public static void setupBeforeClass() throws Exception {

    }

    @AfterAll
    public static void teardownAfterClass() throws Exception {

    }

    @BeforeEach
    public void setupBeforeEach() throws Exception {
    prob = new Day01();

    }

    @AfterEach
    public void tearDownAfterEach() throws Exception {

    }

    @Test
    public void Problem1() throws Exception {

        Assertions.assertEquals(280, prob.solve1("()()(()()()(()()((()((()))((()((((()()((((()))()((((())(((((((()(((((((((()(((())(()()(()((()()(()(())(()((((()((()()()((((())((((((()(()(((()())(()((((()))())(())(()(()()))))))))((((((((((((()())()())())(())))(((()()()((((()(((()(()(()()(()(()()(()(((((((())(())(())())))((()())()((((()()((()))(((()()()())))(())))((((())(((()())(())(()))(()((((()())))())((()(())(((()((((()((()(())())))((()))()()(()(()))))((((((((()())((((()()((((()(()())(((((()(()())()))())(((()))()(()(()(()((((()(())(()))(((((()()(()()()(()(((())())(((()()(()()))(((()()(((())())(()(())())()()(())()()()((()(((()(())((()()((())()))((()()))((()()())((((()(()()(()(((()))()(()))))((()(((()()()))(()(((())()(()((()())(()(()()(()())(())()(((()(()())()((((()((()))))())()))((()()()()(())()())()()()((((()))))(()(((()()(((((((())()))()((((()((())()(()())(())()))(()(()())(((((((())))(((()))())))))()))())((())(()()((())()())()))))()((()()())(())((())((((()())())()()()(((()))())))()()))())(()()()(()((((((()()))())()))()(((()(((())((((()()()(()))())()()))))())()))())((())()())(((((())())((())())))(((())(((())(((((()(((((())(()(()())())(()(())(()))(()((((()))())()))))())))((()(()))))())))(((((())()))())()))))()))))(((()))()))))((()))((()((()(()(())()())))(()()()(())()))()((((())))))))(())(()((()()))(()))(()))(()((()))))))()()((((()()))()())()))))))()()()))(()((())(()))((()()()())()(((()((((())())))()((((()(()))))))())))()()())()))(()))))(()())()))))))((())))))))())()))()((())())))(()((()))()))(())))))(()))()())()()))((()(()))()()()()))))())()()))())(())()()))()))((()))))()()(()())))))()()()))((((()))()))))(()(())))(()())))((())())(()))()))))()())))()())()())))))))))()()))))())))((())((()))))())))(((()())))))))(()))()()))(()))()))))()())))))())((((()())))))))())))()()))))))))()))()))))()))))))(())))))))))())))))))))))))))())())((())))))))))()))((())))()))))))))())()(()))))))())))))()()()())()(()()()(()())(()))()()()(()())))())())))()))))())))))))()()()()())(())())()())()))))(()()()()()))))()))())())))((()())()())))()))()))))(()())))()))))))))(((()))()()))))))))))))))))))))(()))(()((()))())))())(()))(()(()(())))))()(()))()))()()))))))))))))()((()())(())())()(())))))())()())((()()))))(()()))))())()(())()))))))))))))))))))))()))(()(()())))))))()()((()))()))))))((())))()))))))))((()))())()()))())()()))((()))())))))))))))(()())()))(())((()(()()))(()())(())))()())(()(())()()))))()))()(()))))))(()))))))))))(()))())))))))))())))))())))(())))))()))))(())())))))))))()(()))))()())))())(()))()())))))))))))))())()()))))()))))))())))))()))))(())(()()()()((())()))())(()))((())()))())())(())(()()))))()))(())()()((())(())))(())))()))())))))))))()(((((())())))(())()))))(())))((()))()(((((((()))))()()))(())))))()(()))))(()()))()))())))))))(()())()))))))))())))(()))())()))(())()((())())()())())(()(()))))()))))))((()())(())()()(()())))()()))(())(())(()))())))()))(()))()()))((((()))))()))((()()()))))()))()))())))(()))()))))(())))()))())()(()))()())))())))))))())))())))()()))))))(()))())())))()))()()())())))))))))))))())))()))(()()))))())))())()(())))())))))))))))))))))()()())())))))()()()((()(()))()()(())()())()))()))))()()()))))))((()))))))))()(()(()((((((()()((()())))))))))))()))())))))((())())(()))())))())))))())()()())(())))())))()())())(())))))))()()(())))()))())))())())())()))))))))()))(()()()())())())))(())())))))))()()())()))))())))())()(())())))))))()())()))(()()(())())))()(()((()()((()()(((((())(()())()))(())()))(())))(())))))))()))()))((()))()))()))))))))()))))))))((()()())(()))(((()))(())))()))((())(((())))()())))())))))((())))))(())())((((((())())()(()))()(()((()())))((())()(()(()))))(())(()()())(())))())((()(((())())))(((()())())))())()(())())((((()()))))())((()))()()()()(())(((((((()()()((()))())(()())))(())())((((()()(()))))()((())))((())()))()(((()))())))()))((()(()))(())(()((((())((((()()(()()))(((())(()))))((((()(()))(())))))((()))(()))((()(((()(()))(()(()((()(())(()(()(()(()()((()))())(((())(()(()))))(()))()()))(())))(())()(((())(()))()((((()()))))())(()))))((())()((((()(((()))())())(((()))()())((())(())())(())()(())()(()()((((((()()))))()()(((()()))))()())()(((()(()))(()(()())(()(()))))(((((()(((())())))))(((((()((()()((())())((((((()(())(()()((()()()()()()()(()()))()(((()))()))(((((((())(((()((()())()((((())(((()(())))()((()(()()()((())((()())()))()))())))())((((((()))(()(()()()))(()((()(()(()))()((()(((()()()((())(((((())()(()))())())((()(())))(()(()())(())((())())())(((()()()(())))))())(()))))))()))))))())((()()()))((()((((((()))(((()((((()()()(((()))())()(()()(((()((()()()()())()()))()()()(()(())((()))))(()))())))))))()(()()(((((())()(()(((((()((()(()()())(()((((((((()((((((())()((((()()()((()((()((((((()))((())))))))())()))((()(()))()(()()(()((())((()()((((((((((((()())(()()()))((((()((((((())(()))())(()()((()()))()(((((((()((()()((((((()(((())))((())))((((((((()()(((((((())(((((()())(((())((())()((((()(((((((()(()(((()((((((()(((()(((((((((((()()((()()(()))((()()(((()(((())))((((())()(()(((())()(()(((())(((((((((((()))())))((((((())((()()((((()())())((((()()))((())(((((()(()()(()()()((())(()((()()((((()(((((()((()(()((((()())((((((()(((((()()(()(()((((())))(())(())(())((((()(()()((((()((((()()((()((((((())))(((((()))))()))(()((((((((()(((())())(((())))(()(()((())(((()((()()(((((()((()()(((())()(()))(((((((())(()(((((()))((()((()((()))(())())((((()((((())()(()))(((()(((((((((((((((())(((((((((()))(((()(()()()()((((((()((())()((((((((()(())(((((((((((()(()((())()((()()(()(()()((((()()((())(()((()()(()()((((()(((((((())))((((())(())()(((()()((()()((((()((()(((()((())(((()()()((((()((((()()(()(()((((((((())(()(((((())(()())(((((((()())()(()((((()((())(()()())((((()()(((()((((())(())(()()(((((((((()()))()(((())(()(()((((((())(()()())(()))()()(((()(((()((())(()(((((((()(()(()((()(((((()(()((()(()((((((()((((()()((((()(((()((())(()(()((()()((((()()(())()(())(((())(()((((((((()())(((((((((()(())()((((())))()))()()(((((()()((((((())(()()(((()(()(((((((()(()(((((((())(())((((()((()(())))((((()()())(()))((()())((((()(((((()(()(())(()(()()())(((((()(((((()((((()()((((((((()()))(()((((((())((((())()(()(((()()()(((()(()(())(())(((((()(())())((((())(())(()(((()(((((())((((())())((()(((((((()(((())(()(()))(((((((((()((()((()()(()((((())(((()((())((((())(()(((()(((()(()((((()(((())(()(((()(()()(()(()((()()(()())(())())((()(()(((()(((()(((()()(((((((((()(((((((((()()(((()(((()())((((()(()(((()()()((())((((((((((())(()(((()((((()())((((()((()))(((()()()(((((()(((((((())((()())(()((((())((((((((())(()((()((((((((((()()((()((()()))(((()())()())()(((()())()()(()(()(((((((())()))(())()))())()()((())()((()((((()((()((())(((((()((((((()(())))(()))())(((()))((()()(()(((()))((((())()(((()))))()(()(())()(((((())(()(()(())(())()((()()()((((()(())((()())(()(()))(()(()(()()(())()()(()((())()((()))))()))((()(()()()()((()())(()))())()(()(((((((((())())((()((()((((((())()((((())(((())((()(()()()((())(()((())(((()((((()()((()(()(((((())()))()((((((()))((())(((()()))(((())(())()))(((((((())(())())()(())(((((()))()((()))()(()()((()()()()()())((((((("));
    }

    @Test
    public void Problem2() throws Exception {

        Assertions.assertEquals(1797, prob.solve2("()()(()()()(()()((()((()))((()((((()()((((()))()((((())(((((((()(((((((((()(((())(()()(()((()()(()(())(()((((()((()()()((((())((((((()(()(((()())(()((((()))())(())(()(()()))))))))((((((((((((()())()())())(())))(((()()()((((()(((()(()(()()(()(()()(()(((((((())(())(())())))((()())()((((()()((()))(((()()()())))(())))((((())(((()())(())(()))(()((((()())))())((()(())(((()((((()((()(())())))((()))()()(()(()))))((((((((()())((((()()((((()(()())(((((()(()())()))())(((()))()(()(()(()((((()(())(()))(((((()()(()()()(()(((())())(((()()(()()))(((()()(((())())(()(())())()()(())()()()((()(((()(())((()()((())()))((()()))((()()())((((()(()()(()(((()))()(()))))((()(((()()()))(()(((())()(()((()())(()(()()(()())(())()(((()(()())()((((()((()))))())()))((()()()()(())()())()()()((((()))))(()(((()()(((((((())()))()((((()((())()(()())(())()))(()(()())(((((((())))(((()))())))))()))())((())(()()((())()())()))))()((()()())(())((())((((()())())()()()(((()))())))()()))())(()()()(()((((((()()))())()))()(((()(((())((((()()()(()))())()()))))())()))())((())()())(((((())())((())())))(((())(((())(((((()(((((())(()(()())())(()(())(()))(()((((()))())()))))())))((()(()))))())))(((((())()))())()))))()))))(((()))()))))((()))((()((()(()(())()())))(()()()(())()))()((((())))))))(())(()((()()))(()))(()))(()((()))))))()()((((()()))()())()))))))()()()))(()((())(()))((()()()())()(((()((((())())))()((((()(()))))))())))()()())()))(()))))(()())()))))))((())))))))())()))()((())())))(()((()))()))(())))))(()))()())()()))((()(()))()()()()))))())()()))())(())()()))()))((()))))()()(()())))))()()()))((((()))()))))(()(())))(()())))((())())(()))()))))()())))()())()())))))))))()()))))())))((())((()))))())))(((()())))))))(()))()()))(()))()))))()())))))())((((()())))))))())))()()))))))))()))()))))()))))))(())))))))))())))))))))))))))())())((())))))))))()))((())))()))))))))())()(()))))))())))))()()()())()(()()()(()())(()))()()()(()())))())())))()))))())))))))()()()()())(())())()())()))))(()()()()()))))()))())())))((()())()())))()))()))))(()())))()))))))))(((()))()()))))))))))))))))))))(()))(()((()))())))())(()))(()(()(())))))()(()))()))()()))))))))))))()((()())(())())()(())))))())()())((()()))))(()()))))())()(())()))))))))))))))))))))()))(()(()())))))))()()((()))()))))))((())))()))))))))((()))())()()))())()()))((()))())))))))))))(()())()))(())((()(()()))(()())(())))()())(()(())()()))))()))()(()))))))(()))))))))))(()))())))))))))())))))())))(())))))()))))(())())))))))))()(()))))()())))())(()))()())))))))))))))())()()))))()))))))())))))()))))(())(()()()()((())()))())(()))((())()))())())(())(()()))))()))(())()()((())(())))(())))()))())))))))))()(((((())())))(())()))))(())))((()))()(((((((()))))()()))(())))))()(()))))(()()))()))())))))))(()())()))))))))())))(()))())()))(())()((())())()())())(()(()))))()))))))((()())(())()()(()())))()()))(())(())(()))())))()))(()))()()))((((()))))()))((()()()))))()))()))())))(()))()))))(())))()))())()(()))()())))())))))))())))())))()()))))))(()))())())))()))()()())())))))))))))))())))()))(()()))))())))())()(())))())))))))))))))))))()()())())))))()()()((()(()))()()(())()())()))()))))()()()))))))((()))))))))()(()(()((((((()()((()())))))))))))()))())))))((())())(()))())))())))))())()()())(())))())))()())())(())))))))()()(())))()))())))())())())()))))))))()))(()()()())())())))(())())))))))()()())()))))())))())()(())())))))))()())()))(()()(())())))()(()((()()((()()(((((())(()())()))(())()))(())))(())))))))()))()))((()))()))()))))))))()))))))))((()()())(()))(((()))(())))()))((())(((())))()())))())))))((())))))(())())((((((())())()(()))()(()((()())))((())()(()(()))))(())(()()())(())))())((()(((())())))(((()())())))())()(())())((((()()))))())((()))()()()()(())(((((((()()()((()))())(()())))(())())((((()()(()))))()((())))((())()))()(((()))())))()))((()(()))(())(()((((())((((()()(()()))(((())(()))))((((()(()))(())))))((()))(()))((()(((()(()))(()(()((()(())(()(()(()(()()((()))())(((())(()(()))))(()))()()))(())))(())()(((())(()))()((((()()))))())(()))))((())()((((()(((()))())())(((()))()())((())(())())(())()(())()(()()((((((()()))))()()(((()()))))()())()(((()(()))(()(()())(()(()))))(((((()(((())())))))(((((()((()()((())())((((((()(())(()()((()()()()()()()(()()))()(((()))()))(((((((())(((()((()())()((((())(((()(())))()((()(()()()((())((()())()))()))())))())((((((()))(()(()()()))(()((()(()(()))()((()(((()()()((())(((((())()(()))())())((()(())))(()(()())(())((())())())(((()()()(())))))())(()))))))()))))))())((()()()))((()((((((()))(((()((((()()()(((()))())()(()()(((()((()()()()())()()))()()()(()(())((()))))(()))())))))))()(()()(((((())()(()(((((()((()(()()())(()((((((((()((((((())()((((()()()((()((()((((((()))((())))))))())()))((()(()))()(()()(()((())((()()((((((((((((()())(()()()))((((()((((((())(()))())(()()((()()))()(((((((()((()()((((((()(((())))((())))((((((((()()(((((((())(((((()())(((())((())()((((()(((((((()(()(((()((((((()(((()(((((((((((()()((()()(()))((()()(((()(((())))((((())()(()(((())()(()(((())(((((((((((()))())))((((((())((()()((((()())())((((()()))((())(((((()(()()(()()()((())(()((()()((((()(((((()((()(()((((()())((((((()(((((()()(()(()((((())))(())(())(())((((()(()()((((()((((()()((()((((((())))(((((()))))()))(()((((((((()(((())())(((())))(()(()((())(((()((()()(((((()((()()(((())()(()))(((((((())(()(((((()))((()((()((()))(())())((((()((((())()(()))(((()(((((((((((((((())(((((((((()))(((()(()()()()((((((()((())()((((((((()(())(((((((((((()(()((())()((()()(()(()()((((()()((())(()((()()(()()((((()(((((((())))((((())(())()(((()()((()()((((()((()(((()((())(((()()()((((()((((()()(()(()((((((((())(()(((((())(()())(((((((()())()(()((((()((())(()()())((((()()(((()((((())(())(()()(((((((((()()))()(((())(()(()((((((())(()()())(()))()()(((()(((()((())(()(((((((()(()(()((()(((((()(()((()(()((((((()((((()()((((()(((()((())(()(()((()()((((()()(())()(())(((())(()((((((((()())(((((((((()(())()((((())))()))()()(((((()()((((((())(()()(((()(()(((((((()(()(((((((())(())((((()((()(())))((((()()())(()))((()())((((()(((((()(()(())(()(()()())(((((()(((((()((((()()((((((((()()))(()((((((())((((())()(()(((()()()(((()(()(())(())(((((()(())())((((())(())(()(((()(((((())((((())())((()(((((((()(((())(()(()))(((((((((()((()((()()(()((((())(((()((())((((())(()(((()(((()(()((((()(((())(()(((()(()()(()(()((()()(()())(())())((()(()(((()(((()(((()()(((((((((()(((((((((()()(((()(((()())((((()(()(((()()()((())((((((((((())(()(((()((((()())((((()((()))(((()()()(((((()(((((((())((()())(()((((())((((((((())(()((()((((((((((()()((()((()()))(((()())()())()(((()())()()(()(()(((((((())()))(())()))())()()((())()((()((((()((()((())(((((()((((((()(())))(()))())(((()))((()()(()(((()))((((())()(((()))))()(()(())()(((((())(()(()(())(())()((()()()((((()(())((()())(()(()))(()(()(()()(())()()(()((())()((()))))()))((()(()()()()((()())(()))())()(()(((((((((())())((()((()((((((())()((((())(((())((()(()()()((())(()((())(((()((((()()((()(()(((((())()))()((((((()))((())(((()()))(((())(())()))(((((((())(())())()(())(((((()))()((()))()(()()((()()()()()())((((((("));
    }
}