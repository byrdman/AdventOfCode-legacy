package net.thebyrdnest.aoc.aoc2019;

public class Day04 {

    public boolean checkRules(String input, int maxRepeat) {
        if (input.length() != 6) {
            return false;
        }

        // check sequence of numbers
        char lastChar = ' ';

        int[] numCount = {0,0,0,0,0,0,0,0,0,0};
        for (char c : input.toCharArray()) {
            numCount[c-'0']++;
            if (c > lastChar)
                lastChar = c;
            else if (c < lastChar)
                return false;
        }

        boolean bRepeatCheck = false;
        for (int iCount : numCount) {
            if (iCount >= 2 && iCount <= maxRepeat)
                bRepeatCheck = true;
        }

        return bRepeatCheck;
    }

    public int solve(String input, int maxRepeats) {
        String[] parts = input.split("-");

        String start = parts[0];
        String end = parts[1];
        String current = start;

        int iStart = Integer.parseInt(start);
        int iEnd = Integer.parseInt(end);

        int iCount = 0;

        for (int iCurrent = iStart; iCurrent <= iEnd; iCurrent++) {
            if (checkRules(Integer.toString(iCurrent), maxRepeats)) {
                iCount++;
            }
        }

        return iCount;
    }
}
