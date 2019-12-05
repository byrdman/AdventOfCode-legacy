package net.thebyrdnest.aoc.aoc2015;

public class Day06 implements DayTemplate {

    int[][] grid = new int[1000][1000];

    public Day06() {
        for (int i=0; i<1000; i++)
            for (int j=0; j<1000; j++)
                grid[i][j] = 0;
    }

    public int solve1(String input) {
        String[] instructions = input.split("\n");
        int totalOn = 0;

        for (String instruction : instructions) {
            String[] parts = instruction.split(" ");
            if (parts[0].equalsIgnoreCase("toggle")) {
                String[] startCoords = parts[1].split(",");
                String[] endCoords = parts[3].split(",");

                int startX = Integer.parseInt(startCoords[0]);
                int startY = Integer.parseInt(startCoords[1]);
                int endX = Integer.parseInt(endCoords[0]);
                int endY = Integer.parseInt(endCoords[1]);

                for (int x = startX; x <= endX; x++) {
                    for (int y = startY; y <= endY; y++) {
                        if (grid[x][y] == 1) {
                            grid[x][y] = 0;
                            totalOn--;
                        }
                        else if (grid[x][y] == 0) {
                            grid[x][y] = 1;
                            totalOn++;
                        }

                    }
                }

            } else if (parts[1].equalsIgnoreCase("on")) {
                String[] startCoords = parts[2].split(",");
                String[] endCoords = parts[4].split(",");

                int startX = Integer.parseInt(startCoords[0]);
                int startY = Integer.parseInt(startCoords[1]);
                int endX = Integer.parseInt(endCoords[0]);
                int endY = Integer.parseInt(endCoords[1]);

                for (int x = startX; x <= endX; x++) {
                    for (int y = startY; y <= endY; y++) {
                        if (grid[x][y] == 0) {
                            grid[x][y] = 1;
                            totalOn++;
                        }
                    }
                }

            } else if (parts[1].equalsIgnoreCase("off")) {
                String[] startCoords = parts[2].split(",");
                String[] endCoords = parts[4].split(",");

                int startX = Integer.parseInt(startCoords[0]);
                int startY = Integer.parseInt(startCoords[1]);
                int endX = Integer.parseInt(endCoords[0]);
                int endY = Integer.parseInt(endCoords[1]);

                for (int x = startX; x <= endX; x++) {
                    for (int y = startY; y <= endY; y++) {
                        if (grid[x][y] == 1) {
                            grid[x][y] = 0;
                            totalOn--;
                        }
                    }
                }
            }
        }
        return totalOn;
    }

    public int solve2(String input) {
        String[] instructions = input.split("\n");
        int totalBrightness = 0;

        for (String instruction : instructions) {
            String[] parts = instruction.split(" ");

            if (parts[0].equalsIgnoreCase("toggle")) {
                String[] startCoords = parts[1].split(",");
                String[] endCoords = parts[3].split(",");

                int startX = Integer.parseInt(startCoords[0]);
                int startY = Integer.parseInt(startCoords[1]);
                int endX = Integer.parseInt(endCoords[0]);
                int endY = Integer.parseInt(endCoords[1]);

                for (int x = startX; x <= endX; x++) {
                    for (int y = startY; y <= endY; y++) {
                        grid[x][y]+=2;
                        totalBrightness+=2;
                    }
                }

            } else if (parts[1].equalsIgnoreCase("on")) {
                String[] startCoords = parts[2].split(",");
                String[] endCoords = parts[4].split(",");

                int startX = Integer.parseInt(startCoords[0]);
                int startY = Integer.parseInt(startCoords[1]);
                int endX = Integer.parseInt(endCoords[0]);
                int endY = Integer.parseInt(endCoords[1]);

                for (int x = startX; x <= endX; x++) {
                    for (int y = startY; y <= endY; y++) {
                        grid[x][y]++;
                        totalBrightness++;
                    }
                }

            } else if (parts[1].equalsIgnoreCase("off")) {
                String[] startCoords = parts[2].split(",");
                String[] endCoords = parts[4].split(",");

                int startX = Integer.parseInt(startCoords[0]);
                int startY = Integer.parseInt(startCoords[1]);
                int endX = Integer.parseInt(endCoords[0]);
                int endY = Integer.parseInt(endCoords[1]);

                for (int x = startX; x <= endX; x++) {
                    for (int y = startY; y <= endY; y++) {
                        if (grid[x][y] > 0) {
                            grid[x][y]--;
                            totalBrightness--;
                        }
                    }
                }
            } else {
                System.out.println("couldn't interpret: " + instruction);
            }
        }
        return totalBrightness;
    }
}
