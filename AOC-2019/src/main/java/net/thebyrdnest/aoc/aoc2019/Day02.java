package net.thebyrdnest.aoc.aoc2019;

import net.thebyrdnest.aoc.utils.IntCodeComputer;
import net.thebyrdnest.aoc.utils.IntCodeComputerCPU;

import java.util.HashMap;

public class Day02 {
    public long solve1(long[] mem) {
        IntCodeComputer computer = new IntCodeComputer("1");
        computer.bootComputer(mem);

        while (!computer.isDone()) {
            try {
                wait(500);
            } catch (Exception ex) {
                // do nothing;
            }
        }

        return computer.getMemoryValue(0);
    }

    public int solve2(long[] mem, long target) {
        boolean bDone = false;
        for (int noun = 0; noun <= 99; noun++) {
            for (int verb = 0; verb <= 99; verb++) {
                try {
                    mem[1] = noun;
                    mem[2] = verb;
                    long result = solve1(mem);

                    if (result == target) {
                        return 100*noun + verb;
                    }
                } catch (Exception e) {
                    // System.out.println("exception");
                }
            }
        }
        return -1;
    }
}
