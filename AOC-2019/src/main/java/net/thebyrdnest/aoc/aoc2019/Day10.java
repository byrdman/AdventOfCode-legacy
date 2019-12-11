package net.thebyrdnest.aoc.aoc2019;

import net.thebyrdnest.aoc.utils.IntCodeComputer;

public class Day10 {
    public int solve1(String[] sInput) {
        int maxX = sInput[0].length();
        int maxY = sInput.length;

        char[][] grid = new char[maxY][maxX];

        int x=0;
        int y=0;
        for (String line : sInput) {
            for (char point : line.toCharArray()) {
                grid[y][x] = point;
            }
        }

        int currScore = 0;
        int maxScore = 0;
        String maxCoords = "";
        for (y=0; y < maxY; y++) {
            for (x = 0; x < maxX; x++) {
                currScore = scoreGrid(grid, x, y);
                if (currScore > maxScore) {
                    maxScore = currScore;
                    maxCoords = x + ", " + y;
                }
            }
        }

        return maxScore;
    }

    public int scoreGrid(char[][] currGrid, int x, int y) {
        int score = 0;


        return score;
    }


    public String solve2(String[] input) { return ""; }
}