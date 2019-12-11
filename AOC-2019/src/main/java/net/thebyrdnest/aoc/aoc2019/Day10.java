package net.thebyrdnest.aoc.aoc2019;

import net.thebyrdnest.aoc.utils.IntCodeComputer;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.*;
import java.util.List;

public class Day10 {
    public char[][] loadData(String[] sInput, int maxX, int maxY) {
        char[][] grid = new char[maxY][maxX];

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

        double angle = Math.atan2(dy, dx) * 180.0 / Math.PI;
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

    public double solve2(String[] sInput) {

        int maxX = sInput[0].length();
        int maxY = sInput.length;
        char[][] grid = loadData(sInput, maxX, maxY);

        solve1(sInput);

        int x;
        int y;

        Map<Double, TreeMap<Integer, Point>> astroids = new HashMap<>();
        for (y=0; y < maxY; y++) {
            for (x = 0; x < maxX; x++) {
                if (!(x==bestX && y==bestY) && grid[x][y] == '#') {
                    double angle = clockwiseAngle(angleBetweenPoints(bestX, bestY, x, y));
                    int manhattan = x-bestX + y-bestY;

                    TreeMap<Integer, Point> hmData = astroids.get(angle);
                    if (hmData == null) {
                        hmData = new TreeMap<Integer, Point>();
                    }
                    hmData.put(manhattan, new Point(x, y));
                    astroids.put(angle, hmData);
                }
            }
        }

        int counter = 0;
        Point point = new Point(0,0);
        List<String> hitList = new ArrayList<>();
        while (astroids.size() > 0 && counter < 200) {
            for (Double key : astroids.keySet()) {
                TreeMap<Integer, Point> hmData = astroids.get(key);
                if (hmData != null) {
                    Iterator inter = hmData.entrySet().iterator();
                    int iKey = 0;
                    if (inter.hasNext()) {
                        Map.Entry<Integer, Point> m = (Map.Entry<Integer, Point>) inter.next();
                        iKey = m.getKey();
                        point = m.getValue();

                    }

                    if (hmData.size() == 1)
                        astroids.remove(key);
                    else
                        hmData.remove(iKey);
                }
                counter++;
            }
        }

        return point.getX()*100 + point.getY();
    }
}