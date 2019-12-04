package net.thebyrdnest.aoc.aoc2019;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day03 {
    char[][] grid = new char[20000][20000];
    int maxX;
    int maxY;
    int initX;
    int initY;
    int manhatanDistance;
    Map<String, Integer> stepCounts;
    List<String> intersections;

    public Day03(int maxX, int maxY, int initX, int initY) {
        this.maxX = maxX;
        this.maxY = maxY;
        this.initX = initX;
        this.initY = initY;
        manhatanDistance = maxX + maxY + 10;

        for (int x = 0; x < maxX; x++) {
            for (int y = 0; y < maxY; y++) {
                grid[x][y] = '.';
            }
        }

        grid[initY][initX] = 'o';

        stepCounts = new HashMap<>();
        intersections = new ArrayList<>();
    }

    public StringBuffer printGrid() {
        StringBuffer sb = new StringBuffer();
        sb.append("+");
        for (int x = 0; x < maxX; x++) {
            sb.append("-");
        }
        sb.append("+\n");
        for (int y = maxY-1; y >= 0; y--) {
            sb.append("|");
            for (int x = 0; x < maxX; x++) {
                sb.append(grid[y][x]);
            }
            sb.append("|\n");
        }
        sb.append("+");
        for (int x = 0; x < maxX; x++) {
            sb.append("-");
        }
        sb.append("+");

        return sb;
    }

    private void markGrid(int x, int y, char lineMark, char otherLineMark) {
        if (grid[y][x] == 'o') {
            // do nothing
        } else if (grid[y][x] == otherLineMark) {
            grid[y][x] = 'X';

            int newDist = 0;
            if (y < initY)
                newDist = (initY - y);
            else
                newDist = (y - initY);

            if (x < initX)
                newDist = newDist + (initX - x);
            else
                newDist = newDist + (x - initX);

            if (newDist < manhatanDistance)
                manhatanDistance = newDist;
        } else {
            grid[y][x] = lineMark;
        }
    }

    private void drawLine(String lineDef, char lineMark, char otherLineMark) {
        String[] steps = lineDef.split(",");
        int x = initX;
        int y = initY;
        int totalSteps = 0;

        for (int index = 0; index < steps.length; index++) {
            //System.out.println(printGrid());
            String direction = steps[index].substring(0, 1);
            int length = Integer.parseInt(steps[index].substring(1));

            switch(direction) {
                case "R":
                    for (int count = 0; count < length; count++) {
                        x++;
                        markGrid(x, y, lineMark, otherLineMark);
                        totalSteps++;
                        if (grid[y][x] == 'X') {
                            intersections.add(new String(x + "_" + y));
                            stepCounts.put(new String(x + "_" + y + "_" + lineMark), Integer.valueOf(totalSteps));
                        }
                    }
                    break;
                case "L":
                    for (int count = 0; count < length; count++) {
                        x--;
                        markGrid(x, y, lineMark, otherLineMark);
                        totalSteps++;
                        if (grid[y][x] == 'X') {
                            intersections.add(new String(x + "_" + y));
                            stepCounts.put(new String(x + "_" + y + "_" + lineMark), Integer.valueOf(totalSteps));
                        }
                    }
                    break;
                case "U":
                    for (int count = 0; count < length; count++) {
                        y++;
                        markGrid(x, y, lineMark, otherLineMark);
                        totalSteps++;
                        if (grid[y][x] == 'X') {
                            intersections.add(new String(x + "_" + y));
                            stepCounts.put(new String(x + "_" + y + "_" + lineMark), Integer.valueOf(totalSteps));
                        }
                    }
                    break;
                case "D":
                    for (int count = 0; count < length; count++) {
                        y--;
                        markGrid(x, y, lineMark, otherLineMark);
                        totalSteps++;
                        if (grid[y][x] == 'X') {
                            intersections.add(new String(x + "_" + y));
                            stepCounts.put(new String(x + "_" + y + "_" + lineMark), Integer.valueOf(totalSteps));
                        }
                    }
                    break;
            }
        }
    }

    public void stepCount(String lineDef, char lineMark) {
        String[] steps = lineDef.split(",");
        int x = initX;
        int y = initY;
        int totalSteps = 0;

        for (int index = 0; index < steps.length; index++) {
            String direction = steps[index].substring(0, 1);
            int length = Integer.parseInt(steps[index].substring(1));

            switch(direction) {
                case "R":
                    for (int count = 0; count < length; count++) {
                        x++;
                        totalSteps++;
                        if (grid[y][x] == 'X') {
                            intersections.add(new String(x + "_" + y));
                            stepCounts.put(new String(x + "_" + y + "_" + lineMark), Integer.valueOf(totalSteps));
                        }
                    }
                    break;
                case "L":
                    for (int count = 0; count < length; count++) {
                        x--;
                        totalSteps++;
                        if (grid[y][x] == 'X') {
                            intersections.add(new String(x + "_" + y));
                            stepCounts.put(new String(x + "_" + y + "_" + lineMark), Integer.valueOf(totalSteps));
                        }
                    }
                    break;
                case "U":
                    for (int count = 0; count < length; count++) {
                        y++;
                        totalSteps++;
                        if (grid[y][x] == 'X') {
                            intersections.add(new String(x + "_" + y));
                            stepCounts.put(new String(x + "_" + y + "_" + lineMark), Integer.valueOf(totalSteps));
                        }
                    }
                    break;
                case "D":
                    for (int count = 0; count < length; count++) {
                        y--;
                        totalSteps++;
                        if (grid[y][x] == 'X') {
                            intersections.add(new String(x + "_" + y));
                            stepCounts.put(new String(x + "_" + y + "_" + lineMark), Integer.valueOf(totalSteps));
                        }
                    }
                    break;
            }
        }

    }

    public int solve1(String line1, String line2) {
        drawLine(line1, '1', '2');
        drawLine(line2, '2', '1');

        return manhatanDistance;
    }

    public int solve2(String line1, String line2) {
        solve1(line1, line2);
        stepCount(line1, '1');

        int minCombined = Integer.MAX_VALUE;
        for (String intersection : intersections) {
            int tempCombined = stepCounts.get(intersection + "_1") + stepCounts.get(intersection + "_2");
            if (tempCombined < minCombined)
                minCombined = tempCombined;
        }

        return minCombined;
    }
}
