package net.thebyrdnest.aoc.aoc2017;

public class Day02 {
    public int solve1(String input) {
        int checksum = 0;

        String[] lines = input.split("\n");

        for (String line : lines) {
            String[] digits = line.split("\t");
            int min = 99999;
            int max = -1;
            for (String sDigit : digits) {
                int iDigit = Integer.parseInt(sDigit);
                if (iDigit < min)
                    min = iDigit;
                if (iDigit > max)
                    max = iDigit;
            }

            checksum += max - min;
        }

        return checksum;
    }

    public int solve2(String input) {
        int checksum = 0;

        String[] lines = input.split("\n");

        for (String line : lines) {
            String[] digits = line.split("\t");

            // check pairs
            boolean bFoundit = false;
            for (int i = 0; i < digits.length && !bFoundit; i++)
            {
                for (int j = 0; j < digits.length && !bFoundit; j++) {
                    if (i != j) {
                        int iDigit1 = Integer.parseInt(digits[i]);
                        int iDigit2 = Integer.parseInt(digits[j]);
                        if (iDigit1 % iDigit2 == 0) {
                            checksum += iDigit1 / iDigit2;
                            bFoundit = true;
                        } else if (iDigit2 % iDigit1 == 0) {
                            checksum += iDigit2 / iDigit1;
                            bFoundit = true;
                        }
                    }
                }
            }
        }

        return checksum;
    }
}
