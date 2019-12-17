package net.thebyrdnest.aoc.aoc2019;

import net.thebyrdnest.aoc.utils.IntCodeComputer;

import java.util.ArrayList;
import java.util.Arrays;

public class Day09 {
    IntCodeComputer computer;

    public long BOOST(long[] program, long input) {
        computer = new IntCodeComputer(0, program);
        computer.start();
        computer.setInput(input);
        computer.setInputReady(true);
        //computer.run();
        while(!computer.isOutputReady())
            Thread.yield();

        return computer.getOutputValue();
    }
}