package net.thebyrdnest.aoc.aoc2019;

import net.thebyrdnest.aoc.utils.IntCodeComputerCPU;

public class Day09 {
    IntCodeComputerCPU computer;

    public long BOOST(long[] program, long input) {
        computer = new IntCodeComputerCPU("0", program);
        computer.start();
        computer.setInput(input);
        //computer.run();
        while(!computer.isOutputReady()) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                System.err.println("09-1 sleep error");
            }
        }

        return computer.getOutputValue();
    }
}