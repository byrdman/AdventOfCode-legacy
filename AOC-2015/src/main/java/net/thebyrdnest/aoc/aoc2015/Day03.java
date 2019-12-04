package net.thebyrdnest.aoc.aoc2015;

public class Day03 {
    char[][] map = new char[1000][1000];

    private void resetMap() {
        for (int y=0; y<1000;y++)
            for (int x=0; x<1000;x++)
                map[y][x] = ' ';
        map[500][500] = 'X';
    }

    public int solve1(String input) {
        resetMap();
        int x = 500;
        int y = 500;
        int houses = 1;

        for (int i=0; i < input.length(); i++) {
            char move = input.charAt(i);

            switch(move) {
                case '<':
                    x--;
                    if (map[y][x] == ' ') {
                        map[y][x] = 'X';
                        houses++;
                    }
                    break;
                case '>':
                    x++;
                    if (map[y][x] == ' ') {
                        map[y][x] = 'X';
                        houses++;
                    }
                    break;
                case '^':
                    y--;
                    if (map[y][x] == ' ') {
                        map[y][x] = 'X';
                        houses++;
                    }
                    break;
                case 'v':
                    y++;
                    if (map[y][x] == ' ') {
                        map[y][x] = 'X';
                        houses++;
                    }
                    break;
            }
        }
        return houses;
    }



    public int solve2(String input) {
        resetMap();
        int robotX = 500;
        int robotY = 500;
        int santaX = 500;
        int santaY = 500;
        int houses = 1;
        char moveSeq = 'S';

        for (int i=0; i < input.length(); i++) {
            char move = input.charAt(i);

            switch(move) {
                case '<':
                    if (moveSeq == 'S') {
                        santaX--;
                        if (map[santaY][santaX] == ' ') {
                            map[santaY][santaX] = 'X';
                            houses++;
                        }
                        moveSeq = 'R';
                    } else {
                        robotX--;
                        if (map[robotY][robotX] == ' ') {
                            map[robotY][robotX] = 'X';
                            houses++;
                        }
                        moveSeq = 'S';
                    }
                    break;
                case '>':
                    if (moveSeq == 'S') {
                        santaX++;
                        if (map[santaY][santaX] == ' ') {
                            map[santaY][santaX] = 'X';
                            houses++;
                        }
                        moveSeq = 'R';
                    } else {
                        robotX++;
                        if (map[robotY][robotX] == ' ') {
                            map[robotY][robotX] = 'X';
                            houses++;
                        }
                        moveSeq = 'S';
                    }
                    break;
                case '^':
                    if (moveSeq == 'S') {
                        santaY--;
                        if (map[santaY][santaX] == ' ') {
                            map[santaY][santaX] = 'X';
                            houses++;
                        }
                        moveSeq = 'R';
                    } else {
                        robotY--;
                        if (map[robotY][robotX] == ' ') {
                            map[robotY][robotX] = 'X';
                            houses++;
                        }
                        moveSeq = 'S';
                    }
                    break;
                case 'v':
                    if (moveSeq == 'S') {
                        santaY++;
                        if (map[santaY][santaX] == ' ') {
                            map[santaY][santaX] = 'X';
                            houses++;
                        }
                        moveSeq = 'R';
                    } else {
                        robotY++;
                        if (map[robotY][robotX] == ' ') {
                            map[robotY][robotX] = 'X';
                            houses++;
                        }
                        moveSeq = 'S';
                    }
                    break;
            }
        }
        return houses;
    }
}
