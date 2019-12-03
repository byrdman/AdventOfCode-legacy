package net.thebyrdnest.aoc.aoc2019.day02;

import net.thebyrdnest.aoc.utils.IntCodeComputer;

public class Day02_Two {

    public static void main(String[] args) {
        System.out.println("Day Two - Puzzle 2");

        IntCodeComputer intCodeComputer = new IntCodeComputer();

        boolean bDone = false;
        for (int noun = 0; noun <= 99 && !bDone; noun++) {
            for (int verb = 0; verb <= 99 && !bDone; verb++) {
                try {
                    int[] values = {1,0,0,3,1,1,2,3,1,3,4,3,1,5,0,3,2,1,13,19,1,9,19,23,2,13,23,27,2,27,13,31,2,31,10,35,1,6,35,39,1,5,39,43,1,10,43,47,1,5,47,51,1,13,51,55,2,55,9,59,1,6,59,63,1,13,63,67,1,6,67,71,1,71,10,75,2,13,75,79,1,5,79,83,2,83,6,87,1,6,87,91,1,91,13,95,1,95,13,99,2,99,13,103,1,103,5,107,2,107,10,111,1,5,111,115,1,2,115,119,1,119,6,0,99,2,0,14,0};
                    intCodeComputer.initMemory(values);

                    long result = intCodeComputer.program(noun, verb);

                    System.out.println("noun: " + noun);
                    System.out.println("verb: " + verb);
                    System.out.println("  result: " + result);

                    if (result == 19690720) {
                        System.out.println("  answer: " + (100 * noun + verb));
                        bDone = true;
                        break;
                    }

                    System.out.println("");

                } catch (Exception e) {
                   // System.out.println("exception");
                }
            }
        }


        System.out.println("done");
    }
}
