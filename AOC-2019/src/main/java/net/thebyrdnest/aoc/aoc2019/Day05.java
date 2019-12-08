package net.thebyrdnest.aoc.aoc2019;

import net.thebyrdnest.aoc.utils.IntCodeComputer;

public class Day05 {
    public int solve1(int[] mem, int[] input) {
        IntCodeComputer intCodeComputer = new IntCodeComputer(1, mem);
        intCodeComputer.setInput(0, input[0]);
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
