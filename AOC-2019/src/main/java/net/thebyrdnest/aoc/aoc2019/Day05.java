package net.thebyrdnest.aoc.aoc2019;

import net.thebyrdnest.aoc.utils.IntCodeComputer;

public class Day05 {
    public int solve1(int[] mem, int input) {
        IntCodeComputer intCodeComputer = new IntCodeComputer();
        intCodeComputer.initMemory(mem);
        return intCodeComputer.runProgram(input, true);
    }
}
