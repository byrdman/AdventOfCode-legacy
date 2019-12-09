package net.thebyrdnest.aoc.utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class IntCodeComputer implements Runnable {
    Thread computerThread;

    private int computerId;
    private HashMap<Long, Long> memory;
    private long relativeBase = 0;
    private long[] defaultMemory = {};
    private long inputValue = 0;
    int inputCounter = 0;
    private long outputValue = 0;
    private boolean bDone = false;
    private boolean bInputReady;
    private boolean bOutputReady;
    private boolean bInteractive;

    static final int POSITION = 0;
    static final int IMMEDIATE = 1;
    static final int RELATIVE = 2;

    public IntCodeComputer() {
        computerId = 0;
        memory = new HashMap<>();
    }

    public IntCodeComputer(int computerId, long[] program) {
        this(computerId, program, false);
    }

    public IntCodeComputer(int computerId, long[] program, boolean bInteractive) {
        this.computerId = computerId;
        memory = new HashMap<>();
        defaultMemory = Arrays.copyOf(program, program.length);
        resetMemory();
        bInputReady = false;
        bOutputReady = false;
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
        inputCounter = 0;
        bDone = false;
    }

    public boolean isDone() {
        return bDone;
    }

    public void setInputReady(boolean value) {
        bInputReady = value;
    }

    public boolean isInputReady() { return bInputReady;}

    public boolean isOutputReady() {
        return bOutputReady;
    }

    public void setInput(long value) {
        inputValue = value;
    }

    public long getOutputValue() {
        bOutputReady=false;
        return outputValue;
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
                    parm1 = memory.get(i+1);
                    parm2 = memory.get(i+2);
                    parm3 = memory.get(i+3);

                    if (mode1 == POSITION)
                        val1 = getMemoryValue(parm1);
                    else if(mode1 == RELATIVE)
                        val1 = getMemoryValue(relativeBase+parm1);
                    else
                        val1 = parm1;

                    if (mode2 == POSITION)
                        val2 = getMemoryValue(parm2);
                    else if(mode1 == RELATIVE)
                        val2 = getMemoryValue(relativeBase+parm2);
                    else
                        val2 = parm2;

                    result = val1 + val2;

                    if (mode3 == POSITION || mode3 == IMMEDIATE)
                        memory.put(parm3, result);
                    else if (mode3 == RELATIVE)
                        memory.put(relativeBase + parm3, result);

                    i+=4;

                    break;
                case 2: // multiply
                    //System.out.println("Multiply");
                    parm1 = getMemoryValue(i+1);
                    parm2 = getMemoryValue(i+2);
                    parm3 = getMemoryValue(i+3);

                    if (mode1 == POSITION)
                        val1 = getMemoryValue(parm1);
                    else if(mode1 == RELATIVE)
                        val1 = getMemoryValue(relativeBase+parm1);
                    else
                        val1 = parm1;

                    if (mode2 == POSITION)
                        val2 = getMemoryValue(parm2);
                    else if(mode1 == RELATIVE)
                        val2 = getMemoryValue(relativeBase+parm2);
                    else
                        val2 = parm2;

                    result = val1 * val2;

                    if (mode3 == POSITION || mode3 == IMMEDIATE)
                        memory.put(parm3, result);
                    else if (mode3 == RELATIVE)
                        memory.put(relativeBase + parm3, result);

                    i += 4;

                    break;
                case 3: // store
                    //System.out.println(computerId + ": input loop: " + ++loopNum);
                    parm1 = getMemoryValue(i+1);
                    if (bInteractive == true) {
                        System.out.print("Input: ");
                        Scanner in = new Scanner(System.in);
                        String s = in.nextLine();
                        memory.put(parm1, Long.parseLong(s));
                    } else {
                        while (!bInputReady) {
                            try {
                                Thread.sleep(1);
                            } catch (InterruptedException ex) {
                                System.out.println(computerId + " sleep exception");
                            }
                        }

                        if (mode1 == POSITION || mode1 == IMMEDIATE)
                            memory.put(parm1, inputValue);
                        else if (mode1 == RELATIVE)
                            memory.put(relativeBase + parm1, inputValue);

                        bInputReady = false;

                    }
                    //System.out.println(computerId + ": Input - " + memory[parm1]);
                    i += 2;
                    break;
                case 4: // return
                    parm1 = getMemoryValue(i+1);

                    if (mode1 == POSITION)
                        val1 = getMemoryValue(parm1);
                    else if(mode1 == RELATIVE)
                        val1 = getMemoryValue(relativeBase+parm1);
                    else
                        val1 = parm1;

                    outputValue = val1;
                    bOutputReady = true;
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException ex) {
                        System.out.println(computerId + " sleep exception");
                    }
                    System.out.println(computerId + ": output - " + outputValue);

                    i+=2;
                    break;
                case 5: //jump-if-true
                    parm1 = getMemoryValue(i+1);
                    parm2 = getMemoryValue(i+2);

                    if (mode1 == POSITION)
                        val1 = getMemoryValue(parm1);
                    else if(mode1 == RELATIVE)
                        val1 = getMemoryValue(relativeBase+parm1);
                    else
                        val1 = parm1;

                    if (mode2 == POSITION)
                        val2 = getMemoryValue(parm2);
                    else if(mode1 == RELATIVE)
                        val2 = getMemoryValue(relativeBase+parm2);
                    else
                        val2 = parm2;

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
                    else if(mode1 == RELATIVE)
                        val1 = getMemoryValue(relativeBase+parm1);
                    else
                        val1 = parm1;

                    if (mode2 == POSITION)
                        val2 = getMemoryValue(parm2);
                    else if(mode1 == RELATIVE)
                        val2 = getMemoryValue(relativeBase+parm2);
                    else
                        val2 = parm2;

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
                    else if(mode1 == RELATIVE)
                        val1 = getMemoryValue(relativeBase+parm1);
                    else
                        val1 = parm1;

                    if (mode2 == POSITION)
                        val2 = getMemoryValue(parm2);
                    else if(mode1 == RELATIVE)
                        val2 = getMemoryValue(relativeBase+parm2);
                    else
                        val2 = parm2;

                    if (mode3 == RELATIVE)
                        parm3 += relativeBase;

                    if (val1 < val2)
                        memory.put(parm3, 1l);
                    else
                        memory.put(parm3, 0l);

                    i += 4;

                    break;
                case 8: // equals
                    parm1 = getMemoryValue(i+1);
                    parm2 = getMemoryValue(i+2);
                    parm3 = getMemoryValue(i+3);

                    if (mode1 == POSITION)
                        val1 = getMemoryValue(parm1);
                    else if(mode1 == RELATIVE)
                        val1 = getMemoryValue(relativeBase+parm1);
                    else
                        val1 = parm1;

                    if (mode2 == POSITION)
                        val2 = getMemoryValue(parm2);
                    else if(mode1 == RELATIVE)
                        val2 = getMemoryValue(relativeBase+parm2);
                    else
                        val2 = parm2;

                    if (mode3 == RELATIVE)
                        parm3 += relativeBase;

                    if (val1 == val2)
                        memory.put(parm3, 1l);
                    else
                        memory.put(parm3, 0l);

                    i += 4;
                    break;
                case 9: // change relative base
                    parm1 = getMemoryValue(i+1);

                    if (mode1 == POSITION || mode1 == IMMEDIATE || mode1 == RELATIVE )
                        val1 = parm1;

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

    public static void main(String[] args) {
        long[] pgm1 = {3,26,1001,26,-4,26,3,27,1002,27,2,27,1,27,26,27,4,27,1001,28,-1,28,1005,28,6,99,0,0,5};
        long[] pgm = {3,8,1001,8,10,8,105,1,0,0,21,34,51,64,73,98,179,260,341,422,99999,3,9,102,4,9,9,1001,9,4,9,4,9,99,3,9,1001,9,4,9,1002,9,3,9,1001,9,5,9,4,9,99,3,9,101,5,9,9,102,5,9,9,4,9,99,3,9,101,5,9,9,4,9,99,3,9,1002,9,5,9,1001,9,3,9,102,2,9,9,101,5,9,9,1002,9,2,9,4,9,99,3,9,1001,9,1,9,4,9,3,9,1002,9,2,9,4,9,3,9,1001,9,2,9,4,9,3,9,1001,9,2,9,4,9,3,9,102,2,9,9,4,9,3,9,102,2,9,9,4,9,3,9,101,1,9,9,4,9,3,9,101,1,9,9,4,9,3,9,102,2,9,9,4,9,3,9,101,2,9,9,4,9,99,3,9,101,1,9,9,4,9,3,9,1001,9,1,9,4,9,3,9,102,2,9,9,4,9,3,9,102,2,9,9,4,9,3,9,101,2,9,9,4,9,3,9,101,1,9,9,4,9,3,9,101,1,9,9,4,9,3,9,1002,9,2,9,4,9,3,9,1002,9,2,9,4,9,3,9,1001,9,2,9,4,9,99,3,9,101,2,9,9,4,9,3,9,102,2,9,9,4,9,3,9,1001,9,2,9,4,9,3,9,1001,9,2,9,4,9,3,9,1001,9,2,9,4,9,3,9,101,2,9,9,4,9,3,9,1001,9,1,9,4,9,3,9,102,2,9,9,4,9,3,9,102,2,9,9,4,9,3,9,101,2,9,9,4,9,99,3,9,1002,9,2,9,4,9,3,9,102,2,9,9,4,9,3,9,1001,9,2,9,4,9,3,9,1002,9,2,9,4,9,3,9,1001,9,2,9,4,9,3,9,1002,9,2,9,4,9,3,9,102,2,9,9,4,9,3,9,102,2,9,9,4,9,3,9,101,2,9,9,4,9,3,9,1001,9,2,9,4,9,99,3,9,1001,9,1,9,4,9,3,9,101,1,9,9,4,9,3,9,1002,9,2,9,4,9,3,9,1001,9,2,9,4,9,3,9,1001,9,1,9,4,9,3,9,101,1,9,9,4,9,3,9,102,2,9,9,4,9,3,9,1001,9,2,9,4,9,3,9,1002,9,2,9,4,9,3,9,1001,9,2,9,4,9,99};
        IntCodeComputer cpu = new IntCodeComputer(Integer.parseInt(args[0]), pgm, true);
        cpu.run();
    }
}
