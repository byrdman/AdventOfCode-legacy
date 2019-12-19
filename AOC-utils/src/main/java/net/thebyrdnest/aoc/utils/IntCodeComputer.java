package net.thebyrdnest.aoc.utils;

public class IntCodeComputer {

    IntCodeComputerCPU cpu;

    private String computerId;

    public IntCodeComputer(int computerId) {
        this(Integer.toString(computerId));
    }

    public IntCodeComputer(String computerId) {
        this.computerId = computerId;
    }

    public void bootComputer(long[] program) {
        cpu = new IntCodeComputerCPU(computerId, program);
        cpu.start();
    }

    public boolean isOutputReady() {
        return cpu.isOutputReady();
    }

    public long getOutputValue() {
        return cpu.getOutputValue();
    }

    public long getMemoryValue(long index) {
        return cpu.getMemoryValue(index);
    }

    public void setMemoryValue(long index, long value) {
        cpu.setMemoryValue(index, value);
    }

    public void setInputValue(long value) {
        cpu.setInput(value);
    }

    public boolean isDone() {
        return cpu.isDone();
    }
}
