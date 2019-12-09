package net.thebyrdnest.aoc.aoc2019;

import net.thebyrdnest.aoc.utils.IntCodeComputer;

import java.util.ArrayList;
import java.util.Arrays;

public class Day09 {
    IntCodeComputer computer;
    public long solve1(long[] program) {
        computer = new IntCodeComputer(0, program);
        computer.setInput(1);
        computer.setInputReady(true);
        computer.run();
        return computer.getOutputValue();
    }
}