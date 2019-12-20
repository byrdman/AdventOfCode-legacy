package net.thebyrdnest.aoc.utils;

import java.util.ArrayList;
import java.util.HashMap;

public class IntCodeComputer {

    IntCodeComputerCPU cpu;

    private String computerId;
    HashMap<Long, Long> ram;
    private ArrayList<Long> inputQueue;
    private ArrayList<Long> outputQueue;

    public IntCodeComputer(int computerId) {
        this(Integer.toString(computerId));
    }

    public IntCodeComputer(String computerId) {
        this.computerId = computerId;
    }

    public void bootComputer(long[] program) {
        inputQueue = new ArrayList<>();
        outputQueue = new ArrayList<>();

        ram = new HashMap<>();
        long counter = 0;
        for (long mem_byte : program) {
            ram.put(counter++, mem_byte);
        }

        cpu = new IntCodeComputerCPU(computerId, ram, inputQueue, outputQueue);
        cpu.start();
    }

    public boolean isOutputReady() {
        /*while (outputQueue.size() != 0) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                System.err.println("11-1 sleep error");
            }
        }*/

        return (outputQueue.size() > 0);
    }

    public void setInputValue(long value) {
        inputQueue.add(value);
    }

    public long getOutputValue() {
        Long returnValue = null;
        while (outputQueue.get(0) == null)
            outputQueue.remove(0);

        do {
            returnValue = outputQueue.get(0);
        } while (returnValue == null);
        outputQueue.remove(0);

        return returnValue;
    }

    public void setMemoryValue(long index, long value) {
        ram.put(index, value);
    }

    public long getMemoryValue(long index) {
        Long memVal = ram.get(index);
        if (memVal == null)
            return 0;
        else
            return memVal.longValue();
    }

    public boolean isDone() {
        return cpu.isDone();
    }
}
