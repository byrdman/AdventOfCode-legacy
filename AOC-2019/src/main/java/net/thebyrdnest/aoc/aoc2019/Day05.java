package net.thebyrdnest.aoc.aoc2019;

import net.thebyrdnest.aoc.utils.IntCodeComputer;

public class Day05 {
    public int solve1(int[] mem, int noun, int verb) {
        IntCodeComputer intCodeComputer = new IntCodeComputer();
        intCodeComputer.initMemory(mem);
        return intCodeComputer.program(noun, verb);
    }
}
