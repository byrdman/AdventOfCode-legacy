package net.thebyrdnest.aoc.aoc2017;

public class Day03 {
    int memory[][] = new int[2000][2000];

    public int findRing(int target) {
        int iRing = 1;
        int iRingMax = 1;
        while (iRingMax < target) {
            iRing++;
            iRingMax = getRingMax(iRing);
        }

        return iRing;
    }

    public int getRingMax(int ring) {
        return (2*ring-1)*(2*ring-1);
    }

    public int findLegMax(int ring, int target) {
        int iRingMin = getRingMax(ring-1)+1;
        int iRingMax = getRingMax(ring);

        int iRingSize = iRingMax - iRingMin + 1;
        int iLegSize = iRingSize / 4;

        int iSE = iRingMax;
        int iSW = iSE - iLegSize;
        int iNW = iSW - iLegSize;
        int iNE = iNW - iLegSize;

        if (target <= iNE)
            return iNE;
        else if (target <= iNW)
            return iNW;
        else if (target <= iSW)
            return iSW;
        else
            return iSE;
    }

    public int solve1(int target) {
        int ring = findRing(target);
        int current = findLegMax(ring, target);

        int minSteps = ring-1;
        int maxSteps = 2*(minSteps);
        int currStep = maxSteps;

        while (current > target && currStep > minSteps) {
            current--;
            currStep--;
        }

        while (current > target) {
            current--;
            currStep++;
        }

        return currStep;
    }

    public int solve2(int target) {
        // brute forced in excel
        int[][] data = new int[100][100];
        int x = 50;
        int y= 50;
        return 0;
    }
}
