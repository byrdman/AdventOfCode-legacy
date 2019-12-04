package net.thebyrdnest.aoc.aoc2019.tests;

import net.thebyrdnest.aoc.aoc2019.Day01;
import org.junit.jupiter.api.*;

public class Day01Test {
    Day01 day01;

    @BeforeAll
    public static void setupBeforeClass() throws Exception {

    }

    @AfterAll
    public static void teardownAfterClass() throws Exception {

    }

    @BeforeEach
    public void setupBeforeEach() throws Exception {
        day01 = new Day01();
    }

    @AfterEach
    public void tearDownAfterEach() throws Exception {

    }

    @Test
    public void Example1() throws Exception {
        Assertions.assertEquals(2, day01.solve1(new int[] {12}));
    }

    @Test
    public void Example2() throws Exception {
        Assertions.assertEquals(2, day01.solve1(new int[] {14}));
    }

    @Test
    public void Example3() throws Exception {
        Assertions.assertEquals(654, day01.solve1(new int[] {1969}));
    }

    @Test
    public void Example4() throws Exception {
        Assertions.assertEquals(33583, day01.solve1(new int[] {100756}));
    }

    @Test
    public void Example5() throws Exception {
        Assertions.assertEquals(2, day01.solve2(new int[] {14}));
    }

    @Test
    public void Example6() throws Exception {
        Assertions.assertEquals(966, day01.solve2(new int[] {1969}));
    }

    @Test
    public void Example7() throws Exception {
        Assertions.assertEquals(50346, day01.solve2(new int[] {100756}));
    }

    @Test
    public void Problem1() throws Exception {
        Assertions.assertEquals(3347838, day01.solve1(new int[] {102480,121446,118935,54155,102510,142419,73274,57571,123916,99176,143124,141318,72224,145479,97027,126427,94990,100521,105589,123009,77143,142861,92366,66478,102195,128373,128447,120178,99122, 98671,89541,125720,107984,126544,145231,110241,123926,72793,76705,128338,74262,68845,65297,112536,59892,57115,73230,80569,146118,108843,59221,140492,122616,140652,64404,99782,104375,86926,143145,114969,108948,77236,143655,71406,97588,64892,105345,104393,93442,54525,94116,123606,106813,59904,149253,81620,80892,66309,142604,97984,79743,79448,123756,64927,139703,71448,135964,86083,94767,116856,73786,141083,122581,82239,122282,96092,80029,52957,72062,52124}));
    }

    @Test
    public void Problem2() throws Exception {
        Assertions.assertEquals(5018888, day01.solve2(new int[] {102480,121446,118935,54155,102510,142419,73274,57571,123916,99176,143124,141318,72224,145479,97027,126427,94990,100521,105589,123009,77143,142861,92366,66478,102195,128373,128447,120178,99122, 98671,89541,125720,107984,126544,145231,110241,123926,72793,76705,128338,74262,68845,65297,112536,59892,57115,73230,80569,146118,108843,59221,140492,122616,140652,64404,99782,104375,86926,143145,114969,108948,77236,143655,71406,97588,64892,105345,104393,93442,54525,94116,123606,106813,59904,149253,81620,80892,66309,142604,97984,79743,79448,123756,64927,139703,71448,135964,86083,94767,116856,73786,141083,122581,82239,122282,96092,80029,52957,72062,52124}));
    }
}
