package net.thebyrdnest.aoc.aoc2019;

import net.thebyrdnest.aoc.utils.IntCodeComputer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day07 {
    List<IntCodeComputer> amps = new ArrayList<>();

    public String maxPhase = "";
    private int[] initialProgram = {};
    
    private static int AMP_A = 0;
    private static int AMP_B = 1;
    private static int AMP_C = 2;
    private static int AMP_D = 3;
    private static int AMP_E = 4;

    int[] ampInput = {0,0,0,0,0,0};


    public Day07(int[] program) {
        initialProgram = Arrays.copyOf(program, program.length);
        for (int i=0; i < 5; i++) {
            IntCodeComputer amp = new IntCodeComputer(i, program);
            amps.add(amp);
            amp.start();
        }
    }

    public void resetComputers() {
        /*for (IntCodeComputer computer : amps) {
            computer.resetMemory();
            computer.run();
        }*/
        amps.clear();
        for (int i=0; i < 5; i++) {
            IntCodeComputer amp = new IntCodeComputer(i, initialProgram);
            amps.add(amp);
            amp.start();
        }
    }

    public void resetInputs() {
        for (int i=0; i < 6; i++) {
            ampInput[i] = 0;
        }
    }

    public int getAmpOutput(int ampId, int phase, int signal) {
        int inputs[] = {phase, signal};
        amps.get(ampId).setInput(0, phase);
        amps.get(ampId).setInput(1, signal);
        try {
            amps.get(ampId).run();

            while (!amps.get(ampId).isDone()) {
                    wait(500);
            }
        } catch (Exception ex) {
                // do nothing;
        }

        return amps.get(ampId).getOutputValue();
    }

    public int getThrusterInput(int[] phase) {
        int ampId=0;
        while (ampInput[5] == 0){
            ampInput[ampId+1] = getAmpOutput(ampId, phase[ampId], ampInput[ampId]);
            ampId = (ampId+1) % 5;
        }

        return ampInput[5];
    }

    public int getThrusterInput_feedbackloop(int[] phases) {
        IntCodeComputer amp = amps.get(0);

        //set phase on all amps
        for (int i=0; i < 5; i++) {
            amp = amps.get(i);
            amp.setInput(0, phases[i]);
        }
        
        // give input to 1st amp
        amp = amps.get(AMP_A);
        amp.setInput(1, 0);
        amp.setInputReady(true);
        
        // loop until amp e finishes
        while (!amps.get(AMP_E).isDone()) {
            if (amps.get(AMP_A).isOutputReady()) {
                amps.get(AMP_B).setInput(1, amps.get(AMP_A).getOutputValue());
                amps.get(AMP_B).setInputReady(true);
            }

            if (amps.get(AMP_B).isOutputReady()) {
                amps.get(AMP_C).setInput(1, amps.get(AMP_B).getOutputValue());
                amps.get(AMP_C).setInputReady(true);
            }

            if (amps.get(AMP_C).isOutputReady()) {
                amps.get(AMP_D).setInput(1, amps.get(AMP_C).getOutputValue());
                amps.get(AMP_D).setInputReady(true);
            }

            if (amps.get(AMP_D).isOutputReady()) {
                amps.get(AMP_E).setInput(1, amps.get(AMP_D).getOutputValue());
                amps.get(AMP_E).setInputReady(true);
            }

            if (amps.get(AMP_E).isOutputReady()) {
                amps.get(AMP_A).setInput(1, amps.get(AMP_E).getOutputValue());
                amps.get(AMP_A).setInputReady(true);
            }
        }

        //grab the output from AMP_E
        return amps.get(AMP_E).getOutputValue();
    }

    public int findMaxThrusterSignal(boolean feedback) {
        int iMaxThrustSignal = 0;

        for (int a = 0; a < 5; a++) {
            for (int b = 0; b < 5; b++) {
                if (b != a) {
                    for (int c = 0; c < 5; c++) {
                        if (c != a &&
                            c != b) {
                            for (int d = 0; d < 5; d++) {
                                if (d != c &&
                                    d != b &&
                                    d != a) {
                                    for (int e = 0; e < 5; e++) {
                                        if (e != d &&
                                            e != c &&
                                            e != b &&
                                            e != a) {
                                            int[] phases = {a,b,c,d,e};
                                            int signal = 0;

                                            if (feedback == true) {
                                                phases[0] += 5;
                                                phases[1] += 5;
                                                phases[2] += 5;
                                                phases[3] += 5;
                                                phases[4] += 5;
                                            }
                                            resetInputs();

                                            resetComputers();

                                            if (feedback)
                                                signal = getThrusterInput_feedbackloop(phases);
                                            else
                                                signal = getThrusterInput(phases);

                                            if (signal > iMaxThrustSignal) {
                                                maxPhase = "" + phases[0] + phases[1] + phases[2] + phases[3] + phases[4];
                                                iMaxThrustSignal = signal;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return iMaxThrustSignal;
    }
}
