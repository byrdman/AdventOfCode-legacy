package net.thebyrdnest.aoc.aoc2015;

import java.util.ArrayList;

public class Day11 {
    public boolean isValid(char[] cInput) {
        if (!hasIncreasingStraight(cInput) ||
            hasInvalidCharacters(cInput) ||
            !hasNonOverlappingPairs(cInput)) {
            return false;
        } else {
            return true;
        }
    }

    public boolean hasIncreasingStraight(char[] cInput) {
        for (int i=0; i < cInput.length-2; i++) {
            if (cInput[i+2] - cInput[i+1] == 1 &&
                cInput[i+1] - cInput[i] == 1) {
                return true;
            }
        }
        return false;
    }

    public boolean hasInvalidCharacters(char[] cInput) {
        for (char currChar : cInput) {
            if (currChar == 'i' ||
                currChar == 'o' ||
                currChar == 'l') {
                return true;
            }
        }

        return false;
    }

    public boolean hasNonOverlappingPairs(char[] cInput) {
        ArrayList<String> doubles = new ArrayList<>();
        StringBuilder sb;
        for (int i=0; i < cInput.length-1; i++) {
            if (cInput[i] == cInput[i+1]) {
                sb = new StringBuilder();
                sb.append(cInput[i]);
                if (doubles.contains(sb.toString()))
                    return false;
                doubles.add(sb.toString());
                i++;
            }
        }

        if (doubles.size() >= 2)
            return true;
        else
            return false;
    }

    public char[] incrementChar(char[] input, int pos) {
        if (input[pos] < 'z') {
            input[pos]++;
            return input;
        } else {
            input[pos] = 'a';
            return incrementChar(input, pos-1);
        }
    }

    public String nextPwd(String input) {
        char[] cInput = input.toCharArray();

        char[] nextPwd;
        do{
            nextPwd = incrementChar(cInput, cInput.length-1);
        }
        while (!isValid(nextPwd));

        return String.copyValueOf(nextPwd);
    }
}
