package net.thebyrdnest.aoc.aoc2019;

import net.thebyrdnest.aoc.utils.IntCodeComputerCPU;

import java.awt.*;
import java.util.*;

public class Day11 {

    long[] program = {3,8,1005,8,324,1106,0,11,0,0,0,104,1,104,0,3,8,102,-1,8,10,101,1,10,10,4,10,1008,8,0,10,4,10,1002,8,1,29,2,1102,17,10,3,8,102,-1,8,10,1001,10,1,10,4,10,1008,8,1,10,4,10,
            102,1,8,55,2,4,6,10,1,1006,10,10,1,6,14,10,3,8,1002,8,-1,10,101,1,10,10,4,10,1008,8,1,10,4,10,101,0,8,89,3,8,102,-1,8,10,1001,10,1,10,4,10,108,0,8,10,4,10,1002,8,1,110,1,104,8,10,3,
            8,1002,8,-1,10,1001,10,1,10,4,10,1008,8,1,10,4,10,102,1,8,137,2,9,17,10,2,1101,14,10,3,8,102,-1,8,10,101,1,10,10,4,10,1008,8,0,10,4,10,101,0,8,167,1,107,6,10,1,104,6,10,2,1106,6,10,3
            ,8,1002,8,-1,10,101,1,10,10,4,10,108,1,8,10,4,10,1001,8,0,200,1006,0,52,1006,0,70,1006,0,52,3,8,102,-1,8,10,101,1,10,10,4,10,1008,8,1,10,4,10,1002,8,1,232,1006,0,26,1,104,19,10,3,8,
            102,-1,8,10,1001,10,1,10,4,10,108,0,8,10,4,10,102,1,8,260,1,2,15,10,2,1102,14,10,3,8,1002,8,-1,10,1001,10,1,10,4,10,108,0,8,10,4,10,1001,8,0,290,1,108,11,10,1006,0,36,1006,0,90,1006,
            0,52,101,1,9,9,1007,9,940,10,1005,10,15,99,109,646,104,0,104,1,21101,0,666412360596L,1,21101,341,0,0,1105,1,445,21101,838366659476L,0,1,21102,1,352,0,1106,0,445,3,10,104,0,104,1,3,10,
            104,0,104,0,3,10,104,0,104,1,3,10,104,0,104,1,3,10,104,0,104,0,3,10,104,0,104,1,21101,0,97713695975L,1,21102,1,399,0,1106,0,445,21102,179469028392L,1,1,21101,410,0,0,1105,1,445,3,10,
            104,0,104,0,3,10,104,0,104,0,21102,1,988220650260L,1,21101,433,0,0,1105,1,445,21101,0,838345843560L,1,21101,444,0,0,1106,0,445,99,109,2,22101,0,-1,1,21102,1,40,2,21102,1,476,3,21101,
            466,0,0,1106,0,509,109,-2,2105,1,0,0,1,0,0,1,109,2,3,10,204,-1,1001,471,472,487,4,0,1001,471,1,471,108,4,471,10,1006,10,503,1101,0,0,471,109,-2,2106,0,0,0,109,4,1202,-1,1,508,1207,-3,
            0,10,1006,10,526,21101,0,0,-3,22101,0,-3,1,22102,1,-2,2,21102,1,1,3,21101,0,545,0,1106,0,550,109,-4,2105,1,0,109,5,1207,-3,1,10,1006,10,573,2207,-4,-2,10,1006,10,573,21201,-4,0,-4,
            1106,0,641,21201,-4,0,1,21201,-3,-1,2,21202,-2,2,3,21102,592,1,0,1106,0,550,21201,1,0,-4,21101,0,1,-1,2207,-4,-2,10,1006,10,611,21101,0,0,-1,22202,-2,-1,-2,2107,0,-3,10,1006,10,633,
            22102,1,-1,1,21102,1,633,0,106,0,508,21202,-2,-1,-2,22201,-4,-2,-4,109,-5,2105,1,0};

    IntCodeComputerCPU brain;
    HashMap<Point, Character> hull;
    int panelsPainted = 0;
    char currDir = 'N';
    Set<String> panels;
    int minX = 99999;
    int minY = 99999;
    int maxX = 0;
    int maxY = 0;
    boolean bDebug = false;
    ArrayList<Long> outputQueue = new ArrayList<>();

    public Day11() {
        hull = new HashMap<>();
        panels = new HashSet<>();
        brain = new IntCodeComputerCPU(0, program);
        brain.setOutputQueue(outputQueue);
        brain.start();
    }

    public boolean isOutputReady() {
        return (outputQueue.size() > 0);
    }

    public long getOutputValue() {
        Long returnValue = outputQueue.get(0);
        outputQueue.remove(0);
        return returnValue;
    }

    public void setDebugFlag(boolean flag) {
        bDebug = flag;
    }

    private void debugOutput(String value) {
        if (bDebug)
            System.out.println(value);
    }

    public char getPanelColor(int x, int y) {
        Point point = new Point(x, y);
        Character hullColor = hull.get(point);
        if (hullColor == null) {
            debugOutput("(" + x + ", " + y + ") new");
            return '.';
        }
        else
            return hullColor;
    }

    public void setPanelColor(int x, int y, char color) {
        Point point = new Point(x, y);
        hull.put(point, color);
    }

    public char paintSquare(char currentColor) {
        if (currentColor == '#') //white
            brain.setInput(1L);
        else
            brain.setInput(0L);

        while (!isOutputReady() ) {
            //Thread.yield();
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                System.err.println("11-1 sleep error");
            }
        }

        long paintColor = getOutputValue();
        if (paintColor == 0) { // 0 = black, 1 = white
            return '.'; //black
        }
        else {
            return '#'; //white
        }
    }

    public char getMove() {
        while (!isOutputReady() && !brain.isDone()) {
            //Thread.yield();
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                System.err.println("11-2 sleep error");
            }
        }

        long move = getOutputValue();

        if (move == 0)
            return 'L';
        else
            return 'R';
    }

    public void turn(char turnDir) {
        if (currDir == 'N') {
            if (turnDir == 'L')
                currDir = 'W';
            else
                currDir = 'E';
        } else if (currDir == 'E') {
            if (turnDir == 'L')
                currDir = 'N';
            else
                currDir = 'S';
        } else if (currDir == 'S') {
            if (turnDir == 'L')
                currDir = 'E';
            else
                currDir = 'W';
        } else if (currDir == 'W') {
            if (turnDir == 'L')
                currDir = 'S';
            else
                currDir = 'N';
        }

    }

    
    public int paintHull() {
        int x=0;
        int y=0;
        currDir = 'N';
        Point currPoint;
        char currColor;

        do {
            currPoint = new Point(x, y);
            currColor = getPanelColor(x, y);
            hull.put(currPoint, paintSquare(currColor));
            if (panels.size() % 100 == 0) {
                printHull();
            }

            panels.add("(" + x + "," + y + ")");
            panelsPainted++;

            // get move
            char move = getMove();

            debugOutput("(" + x + "," + y + ") " + currColor + " " + hull.get(currPoint) + " " + move + " " + currDir + " ");

            turn(move);

            switch (currDir) {
                case 'N':
                    y--;
                    break;
                case 'S':
                    y++;
                    break;
                case 'W':
                    x--;
                    break;
                case 'E':
                    x++;
                    break;
            }

           // System.out.println(currDir);

            if (x < minX)
                minX = x;
            if (x > maxX)
                maxX = x;
            if (y < minY)
                minY = y;
            if (y > maxY)
                maxY = y;
        } while (!brain.isDone());

        //return panelsPainted;
        System.out.println("X: " + minX + ", " + maxX);
        System.out.println("Y: " + minY + ", " + maxY);
        System.out.println("panelsPainted: " + panelsPainted);
        System.out.println("unique panels painted: " + panels.size());

        printHull();

        return panels.size();
    }

    public String printHull() {
        StringBuilder sb = new StringBuilder();
        System.out.println("X: " + minX + ", " + maxX);
        System.out.println("Y: " + minY + ", " + maxY);
        System.out.println("Unique Panels: " + panels.size());
        System.out.println("Total Panels: " + panelsPainted);
        for (int y=minY; y<=maxY; y++) {
            for (int x=minX; x<=maxX; x++) {
                sb.append(getPanelColor(x, y));
            }
            sb.append("\n");
            System.out.println("");
        }
        System.out.println(sb.toString());

        return sb.toString();
    }
}