package net.thebyrdnest.aoc.aoc2019.day03;

public class Day03 {
    char[][] grid = null;
    int maxX = 10;
    int maxY = 10;
    int initX = 1;
    int initY = 1;

    public Day03(int maxX, int maxY, int initX, int initY) {
        grid = new char[maxY][maxX];
        this.maxX = maxX;
        this.maxY = maxY;
        this.initX = initX;
        this.initY = initY;

        for (int x = 0; x < maxX; x++) {
            for (int y = 0; y < maxY; y++) {
                grid[x][y] = '.';
            }
        }

        grid[initY][initX] = 'o';
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
        } else {
            grid[y][x] = lineMark;
        }
    }

    private void drawLine(String lineDef, char lineMark, char otherLineMark) {
        String[] steps = lineDef.split(",");
        int x = initX;
        int y = initY;

        for (int index = 0; index < steps.length; index++) {
            String direction = steps[index].substring(1, 2);
            int length = Integer.parseInt(steps[index].substring(2));

            switch(direction) {
                case "R":
                    for (int count = 0; count < length; count++) {
                        markGrid(x, y, lineMark, otherLineMark);
                    }
            }
        }
    }
}
