package net.thebyrdnest.aoc.aoc2017;

import java.util.*;

public class Day04 {
    public boolean isLegal1(String[] words) {
        Set alPhrases = new HashSet();
        for (String word : words) {
            alPhrases.add(word);
        }

        if (words.length == alPhrases.size())
            return true;
        else
            return false;
    }

    public int[] letterCounts(String word) {
        int[] counts =  {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};

        char[] cWord = word.toCharArray();
        for (char c : cWord) {
            counts[c - 'a']++;
        }

        return counts;
    }

    public boolean enoughLetters(int[] wordOne, int[] wordTwo) {
        for (int i = 0; i < 26; i++) {
            if (wordOne[i] < wordTwo[i])
                return false;
        }

        return true;
    }

    // check for anagrams
    public boolean isLegal2(String[] words) {
        if (isLegal1(words)) {
            Set alPhrases = new HashSet();
            for (String word : words) {
                int[] originalCounts = letterCounts(word);
                for (String word2 : words) {
                    if (!word.equalsIgnoreCase(word2)) {
                        // check for <= lengths
                        if (word.length() >= word2.length()) {
                            int[] secondCounts = letterCounts(word2);

                            if (enoughLetters(originalCounts, secondCounts))
                                return false;
                        }
                    }
                }

                Set alWords = new HashSet();
                char[] letters = word.toCharArray();




                alPhrases.add(word);
            }

            if (words.length == alPhrases.size())
                return true;
            else
                return false;
        } else {
            return false;
        }

    }

    public int solve1(String[] phrases) {
        int legalCount = 0;
        for (String phrase : phrases) {
            if (isLegal1(phrase.split(" "))) {
                legalCount++;
            }
        }
        return legalCount;
    }

    public int solve2(String[] phrases) {
        return 0;
    }
}
