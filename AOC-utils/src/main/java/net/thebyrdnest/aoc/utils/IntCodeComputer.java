package net.thebyrdnest.aoc.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class IntCodeComputer {
    private int[] memory = {};

    static final int POSITION = 0;
    static final int IMMEDIATE = 1;


    public void initMemory(int[] values) {
        // gotta do a deep copy
        memory = Arrays.copyOf(values, values.length);
    }

    public int runProgram() {
        return runProgram(0, false);
    }

    public int runProgram(int inputValue, boolean diagnostic) {
        boolean bDone = false;
        int diagnosticValue = 0;
        int parm1 = 0;
        int parm2 = 0;
        int parm3 = 0;
        int val1 = 0;
        int val2 = 0;
        int result = 0;

        int i=0;
        while (!bDone) {
        //for (int i = 0; i < memory.length && !bDone; i+=4) {
            int opCode = 0;
            int mode1;
            int mode2;
            int mode3;
            StringBuilder sb = new StringBuilder(Integer.toString(memory[i]));
            while (sb.length() < 5)
                sb.insert(0, '0');

            mode3 = Integer.parseInt(sb.substring(0, 1));
            mode2 = Integer.parseInt(sb.substring(1, 2));
            mode1 = Integer.parseInt(sb.substring(2, 3));
            opCode = Integer.parseInt(sb.substring(3, 5));

            switch(opCode) {
                case 1: // add
                    //System.out.println("Add");
                    parm1 = memory[i+1];
                    parm2 = memory[i+2];
                    parm3 = memory[i+3];

                    if (mode1 == POSITION)
                        val1 = memory[parm1];
                    else
                        val1 = parm1;

                    if (mode2 == POSITION)
                        val2 = memory[parm2];
                    else
                        val2 = parm2;

                    result = val1 + val2;

                    memory[parm3] = result;

                    i+=4;

                    break;
                case 2: // multiply
                    //System.out.println("Multiply");
                    parm1 = memory[i+1];
                    parm2 = memory[i+2];
                    parm3 = memory[i+3];

                    if (mode1 == POSITION)
                        val1 = memory[parm1];
                    else
                        val1 = parm1;

                    if (mode2 == POSITION)
                        val2 = memory[parm2];
                    else
                        val2 = parm2;

                    result = val1 * val2;

                    memory[parm3] = result;

                    i += 4;

                    break;
                case 3: // store
                    parm1 = memory[i+1];

                    System.out.print("System ID: ");
                    String sInput = "1";

                    //Enter data using BufferReader
                    /*BufferedReader reader =
                            new BufferedReader(new InputStreamReader(System.in));

                    // Reading data using readLine
                    try {
                        sInput = reader.readLine();*/
                        memory[parm1] = inputValue; //Integer.parseInt(sInput);
                    /*}
                     catch (IOException ex) {
                        sInput = "";
                         memory[parm1] = 0;
                    }*/

                    i += 2;
                    break;
                case 4: // return
                    parm1 = memory[i+1];

                    if (mode1 == POSITION)
                        val1 = memory[parm1];
                    else
                        val1 = parm1;

                    System.out.println(val1);
                    diagnosticValue = val1;
                    i+=2;
                    break;
                case 5: //jump-if-true
                    parm1 = memory[i+1];
                    parm2 = memory[i+2];

                    if (mode1 == POSITION)
                        val1 = memory[parm1];
                    else
                        val1 = parm1;

                    if (mode2 == POSITION)
                        val2 = memory[parm2];
                    else
                        val2 = parm2;

                    if (val1 != 0)
                        i = val2;
                    else
                        i += 3;

                    break;
                case 6: //jump-if-false
                    parm1 = memory[i+1];
                    parm2 = memory[i+2];

                    if (mode1 == POSITION)
                        val1 = memory[parm1];
                    else
                        val1 = parm1;

                    if (mode2 == POSITION)
                        val2 = memory[parm2];
                    else
                        val2 = parm2;

                    if (val1 == 0)
                        i = val2;
                    else
                        i += 3;

                    break;
                case 7: // less than
                    parm1 = memory[i+1];
                    parm2 = memory[i+2];
                    parm3 = memory[i+3];

                    if (mode1 == POSITION)
                        val1 = memory[parm1];
                    else
                        val1 = parm1;

                    if (mode2 == POSITION)
                        val2 = memory[parm2];
                    else
                        val2 = parm2;

                    if (val1 < val2)
                        memory[parm3] = 1;
                    else
                        memory[parm3] = 0;

                    i += 4;

                    break;
                case 8: // equals
                    parm1 = memory[i+1];
                    parm2 = memory[i+2];
                    parm3 = memory[i+3];

                    if (mode1 == POSITION)
                        val1 = memory[parm1];
                    else
                        val1 = parm1;

                    if (mode2 == POSITION)
                        val2 = memory[parm2];
                    else
                        val2 = parm2;

                    if (val1 == val2)
                        memory[parm3] = 1;
                    else
                        memory[parm3] = 0;

                    i += 4;

                    break;
                case 99: // end
                    //System.out.println("End");
                    bDone = true;
                    break;
            }


            /*System.out.println("pos3: " + pos3 + ", result: " + result);
            System.out.println("");*/
        }

        if (diagnostic)
            return diagnosticValue;
        else
            return memory[0];
    }
}
