package net.thebyrdnest.aoc.aoc2015;

public class Day01 {

    public int solve1(String trip) {
        int floor = 0;

        for (int i=0; i < trip.length(); i++) {
            if (trip.charAt(i) == '(')
                floor++;
            else
                floor--;
        }
        return floor;
    }

    public int solve2(String trip) {
        int floor = 0;

        for (int i=0; i < trip.length(); i++) {
            if (trip.charAt(i) == '(')
                floor++;
            else
                floor--;

            if (floor == -1)
                return i+1;
        }
        return -1;

    }
}
