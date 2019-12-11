package net.thebyrdnest.aoc.aoc2019;

import net.thebyrdnest.aoc.utils.IntCodeComputer;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.*;
import java.util.List;

public class Day10 {
    public char[][] loadData(String[] sInput, int maxX, int maxY) {
        char[][] grid = new char[maxX][maxY];

        int x=0;
        int y=0;
        for (String line : sInput) {
            x=0;
            for (char point : line.toCharArray()) {
                grid[x][y] = point;
                x++;
            }
            y++;
        }

        return grid;
    }

    public double angleBetweenPoints(int x0, int y0, int x1, int y1) {
        int dx = x1 - x0;
        int dy = y1 - y0;

        double angle = Math.atan2(dx, dy) * 180.0 / Math.PI;
        angle = Math.round(angle * 10.0);
        return angle;
    }

    public double clockwiseAngle(double degree) {
        return ((3600 - (degree +3600) % 3600) % 3600 + 900) % 3600;
    }

    public int countVisible(char[][] grid, int maxX, int maxY, int x0, int y0) {
        Set<Double> angles = new HashSet<>();
        for (int x=0; x < maxX; x++) {
            for (int y=0; y < maxY; y++) {
                if (!(x == x0 && y == y0) && grid[x][y] == '#') {
                    double angle = angleBetweenPoints(x0, y0, x, y);
                    angles.add(angle);
                }
            }
        }

        return angles.size();
    }

    int bestX = 0;
    int bestY = 0;
    public int solve1(String[] sInput) {
        int maxX = sInput[0].length();
        int maxY = sInput.length;
        char[][] grid = loadData(sInput, maxX, maxY);

        int x;
        int y;

        int currScore = 0;
        int maxScore = 0;
        String maxCoords = "";
        for (y=0; y < maxY; y++) {
            for (x = 0; x < maxX; x++) {
                if (grid[x][y] == '#') {
                    currScore = countVisible(grid, maxX, maxY, x, y);
                    if (currScore > maxScore) {
                        maxScore = currScore;
                        bestX = x;
                        bestY = y;
                    }
                }
            }
        }

        return maxScore;
    }

    private class Asteroid {
        public Point coords;
        public boolean zapped;

        Asteroid(int x, int y) {
            coords = new Point(x, y);
            zapped = false;
        }
    }

    public double solve2(String[] sInput) {

        int maxX = sInput[0].length();
        int maxY = sInput.length;
        char[][] grid = loadData(sInput, maxX, maxY);
        bestX = 0;
        bestY = 0;

        solve1(sInput);

        int x;
        int y;

        Map<Double, TreeMap<Integer, Asteroid>> astroids = new HashMap<>();
        for (y=0; y < maxY; y++) {
            for (x = 0; x < maxX; x++) {
                if (!(x==bestX && y==bestY) && grid[x][y] == '#') {
                    double angle = clockwiseAngle(angleBetweenPoints(bestX, bestY, x, y));
                    int manhattan = Math.abs(x-bestX) + Math.abs(y-bestY);

                    TreeMap<Integer, Asteroid> hmData = astroids.get(angle);
                    if (hmData == null) {
                        hmData = new TreeMap<Integer, Asteroid>();
                    }
                    hmData.put(manhattan, new Asteroid(x, y));
                    astroids.put(angle, hmData);
                }
            }
        }

        int counter = 0;
        Asteroid point = new Asteroid(0,0);
        List<Double> hitList = new ArrayList<>();
        boolean bFoundOne = false;
        while (astroids.size() > 0 && !bFoundOne) {
            bFoundOne = false;
            for (Double key : astroids.keySet()) {
                TreeMap<Integer, Asteroid> hmData = astroids.get(key);
                if (hmData != null) {
                    Iterator inter = hmData.entrySet().iterator();
                    int iKey = 0;
                    while (inter.hasNext()) {
                        Map.Entry<Integer, Asteroid> m = (Map.Entry<Integer, Asteroid>) inter.next();
                        Asteroid asteroid = m.getValue();
                        if (asteroid.zapped == false) {
                            hitList.add(asteroid.coords.getX() *100 + asteroid.coords.getY());
                            asteroid.zapped = true;
                            hmData.put(m.getKey(), asteroid);
                            bFoundOne = true;
                            break;
                        }
                    }
                }
                counter++;
            }
        }

        System.out.println("Base: (" + bestX + ", " + bestY + ")");
        int i=0;
        for (Double d : hitList) {
            System.out.println(i + ": " + d);
            i++;
        }

        return hitList.get(199);
    }

    public String printBest() {
        return "(" + bestX + ", " + bestY + ")";
    }
}