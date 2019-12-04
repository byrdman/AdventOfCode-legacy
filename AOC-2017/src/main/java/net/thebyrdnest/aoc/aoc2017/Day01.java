package net.thebyrdnest.aoc.aoc2017;

public class Day01 {
    public int solve1(String input) {
        StringBuilder sb = new StringBuilder();
        sb.append(input);
        sb.append(input.substring(0,1));

        char[] numbers = sb.toString().toCharArray();

        int sum = 0;

        for (int i=0; i < input.length(); i++) {
            if (numbers[i] == numbers[i+1]) {
                sum += numbers[i] - '0';
            }
        }

        return sum;
    }

    public int solve2(String input) {
        StringBuilder sb = new StringBuilder();
        sb.append(input);
        sb.append(input.substring(0, input.length()/2));

        char[] numbers = sb.toString().toCharArray();

        int sum = 0;

        for (int i=0; i < input.length(); i++) {
            if (numbers[i] == numbers[i+input.length()/2]) {
                sum += numbers[i] - '0';
            }
        }

        return sum;
    }
}
