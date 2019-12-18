package net.thebyrdnest.aoc.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static java.lang.System.exit;

public class IntCodeComputer implements Runnable {
    Thread computerThread;

    private int computerId;
    private HashMap<Long, Long> memory;
    private long relativeBase = 0;
    private long[] defaultMemory = {};
    ArrayList<Long> inputQueue;
    ArrayList<Long> outputQueue;

    private boolean bDone = false;
    private boolean bInteractive;

    static final int POSITION = 0;
    static final int IMMEDIATE = 1;
    static final int RELATIVE = 2;

    public IntCodeComputer() {
        this(0, null, false);
    }

    public IntCodeComputer(int computerId, long[] program) {
        this(computerId, program, false);
    }

    public IntCodeComputer(int computerId, long[] program, boolean bInteractive) {
        this.computerId = computerId;
        memory = new HashMap<>();
        defaultMemory = Arrays.copyOf(program, program.length);
        resetMemory();

        this.bInteractive = bInteractive;
    }

    public void resetMemory() {
        memory = new HashMap<>();
        long counter = 0;
        for (long mem_byte : defaultMemory) {
            memory.put(counter, mem_byte);
            counter++;
        }
        relativeBase = 0;
        inputQueue = new ArrayList<>();
        outputQueue = new ArrayList<>();
        bDone = false;
    }

    public boolean isDone() {
        return bDone;
    }

    public boolean isInputReady() {
        return (inputQueue.size() > 0);
    }

    public boolean isOutputReady() {
        return (outputQueue.size() > 0);
    }

    public void setInput(long value) {
        inputQueue.add(value);
    }

    int iCount = 0;
    public long getOutputValue() {
        while (outputQueue.size() == 0) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                System.err.println("IC-1 - sleep error");
            }
        }

        iCount++;
        while (outputQueue.get(0) == null){
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                System.err.println("IC-1 - sleep error");
            }
        }

        long returnValue = -1;
        int index = 0;
        while (returnValue == -1) {
            try {
                returnValue = outputQueue.get(index);
                outputQueue.remove(index);
            } catch (Exception e) {
                index++;
            }
        }

        return returnValue;
    }

    public long getMemoryValue(long index) {
        Long memVal = memory.get(index);
        if (memVal == null)
            return 0;
        else
            return memVal.longValue();
    }

    public void start() {
        System.out.println("Computer Started - " + computerId);
        if (computerThread == null) {
            computerThread = new Thread(this, Integer.toString(computerId));
            computerThread.start();
        }
    }

    public void run() {
        System.out.println("Run Program - " + computerId);
        bDone = false;
        long parm1 = 0;
        long parm2 = 0;
        long parm3 = 0;
        long val1 = 0;
        long val2 = 0;
        long result = 0;
        int loopNum = 0;

        long i=0;
        while (!bDone) {
            int opCode = 0;
            int mode1;
            int mode2;
            int mode3;
            StringBuilder sb = new StringBuilder(Long.toString(memory.get(i)));
            while (sb.length() < 5)
                sb.insert(0, '0');

            mode3 = Integer.parseInt(sb.substring(0, 1));
            mode2 = Integer.parseInt(sb.substring(1, 2));
            mode1 = Integer.parseInt(sb.substring(2, 3));
            opCode = Integer.parseInt(sb.substring(3, 5));

            switch(opCode) {
                case 1: // add
                    //System.out.println("Add");
                    parm1 = memory.get(i + 1);
                    parm2 = memory.get(i + 2);
                    parm3 = memory.get(i + 3);

                    if (mode1 == POSITION)
                        val1 = getMemoryValue(parm1);
                    else if (mode1 == IMMEDIATE)
                        val1 = parm1;
                    else if (mode1 == RELATIVE)
                        val1 = getMemoryValue(relativeBase + parm1);
                    else
                        exit(11);

                    if (mode2 == POSITION)
                        val2 = getMemoryValue(parm2);
                    else if (mode2 == IMMEDIATE)
                        val2 = parm2;
                    else if (mode2 == RELATIVE)
                        val2 = getMemoryValue(relativeBase + parm2);
                    else
                        exit(12);

                    result = val1 + val2;

                    if (mode3 == POSITION || mode3 == IMMEDIATE)
                        memory.put(parm3, result);
                    else if (mode3 == RELATIVE)
                        memory.put(relativeBase + parm3, result);
                    else
                        exit(13);

                    i += 4;

                    break;
                case 2: // multiply
                    //System.out.println("Multiply");
                    parm1 = getMemoryValue(i + 1);
                    parm2 = getMemoryValue(i + 2);
                    parm3 = getMemoryValue(i + 3);

                    if (mode1 == POSITION)
                        val1 = getMemoryValue(parm1);
                    else if (mode1 == IMMEDIATE)
                        val1 = parm1;
                    else if (mode1 == RELATIVE)
                        val1 = getMemoryValue(relativeBase + parm1);
                    else
                        exit(21);

                    if (mode2 == POSITION)
                        val2 = getMemoryValue(parm2);
                    else if (mode2 == IMMEDIATE)
                        val2 = parm2;
                    else if (mode2 == RELATIVE)
                        val2 = getMemoryValue(relativeBase + parm2);
                    else
                        exit(22);

                    result = val1 * val2;

                    if (mode3 == POSITION || mode3 == IMMEDIATE)
                        memory.put(parm3, result);
                    else if (mode3 == RELATIVE)
                        memory.put(relativeBase + parm3, result);
                    else
                        exit(23);

                    i += 4;

                    break;
                case 3: // store
                    //System.out.println(computerId + ": input loop: " + ++loopNum);
                    parm1 = getMemoryValue(i + 1);
                    while (inputQueue.size() == 0) {
                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException ex) {
                            System.err.println("IC-2 - sleep error");
                        }
                    }

                    long inputValue = inputQueue.get(0);
                    inputQueue.remove(0);

                    if (mode1 == POSITION || mode1 == IMMEDIATE) {
                        memory.put(parm1, inputValue);
                    }
                    else if (mode1 == RELATIVE)
                        memory.put(relativeBase + parm1, inputValue);
                    else
                        exit(31);
                    i += 2;
                    break;
                case 4: // return
                    parm1 = getMemoryValue(i+1);

                    if (mode1 == POSITION)
                        val1 = getMemoryValue(parm1);
                    else if (mode1 == IMMEDIATE)
                        val1 = parm1;
                    else if(mode1 == RELATIVE)
                        val1 = getMemoryValue(relativeBase+parm1);
                    else
                        exit(41);

                    outputQueue.add(val1);
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException ex) {
                        System.out.println(computerId + " sleep exception");
                    }
                    //System.out.println(computerId + ": output - " + val1);

                    i+=2;
                    break;
                case 5: //jump-if-true
                    parm1 = getMemoryValue(i+1);
                    parm2 = getMemoryValue(i+2);

                    if (mode1 == POSITION)
                        val1 = getMemoryValue(parm1);
                    else if (mode1 == IMMEDIATE)
                        val1 = parm1;
                    else if(mode1 == RELATIVE)
                        val1 = getMemoryValue(relativeBase+parm1);
                    else
                        exit(51);

                    if (mode2 == POSITION)
                        val2 = getMemoryValue(parm2);
                    else if (mode2 == IMMEDIATE)
                        val2 = parm2;
                    else if(mode2 == RELATIVE)
                        val2 = getMemoryValue(relativeBase+parm2);
                    else
                        exit(52);

                    if (val1 != 0)
                        i = val2;
                    else
                        i += 3;

                    break;
                case 6: //jump-if-false
                    parm1 = getMemoryValue(i+1);
                    parm2 = getMemoryValue(i+2);

                    if (mode1 == POSITION)
                        val1 = getMemoryValue(parm1);
                    else if (mode1 == IMMEDIATE)
                        val1 = parm1;
                    else if(mode1 == RELATIVE)
                        val1 = getMemoryValue(relativeBase+parm1);
                    else
                        exit(61);

                    if (mode2 == POSITION)
                        val2 = getMemoryValue(parm2);
                    else if (mode2 == IMMEDIATE)
                        val2 = parm2;
                    else if(mode2 == RELATIVE)
                        val2 = getMemoryValue(relativeBase+parm2);
                    else
                        exit(62);

                    if (val1 == 0)
                        i = val2;
                    else
                        i += 3;

                    break;
                case 7: // less than
                    parm1 = getMemoryValue(i+1);
                    parm2 = getMemoryValue(i+2);
                    parm3 = getMemoryValue(i+3);

                    if (mode1 == POSITION)
                        val1 = getMemoryValue(parm1);
                    else if (mode1 == IMMEDIATE)
                        val1 = parm1;
                    else if(mode1 == RELATIVE)
                        val1 = getMemoryValue(relativeBase+parm1);
                    else
                        exit(71);

                    if (mode2 == POSITION)
                        val2 = getMemoryValue(parm2);
                    else if (mode2 == IMMEDIATE)
                        val2 = parm2;
                    else if(mode2 == RELATIVE)
                        val2 = getMemoryValue(relativeBase+parm2);
                    else
                        exit(72);

                    if (val1 < val2)
                        result = 1l;
                    else
                        result = 0;

                    if (mode3 == POSITION || mode3 == IMMEDIATE)
                        /*memory.put(getMemoryValue(parm3), result);
                    else if (mode3 == IMMEDIATE)*/
                        memory.put(parm3, result);
                    else if (mode3 == RELATIVE)
                        memory.put(relativeBase + parm3, result);
                    else
                        exit(73);

                    i += 4;

                    break;
                case 8: // equals
                    parm1 = getMemoryValue(i+1);
                    parm2 = getMemoryValue(i+2);
                    parm3 = getMemoryValue(i+3);

                    if (mode1 == POSITION)
                        val1 = getMemoryValue(parm1);
                    else if (mode1 == IMMEDIATE)
                        val1 = parm1;
                    else if(mode1 == RELATIVE)
                        val1 = getMemoryValue(relativeBase+parm1);
                    else
                        exit(81);

                    if (mode2 == POSITION)
                        val2 = getMemoryValue(parm2);
                    else if (mode2 == IMMEDIATE)
                        val2 = parm2;
                    else if(mode2 == RELATIVE)
                        val2 = getMemoryValue(relativeBase+parm2);
                    else
                        exit(82);

                    if (val1 == val2)
                        result = 1l;
                    else
                        result = 0;

                    if (mode3 == POSITION || mode3 == IMMEDIATE)
                        /*memory.put(getMemoryValue(parm3), result);
                    else if (mode3 == IMMEDIATE)*/
                        memory.put(parm3, result);
                    else if (mode3 == RELATIVE)
                        memory.put(relativeBase + parm3, result);
                    else
                        exit(83);

                    i += 4;
                    break;
                case 9: // change relative base
                    parm1 = getMemoryValue(i+1);

                    if (mode1 == POSITION)
                        val1 = getMemoryValue(parm1);
                    else if (mode1 == IMMEDIATE)
                        val1 = parm1;
                    else if(mode1 == RELATIVE)
                        val1 = getMemoryValue(relativeBase+parm1);
                    else
                        exit(91);

                    relativeBase += val1;
                    i += 2;
                    break;
                case 99: // end
                    //System.out.println(computerId + ": End");
                    bDone = true;
                    break;
            }
        }
    }
}
