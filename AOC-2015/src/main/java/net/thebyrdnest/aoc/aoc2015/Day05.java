package net.thebyrdnest.aoc.aoc2015;

public class Day05 implements DayTemplate {

    public int vowelCount(String input) {
        int numberOfVowels = 0;
        char[] cInput = input.toCharArray();

        for (char c : cInput)
            switch (c) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    numberOfVowels++;
        }

        return numberOfVowels;
    }

    public boolean hasDoubleLetter(String input) {
        char[] cInput = input.toCharArray();

        for (int i=0; i < cInput.length-1; i++) {
            if (cInput[i] == cInput[i+1])
                return true;
        }
        return false;
    }

    /*
            abcdefgab
     */
    public boolean has2Pairs(String input) {
        int iPairCount = 0;

        for (int i=0; i < input.length()-2; i++) {
            for (int j=2; j < input.length()-2; j++) {
                String firstPair = input.substring(i, i+2);
                String secondPair = input.substring(j, j+2);
                if (i != j && firstPair.equalsIgnoreCase(secondPair)) {
                    iPairCount++;
                }
            }
        }

        return iPairCount == 2;
    }

    public boolean hasRepeat(String input) {
        char[] cInput = input.toCharArray();

        for (int i=0; i<input.length()-2; i++) {
            if (cInput[i] == cInput[i+2])
                return true;
        }

        return false;
    }

    public boolean isNice1(String input) {
        if (input.contains("ab") || input.contains("cd") || input.contains("pq") || input.contains("xy")
                || vowelCount(input) < 3 || !hasDoubleLetter(input))
            return false;
        else
            return true;
    }

    public boolean isNice2(String input) {
        if (has2Pairs(input) && hasRepeat(input))
            return true;
        else
            return false;
    }

    public int solve1(String input) {
        int niceCount = 0;
        String[] words = input.split("\n");

        for (String word : words) {
            if (isNice1(word))
                niceCount++;
        }
        return niceCount;
    }

    public int solve2(String input) {
        int niceCount = 0;
        String[] words = input.split("\n");

        for (String word : words) {
            if (isNice2(word))
                niceCount++;
        }
        return niceCount;
    }
}
