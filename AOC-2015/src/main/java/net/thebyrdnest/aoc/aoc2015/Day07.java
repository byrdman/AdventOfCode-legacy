package net.thebyrdnest.aoc.aoc2015;

import java.util.HashMap;
import java.util.Map;

public class Day07 {
    private class Gate {
        private String storage;
        private String input_1;
        private String input_2;
        private String componentType;
        private boolean bResolved;
        private char answer;

        public Gate() {}

        public Gate(String type, String storage, String in1, String in2) {
            componentType = type;
            input_1 = in1;
            input_2 = in2;
            this.storage = storage;
            bResolved = false;
            answer = 0;
        }
        private long count = 0l;

        public Gate(String type, String storage, String in1) {
            this(type, storage, in1, null);
        }

        public char getOutput() {
            if (bResolved == false) {
                Gate a = circuit.get(input_1);
                if (a == null && input_1 != null && !input_1.isBlank())
                    a = new Gate("signal", null, input_1);
                Gate b = circuit.get(input_2);
                if (b == null && input_2 != null && !input_2.isBlank())
                    b = new Gate("signal", null, input_2);

                if (componentType.equalsIgnoreCase("and")) {
                    answer = (char) (a.getOutput() & b.getOutput());
                    bResolved = true;
                } else if (componentType.equalsIgnoreCase("or")) {
                    answer = (char) (a.getOutput() | b.getOutput());
                    bResolved = true;
                } else if (componentType.equalsIgnoreCase("lshift")) {
                    answer = (char) (a.getOutput() << b.getOutput());
                    bResolved = true;
                } else if (componentType.equalsIgnoreCase("rshift")) {
                    answer = (char) (a.getOutput() >> b.getOutput());
                    bResolved = true;
                } else if (componentType.equalsIgnoreCase("not")) {
                    answer = (char) (~a.getOutput());
                    bResolved = true;
                } else if (componentType.equalsIgnoreCase("signal")) {
                    try {
                        //answer = (char) (Short.parseShort(input_1));
                        answer = (char) (Integer.parseUnsignedInt(input_1));
                    } catch (Exception ex) {
                        Gate c = circuit.get(input_1);
                        try {
                            answer = c.getOutput();
                        } catch(Exception ex2) {
                            answer = 0;
                        }
                    }
                } else {
                    return 0;
                }
            }
            return answer;
        }
    }

    Map<String, Gate> circuit = new HashMap<>();

    public void processInstruction(String instruction) {
        String[] parts = instruction.split(" ");

        if (parts.length == 3)  //# -> a
            circuit.put(parts[2], new Gate("signal", parts[2], parts[0]));
        else if (parts.length == 4) // NOT a -> b
            circuit.put(parts[3], new Gate("not", parts[3], parts[1]));
        else if (parts.length == 5) // a <oper> b -> c
            circuit.put(parts[4], new Gate(parts[1], parts[4], parts[0], parts[2]));
    }

    public void processInstructions(String[] instructions) {
        for (String instruction : instructions)
            processInstruction(instruction);
    }

    public void processInstructions2(String[] instructions, String wire, String value) {
        for (String instruction : instructions) {
            if (instruction.endsWith("-> " + wire))
                instruction = value + " -> " + wire;
            processInstruction(instruction);
        }
    }

    public char getCircuitValue(String wire) {
        Gate g = circuit.get(wire);
        return g.getOutput();
    }

    public char loadCircuit(String input) {
        String[] instructions = input.split("\n");
        processInstructions(instructions);

        return getCircuitValue("a");
    }

    public char loadCircuit2(String input, String wire, String value) {
        String[] instructions = input.split("\n");
        processInstructions2(instructions, wire, value);

        return getCircuitValue("a");
    }

    public void overrideInput(String wire, String value) {
        circuit.put(wire, new Gate("signal", wire, value));
    }
}
