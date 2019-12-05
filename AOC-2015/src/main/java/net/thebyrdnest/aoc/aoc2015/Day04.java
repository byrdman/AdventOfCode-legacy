package net.thebyrdnest.aoc.aoc2015;

import org.apache.commons.codec.digest.DigestUtils;

public class Day04 implements DayTemplate {

    public String getHash(String input, int size) {
        String md5Hex = DigestUtils
                .md5Hex(input);

        return md5Hex.substring(0, size);
    }

    public int solve1(String input) {
        int salt = 1;
        while (!getHash(input + salt, 5).equalsIgnoreCase("00000")) {
            salt++;
        }
        return salt;
    }

    public int solve2(String input) {
        int salt = 1;
        while (!getHash(input + salt, 6).equalsIgnoreCase("000000")) {
            salt++;
        }
        return salt;
    }
}
