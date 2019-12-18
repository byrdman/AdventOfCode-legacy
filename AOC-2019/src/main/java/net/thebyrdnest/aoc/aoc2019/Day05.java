package net.thebyrdnest.aoc.aoc2019;

import net.thebyrdnest.aoc.utils.IntCodeComputer;

public class Day05 {
    public String solve1(long[] mem, long input) {
        IntCodeComputer intCodeComputer = new IntCodeComputer(1, mem);
        intCodeComputer.start();

        intCodeComputer.setInput(input);

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
