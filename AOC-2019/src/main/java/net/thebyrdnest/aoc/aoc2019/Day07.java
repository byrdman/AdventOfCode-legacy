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
        resetComputers();
    }

    public void resetComputers() {
        amps.clear();
        for (int i=0; i < 5; i++) {

            ArrayList<Long> inputQueue = new ArrayList<>();
            ArrayList<Long> outputQueue = new ArrayList<>();
            IntCodeComputer amp = new IntCodeComputer(i);//, initialProgram, inputQueue, outputQueue);
            amp.bootComputer(initialProgram);
            amps.add(amp);
        }
    }

    public void resetInputs() {
        for (int i=0; i < 6; i++) {
            ampInput[i] = 0;
        }
    }

    public long getAmpOutput(int ampId, long phase, long signal) {
        IntCodeComputer amp;

        try {
            amp = amps.get(ampId);
            amp.setInputValue(phase);
            amp.setInputValue(signal);

            while (!amp.isDone()) {
                Thread.sleep(1);
            }
        } catch (Exception ex) {
                // do nothing;
            int i=0;
        }

        amp = amps.get(ampId);
        while (!amp.isOutputReady()) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                System.err.println("07-1 sleep error");
            }
        }

        return amp.getOutputValue();
    }

    public long getThrusterInput(long[] phases) {
        IntCodeComputer amp;

        //set phase on all amps
        for (int i=0; i < 5; i++) {
            amp = amps.get(i);
            amp.setInputValue(phases[i]);
        }
        
        // give input to 1st amp
        amp = amps.get(0);
        amp.setInputValue(0L);
        long outputFromE = 0l;
        
        // loop until amp e finishes
        IntCodeComputer amp_a = amps.get(AMP_A);
        IntCodeComputer amp_b = amps.get(AMP_B);
        IntCodeComputer amp_c = amps.get(AMP_C);
        IntCodeComputer amp_d = amps.get(AMP_D);
        IntCodeComputer amp_e = amps.get(AMP_E);

        while (!amps.get(AMP_E).isDone()) {
            while (!amp_a.isOutputReady()) {
                // do nothing
            }
            amp_b.setInputValue(amp_a.getOutputValue());

            while (!amp_b.isOutputReady()) {
                // do nothing
            }
            amp_c.setInputValue(amp_b.getOutputValue());

            while (!amp_c.isOutputReady()) {
                // do nothing
            }
            amp_d.setInputValue(amp_c.getOutputValue());

            while (!amp_d.isOutputReady()) {
                // do nothing
            }
            amp_e.setInputValue(amp_d.getOutputValue());

            while (!amp_e.isOutputReady()) {
                // do nothing
            }

            outputFromE = amp_e.getOutputValue();
            amp_a.setInputValue(outputFromE);
        }

        return outputFromE;
    }

    public long findMaxThrusterSignal(boolean feedback) {
        long iMaxThrustSignal = 0;

        for (long a = 0; a < 5; a++) {
            for (long b = 0; b < 5; b++) {
                if (b != a) {
                    for (long c = 0; c < 5; c++) {
                        if (c != a &&
                            c != b) {
                            for (long d = 0; d < 5; d++) {
                                if (d != c &&
                                    d != b &&
                                    d != a) {
                                    for (long e = 0; e < 5; e++) {
                                        if (e != d &&
                                            e != c &&
                                            e != b &&
                                            e != a) {
                                            long[] phases = {a,b,c,d,e};
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
