package net.thebyrdnest.aoc.aoc2015;

import java.util.HashMap;
import java.util.Map;

public class Day10 {
    public String lookAndSay(String input, int loops) {
        char[] cInput = input.toCharArray();
        int iLoop = 1;
        StringBuilder sb = null;

        do {
            int iCount = 0;
            char cLastChar = ' ';

            sb = new StringBuilder();

            for (char cCurrChar : cInput) {
                if (cCurrChar == cLastChar) {
                    iCount++;
                } else {
                    if (cLastChar != ' ') {
                        sb.append(iCount);
                        sb.append(cLastChar);
                    }
                    cLastChar = cCurrChar;
                    iCount = 1;
                }
            }
            sb.append(iCount);
            sb.append(cLastChar);
            cInput = sb.toString().toCharArray();
            iLoop++;
        } while (iLoop <= loops);

        return sb.toString();
    }
}
