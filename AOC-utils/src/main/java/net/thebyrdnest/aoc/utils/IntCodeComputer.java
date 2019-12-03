package net.thebyrdnest.aoc.utils;

import java.util.Arrays;

public class IntCodeComputer {
    private int[] memory = {};

    public void initMemory(int[] values) {
        // gotta do a deep copy
        memory = Arrays.copyOf(values, values.length);
    }

    public int program(int noun, int verb) {
        boolean bDone = false;
        int pos1 = 0;
        int pos2 = 0;
        int pos3 = 0;
        int val1 = 0;
        int val2 = 0;
        int result = 0;

        memory[1] = noun;
        memory[2] = verb;

        for (int i = 0; i < memory.length && !bDone; i+=4) {
            int opCode = memory[i];

            /*System.out.println("i: " + i);
            System.out.println("opCode: " + opCode);*/

            if (opCode != 99) {
                pos1 = memory[i+1];
                pos2 = memory[i+2];
                pos3 = memory[i+3];

                val1 = memory[pos1];
                val2 = memory[pos2];

                /*System.out.println("pos1: " + pos1 + ", val1: " + val1);
                System.out.println("pos2: " + pos2 + ", val2: " + val2);*/
            }

            switch(opCode) {
                case 1:
                    //System.out.println("Add");
                    result = val1 + val2;

                    memory[pos3] = result;

                    break;
                case 2:
                    //System.out.println("Multiply");
                    result = val1 * val2;

                    memory[pos3] = result;

                    break;
                case 99:
                    //System.out.println("End");
                    bDone = true;
                    break;
            }


            /*System.out.println("pos3: " + pos3 + ", result: " + result);
            System.out.println("");*/
        }

        return memory[0];
    }
}
