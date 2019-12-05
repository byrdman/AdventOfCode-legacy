package net.thebyrdnest.aoc.aoc2015;

import java.util.HashMap;
import java.util.Map;

public class Day07 {
    private class Gate {
        private String input_1;
        private String input_2;
        private String componentType;

        public Gate() {}

        public Gate(String type, String in1, String in2) {
            componentType = type;
            input_1 = in1;
            input_2 = in2;
        }

        public Gate(String type, String in1) {
            this(type, in1, null);
        }

        public void setComponentType(String type) {
            componentType = type;
        }

        public void setInput1(String gate) {
            input_1 = gate;
        }

        public void setInput2(String gate) {
            input_2 = gate;
        }

        public short getOutput() {
            Gate a = circuit.get(input_1);
            if (a == null && input_1 != null && !input_1.isBlank())
                a = new Gate("signal", input_1);
            Gate b = circuit.get(input_2);
            if (b == null && input_2 != null && !input_2.isBlank())
                b = new Gate("signal", input_2);

            if (componentType.equalsIgnoreCase("and"))
                return (short)(a.getOutput() & b.getOutput());
            else if (componentType.equalsIgnoreCase("or"))
                return (short)(a.getOutput() | b.getOutput());
            else if (componentType.equalsIgnoreCase("lshift"))
                return (short)(a.getOutput() << b.getOutput());
            else if (componentType.equalsIgnoreCase("rshift"))
                return (short)(a.getOutput() >> b.getOutput());
            else if (componentType.equalsIgnoreCase("not"))
                return (short)(~a.getOutput());
            else if (componentType.equalsIgnoreCase("signal")) {
                try {
                    return (short) (Short.parseShort(input_1));
                } catch (Exception ex) {
                    Gate c = circuit.get(input_1);
                    return a.getOutput();
                }
            }
            else
                return 0;
        }
    }

    Map<String, Gate> circuit = new HashMap<>();

    public void processInstruction(String instruction) {
        String[] parts = instruction.split(" ");

        if (parts.length == 3)  //# -> a
            circuit.put(parts[2], new Gate("signal", parts[0]));
        else if (parts.length == 4) // NOT a -> b
            circuit.put(parts[3], new Gate("not", parts[1]));
        else if (parts.length == 5) // a <oper> b -> c
            circuit.put(parts[4], new Gate(parts[1], parts[0], parts[2]));
    }

    public void processInstructions(String[] instructions) {
        for (String instruction : instructions)
            processInstruction(instruction);
    }

    public short getCircuitValue(String wire) {
        Gate g = circuit.get(wire);
        return g.getOutput();
    }

    public short solve1(String input) {
        String[] instructions = input.split("\n");
        processInstructions(instructions);

        return getCircuitValue("a");
    }

    public short solve2(String input) {
        String[] instructions = input.split("\n");
        processInstructions(instructions);

        return getCircuitValue("a");
    }
}
