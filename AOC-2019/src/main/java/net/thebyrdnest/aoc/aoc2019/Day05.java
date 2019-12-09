package net.thebyrdnest.aoc.aoc2019;

import net.thebyrdnest.aoc.utils.IntCodeComputer;

public class Day05 {
    public long solve1(long[] mem, long input) {
        IntCodeComputer intCodeComputer = new IntCodeComputer(1, mem);
        intCodeComputer.setInput(input);
        intCodeComputer.setInputReady(true);
        intCodeComputer.run();

        while (!intCodeComputer.isDone()) {
            try {
                wait(500);
            } catch (Exception ex) {
                // do nothing;
            }
        }

        return intCodeComputer.getOutputValue();
    }
}
