package net.thebyrdnest.aoc.utils;

import java.util.Arrays;

public class IntCodeComputer {
    private int[] memory = {};

    static final int POSITION = 0;
    static final int IMMEDIATE = 1;


    public void initMemory(int[] values) {
        // gotta do a deep copy
        memory = Arrays.copyOf(values, values.length);
    }

    public int program(int noun, int verb) {
        boolean bDone = false;
        int parm1 = 0;
        int parm2 = 0;
        int parm3 = 0;
        int val1 = 0;
        int val2 = 0;
        int result = 0;

        memory[1] = noun;
        memory[2] = verb;

        for (int i = 0; i < memory.length && !bDone; i+=4) {
            String instruction = Integer.toString(memory[i]);
            int opCode = 0;
            int mode1;
            int mode2;
            int mode3;
            StringBuilder sb = new StringBuilder(memory[i]);
            while (sb.length() < 5)
                sb.insert(0, '0');

            mode3 = Integer.parseInt(sb.substring(0, 1));
            mode2 = Integer.parseInt(sb.substring(1, 2));
            mode1 = Integer.parseInt(sb.substring(2, 3));
            opCode = Integer.parseInt(sb.substring(3, 5));

            /*System.out.println("i: " + i);
            System.out.println("opCode: " + opCode);*/

            if (opCode != 99) {
                parm1 = memory[i+1];
                parm2 = memory[i+2];
                parm3 = memory[i+3];

                if (mode1 == POSITION)
                    val1 = memory[parm1];
                else
                    val1 = parm1;

                if (mode1 == POSITION)
                    val2 = memory[parm2];
                else
                    val2 = parm1;

                /*System.out.println("parm1: " + parm1 + ", val1: " + val1);
                System.out.println("parm2: " + parm2 + ", val2: " + val2);*/
            }

            switch(opCode) {
                case 1: // add
                    //System.out.println("Add");
                    result = val1 + val2;

                    memory[parm3] = result;

                    break;
                case 2: // multiply
                    //System.out.println("Multiply");
                    result = val1 * val2;

                    memory[parm3] = result;

                    break;
                case 3: // store

                    break;
                case 4: // return
                    break;
                case 99: // end
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
