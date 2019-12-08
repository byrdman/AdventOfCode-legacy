package net.thebyrdnest.aoc.aoc2015;

import java.util.ArrayList;

public class Day12 {
    public int sumNumbers(String[] input) {
        int sum = 0;
        for (String line : input) {
            sum += findNumber(line);
        }

        return sum;
    }

    public int findNumber(String line) {
        char[] cLine = line.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : cLine) {
            if (c == '-')
                sb.append('-');

            if (c >= '0' && c <= '9')
                sb.append(c);
        }

        if (sb.length() != 0) {
            int number = Integer.parseInt(sb.toString());
            if (number != 0)
                System.out.println(number + " ] " + line);
            return number;
        } else {
            return 0;
        }
    }
}
