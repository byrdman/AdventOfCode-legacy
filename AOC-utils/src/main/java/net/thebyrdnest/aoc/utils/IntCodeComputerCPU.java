package net.thebyrdnest.aoc.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static java.lang.System.exit;

public class IntCodeComputerCPU extends Thread {
    String computerId;
    private HashMap<Long, Long> ram;
    private long relativeBase = 0;
    ArrayList<Long> inputQueue;
    ArrayList<Long> outputQueue;
    private boolean bDone = false;

    static final int POSITION = 0;
    static final int IMMEDIATE = 1;
    static final int RELATIVE = 2;

    public IntCodeComputerCPU() {
        this("CPU-001", null, null, null);
    }

    public IntCodeComputerCPU(String computerId, HashMap<Long, Long> ram) {
        this(computerId, ram, new ArrayList<>(), new ArrayList<>());
    }

    public IntCodeComputerCPU(String computerId, HashMap<Long, Long> ram, ArrayList<Long> inputQueue, ArrayList<Long> outputQueue){
        this.computerId = computerId;
        this.ram = ram;
        this.inputQueue = inputQueue;
        this.outputQueue = outputQueue;
        resetMemory();
    }

    public void resetMemory() {

        relativeBase = 0;
        inputQueue.clear();
        outputQueue.clear();
        bDone = false;
    }

    public boolean isDone() {
        return bDone;
    }

    public long getMemoryValue(long index) {
        Long memVal = ram.get(index);
        if (memVal == null)
            return 0;
        else
            return memVal.longValue();
    }

    public void run() {
        System.out.println("Run Program - " + computerId);
        bDone = false;
        int opCode;
        int mode1;
        int mode2;
        int mode3;
        long parm1;
        long parm2;
        long parm3;
        long val1 = 0;
        long val2 = 0;
        long result;

        long iMemPointer=0;
        while (!bDone) {
            StringBuilder sb = new StringBuilder(Long.toString(ram.get(iMemPointer)));
            while (sb.length() < 5)
                sb.insert(0, '0');

            mode3 = Integer.parseInt(sb.substring(0, 1));
            mode2 = Integer.parseInt(sb.substring(1, 2));
            mode1 = Integer.parseInt(sb.substring(2, 3));
            opCode = Integer.parseInt(sb.substring(3, 5));

            switch(opCode) {
                case 1: // add
                    //System.out.println("Add");
                    parm1 = ram.get(iMemPointer + 1);
                    parm2 = ram.get(iMemPointer + 2);
                    parm3 = ram.get(iMemPointer + 3);

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
                        ram.put(parm3, result);
                    else if (mode3 == RELATIVE)
                        ram.put(relativeBase + parm3, result);
                    else
                        exit(13);

                    iMemPointer += 4;

                    break;
                case 2: // multiply
                    //System.out.println("Multiply");
                    parm1 = getMemoryValue(iMemPointer + 1);
                    parm2 = getMemoryValue(iMemPointer + 2);
                    parm3 = getMemoryValue(iMemPointer + 3);

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
                        ram.put(parm3, result);
                    else if (mode3 == RELATIVE)
                        ram.put(relativeBase + parm3, result);
                    else
                        exit(23);

                    iMemPointer += 4;

                    break;
                case 3: // store
                    parm1 = getMemoryValue(iMemPointer + 1);
                    while (inputQueue.size() == 0) {
                        try {
                            //System.out.println(computerId + ": waiting on input");
                            Thread.sleep(100);
                        } catch (InterruptedException ex) {
                            System.err.println("IC-2 - sleep error");
                        }
                    }

                    long inputValue = inputQueue.get(0);
                    inputQueue.remove(0);

                    if (mode1 == POSITION || mode1 == IMMEDIATE) {
                        ram.put(parm1, inputValue);
                    }
                    else if (mode1 == RELATIVE)
                        ram.put(relativeBase + parm1, inputValue);
                    else
                        exit(31);
                    iMemPointer += 2;
                    break;
                case 4: // return
                    parm1 = getMemoryValue(iMemPointer+1);
                    Long val = 0L;

                    if (mode1 == POSITION)
                        val = getMemoryValue(parm1);
                    else if (mode1 == IMMEDIATE)
                        val = parm1;
                    else if(mode1 == RELATIVE)
                        val = getMemoryValue(relativeBase+parm1);
                    else
                        exit(41);

                    outputQueue.add(val);
                    //outputCount++;
                    //System.out.println(val);

                    iMemPointer+=2;
                    break;
                case 5: //jump-if-true
                    parm1 = getMemoryValue(iMemPointer+1);
                    parm2 = getMemoryValue(iMemPointer+2);

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
                        iMemPointer = val2;
                    else
                        iMemPointer += 3;

                    break;
                case 6: //jump-if-false
                    parm1 = getMemoryValue(iMemPointer+1);
                    parm2 = getMemoryValue(iMemPointer+2);

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
                        iMemPointer = val2;
                    else
                        iMemPointer += 3;

                    break;
                case 7: // less than
                    parm1 = getMemoryValue(iMemPointer+1);
                    parm2 = getMemoryValue(iMemPointer+2);
                    parm3 = getMemoryValue(iMemPointer+3);

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
                        ram.put(parm3, result);
                    else if (mode3 == RELATIVE)
                        ram.put(relativeBase + parm3, result);
                    else
                        exit(73);

                    iMemPointer += 4;

                    break;
                case 8: // equals
                    parm1 = getMemoryValue(iMemPointer+1);
                    parm2 = getMemoryValue(iMemPointer+2);
                    parm3 = getMemoryValue(iMemPointer+3);

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
                        ram.put(parm3, result);
                    else if (mode3 == RELATIVE)
                        ram.put(relativeBase + parm3, result);
                    else
                        exit(83);

                    iMemPointer += 4;
                    break;
                case 9: // change relative base
                    parm1 = getMemoryValue(iMemPointer+1);

                    if (mode1 == POSITION)
                        val1 = getMemoryValue(parm1);
                    else if (mode1 == IMMEDIATE)
                        val1 = parm1;
                    else if(mode1 == RELATIVE)
                        val1 = getMemoryValue(relativeBase+parm1);
                    else
                        exit(91);

                    relativeBase += val1;
                    iMemPointer += 2;
                    break;
                case 99: // end
                    //System.out.println(computerId + ": End");
                    bDone = true;
                    break;
            }
        }
    }
}
