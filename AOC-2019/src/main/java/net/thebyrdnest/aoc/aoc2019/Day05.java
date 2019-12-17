package net.thebyrdnest.aoc.aoc2019;

import net.thebyrdnest.aoc.utils.IntCodeComputer;

public class Day05 {
    public String solve1(long[] mem, long input) {
        IntCodeComputer intCodeComputer = new IntCodeComputer(1, mem);
        intCodeComputer.start();

        intCodeComputer.setInput(input);
        intCodeComputer.setInputReady(true);

        while (!intCodeComputer.isDone()) {
            try {
                //wait(500);
                Thread.yield();
            } catch (Exception ex) {
                // do nothing;
            }
        }

        StringBuilder sb = new StringBuilder();
        while (intCodeComputer.isOutputReady()) {
            sb.append("output: " + intCodeComputer.getOutputValue() + "\n");
        }
        return sb.toString();
    }
}
