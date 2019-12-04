package net.thebyrdnest.aoc.aoc2015;

public class Day02 {
    public int calcArea(int l, int w, int h) {
        return 2*l*w + 2*w*h + 2*h*l;
    }

    public int calcPaper(int l, int w, int h) {
        return calcArea(l, w, h) + calcSmallestSideArea(l, w, h);
    }

    public int calcSmallestSideArea(int l, int w, int h) {
        int s1 = l*w;
        int s2 = w*h;
        int s3 = h*l;

        if (s1 <= s2 && s1 <= s3) {
            return s1;
        } else if (s2 <= s1 && s2 <= s3) {
            return s2;
        } else {
            return s3;
        }
    }

    public int calcSmallestSidePerimeter(int l, int w, int h) {
        int s1 = 2*l+2*w;
        int s2 = 2*w+2*h;
        int s3 = 2*h+2*l;

        if (s1 <= s2 && s1 <= s3) {
            return s1 + l*w*h;
        } else if (s2 <= s1 && s2 <= s3) {
            return s2 + l*w*h;
        } else {
            return s3 + l*w*h;
        }
    }

    public int solve1(String inputs) {
        String[] boxes = inputs.split(",");
        int totalArea = 0;
        for (String box : boxes) {
            String[] sides = box.split("x");
            totalArea  += calcPaper(Integer.parseInt(sides[0]), Integer.parseInt(sides[1]),Integer.parseInt(sides[2]));
        }
        return totalArea;
    }

    public int solve2(String inputs) {
        String[] boxes = inputs.split(",");
        int totalLength = 0;
        for (String box : boxes) {
            String[] sides = box.split("x");
            totalLength  += calcSmallestSidePerimeter(Integer.parseInt(sides[0]), Integer.parseInt(sides[1]),Integer.parseInt(sides[2]));
        }
        return totalLength;
    }
}
