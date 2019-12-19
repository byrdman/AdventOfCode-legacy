package net.thebyrdnest.aoc.aoc2019;

import net.thebyrdnest.aoc.utils.IntCodeComputer;
import net.thebyrdnest.aoc.utils.IntCodeComputerCPU;

public class Day02 {
    public long solve1(long[] mem) {
        IntCodeComputerCPU intCodeComputerCPU = new IntCodeComputerCPU("1", mem);
        intCodeComputerCPU.start();

        while (!intCodeComputerCPU.isDone()) {
            try {
                wait(500);
            } catch (Exception ex) {
                // do nothing;
            }
        }

        return intCodeComputerCPU.getMemoryValue(0);
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

    public long solve1b(long[] mem) {
        IntCodeComputer intCodeComputer = new IntCodeComputer("1");
        intCodeComputer.bootComputer(mem);

        while (!intCodeComputer.isDone()) {
            try {
                wait(500);
            } catch (Exception ex) {
                // do nothing;
            }
        }

        return intCodeComputer.getMemoryValue(0);
    }
}
