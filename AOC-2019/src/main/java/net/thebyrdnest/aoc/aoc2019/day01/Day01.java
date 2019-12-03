package net.thebyrdnest.aoc.aoc2019.day01;

public class Day01 {
    public int calcFuel(int mass) {
        int fuel = Math.round(mass/3) - 2;
        if (fuel < 0)
            return 0;
        else
            return fuel;
    }

    public int solve1(int[] masses) {
        int totalFuel = 0;
        for (int mass : masses) {
            totalFuel += calcFuel(mass);
        }
        return totalFuel;
    }

    public int solve2(int[] masses) {
        int totalFuel = 0;
        for (int mass : masses) {
            int moduleFuel = calcFuel(mass);
            do {
                totalFuel += moduleFuel;
                moduleFuel = calcFuel(moduleFuel);
            } while (moduleFuel > 0);
        }
        return totalFuel;
    }
}
