package net.thebyrdnest.aoc.aoc2019;

import net.thebyrdnest.aoc.utils.IntCodeComputer;
import net.thebyrdnest.aoc.utils.IntCodeComputerCPU;

public class Day09 {
    IntCodeComputer computer;

    public long BOOST(long[] program, long input) {
        computer = new IntCodeComputer("0");
        computer.bootComputer(program);
        computer.setInputValue(input);

        while(!computer.isOutputReady()) {
            try {
                Thread.sleep(10);
                //System.out.println("BOOST: waiting on input");
            } catch (InterruptedException ex) {
                System.err.println("09-1 sleep error");
            }
        }

        return computer.getOutputValue();
    }
}