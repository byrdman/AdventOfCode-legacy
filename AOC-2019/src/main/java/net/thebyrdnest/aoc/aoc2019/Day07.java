package net.thebyrdnest.aoc.aoc2019;

import net.thebyrdnest.aoc.utils.IntCodeComputer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day07 {
    List<IntCodeComputer> amps = new ArrayList<>();

    public String maxPhase = "";
    private long[] initialProgram = {};
    
    private static int AMP_A = 0;
    private static int AMP_B = 1;
    private static int AMP_C = 2;
    private static int AMP_D = 3;
    private static int AMP_E = 4;

    long[] ampInput = {0,0,0,0,0,0};

    public Day07(long[] program) {
        initialProgram = Arrays.copyOf(program, program.length);
        for (int i=0; i < 5; i++) {
            IntCodeComputer amp = new IntCodeComputer(i, program);
            amps.add(amp);
            amp.start();
        }
    }

    public void resetComputers() {
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

    public long getAmpOutput(int ampId, int phase, long signal) {
        long inputs[] = {phase, signal};
        try {
            IntCodeComputer amp = amps.get(ampId);
            amp.start();

            while(amp.isInputReady()) {
                try {
                    wait(1);
                } catch (Exception e) {

                }
            }

            amp.setInput(phase);
            amp.setInputReady(true);

            while(amp.isInputReady()) {
                try {
                    wait(1);
                } catch (Exception e) {

                }
            }

            amp.setInput(signal);
            amp.setInputReady(true);

            while (!amp.isDone()) {
                wait(1);
            }


        } catch (Exception ex) {
                // do nothing;
        }

        while (!amps.get(ampId).isOutputReady()) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                //
            }
        }

        return amps.get(ampId).getOutputValue();
    }

    public long getThrusterInput(int[] phases) {
        IntCodeComputer amp = amps.get(0);

        //set phase on all amps
        for (int i=0; i < 5; i++) {
            amp = amps.get(i);
            amp.setInput(phases[i]);
            amp.setInputReady(true);
            while(amp.isInputReady()) {
                try {
                    wait(1);
                } catch (Exception e) {

                }
            }
        }
        
        // give input to 1st amp
        amp = amps.get(AMP_A);
        while(amp.isInputReady()) {
            try {
                wait(1);
            } catch (Exception e) {

            }
        }
        amp.setInput(0);
        amp.setInputReady(true);
        long outputFromE = 0l;
        
        // loop until amp e finishes
        while (!amps.get(AMP_E).isDone()) {
            if (amps.get(AMP_A).isOutputReady() && !amps.get(AMP_B).isInputReady()) {
                amps.get(AMP_B).setInput(amps.get(AMP_A).getOutputValue());
                amps.get(AMP_A).setOutputReady(false);
                amps.get(AMP_B).setInputReady(true);
            }

            if (amps.get(AMP_B).isOutputReady() && !amps.get(AMP_C).isInputReady()) {
                amps.get(AMP_C).setInput(amps.get(AMP_B).getOutputValue());
                amps.get(AMP_B).setOutputReady(false);
                amps.get(AMP_C).setInputReady(true);
            }

            if (amps.get(AMP_C).isOutputReady() && !amps.get(AMP_D).isInputReady()) {
                amps.get(AMP_D).setInput(amps.get(AMP_C).getOutputValue());
                amps.get(AMP_C).setOutputReady(false);
                amps.get(AMP_D).setInputReady(true);
            }

            if (amps.get(AMP_D).isOutputReady() && !amps.get(AMP_E).isInputReady()) {
                amps.get(AMP_E).setInput(amps.get(AMP_D).getOutputValue());
                amps.get(AMP_D).setOutputReady(false);
                amps.get(AMP_E).setInputReady(true);
            }

            if (amps.get(AMP_E).isOutputReady() && !amps.get(AMP_A).isInputReady()) {
                amps.get(AMP_A).setInput(amps.get(AMP_E).getOutputValue());
                outputFromE = amps.get(AMP_E).getOutputValue();
                amps.get(AMP_E).setOutputReady(false);
                amps.get(AMP_A).setInputReady(true);
            }

            try {
                wait(1);
            } catch (Exception e) {

            }
        }

        return outputFromE;
    }

    public long findMaxThrusterSignal(boolean feedback) {
        long iMaxThrustSignal = 0;

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
                                            long signal = 0;

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
                                                signal = getThrusterInput(phases);
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
