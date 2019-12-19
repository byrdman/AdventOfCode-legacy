package net.thebyrdnest.aoc.aoc2019;

import net.thebyrdnest.aoc.utils.IntCodeComputer;

import java.util.ArrayList;

public class Day05 {
    public String solve1(long[] mem, long input) {
        ArrayList<Long> outputQueue = new ArrayList<>();
        IntCodeComputer intCodeComputer = new IntCodeComputer("1");
        intCodeComputer.bootComputer(mem);

        intCodeComputer.setInputValue(input);

        while (!intCodeComputer.isDone()) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                System.err.println("05-1 - wait error");
            }
        }

        StringBuilder sb = new StringBuilder();
        while (intCodeComputer.isOutputReady()) {
            sb.append("output: " + intCodeComputer.getOutputValue() + "\n");
        }
        return sb.toString();
    }
}