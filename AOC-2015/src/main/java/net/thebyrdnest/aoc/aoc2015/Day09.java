package net.thebyrdnest.aoc.aoc2015;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Day09 {
    Map<String, Map<String, Integer>> distances;

    public Day09() {
        distances = new HashMap<>();
    }

    public void parseInput(String[] cities) {
        // AlphaCentauri to Snowdin = 66
        for (String city : cities) {
            String parts[] = city.split(" ");

            // store based on 1st city
            Map<String, Integer> row = distances.get(parts[0]);
            if (row == null)
                row = new HashMap<>();
            row.put(parts[2], Integer.parseInt(parts[4]));
            distances.put(parts[0], row);

            // store based on 2nd city
            row = distances.get(parts[2]);
            if (row == null)
                row = new HashMap<>();
            row.put(parts[0], Integer.parseInt(parts[4]));
            distances.put(parts[2], row);
        }
    }

    public void printGrid() {
        String[] cities = new String[distances.keySet().size()];
        int i = 0;
        for (String city : distances.keySet()) {
            System.out.print("\t" + city);
            cities[i++] = city;
        }
        System.out.println();

        // rows
        for (String city : cities) {
            System.out.print(city);

            Map<String, Integer> row = distances.get(city);
            for (String city2 : cities) {
                System.out.print("\t");
                if (city2.equalsIgnoreCase(city))
                    System.out.print("\t");
                else
                    System.out.print(row.get(city2));
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }

    public String minTrip;
    public String maxTrip;
    public int minDistance = 999999999;
    public int maxDistance = 0;

    public int solve() {
        int tripDistance = 0;


        for (String city1 : distances.keySet()) {
            tripDistance = 0;

            Map<String, Integer> row1 = distances.get(city1);
            for (String city2 : distances.keySet()) {
                if (!city2.equalsIgnoreCase(city1)) {
                    tripDistance += row1.get(city2);

                    Map<String, Integer> row2 = distances.get(city2);
                    for (String city3 : distances.keySet()) {
                        if (!city3.equalsIgnoreCase(city1) &&
                            !city3.equalsIgnoreCase(city2)) {
                            tripDistance += row2.get(city3);

                            Map<String, Integer> row3 = distances.get(city3);
                            for (String city4 : distances.keySet()) {
                                if (!city4.equalsIgnoreCase(city1) &&
                                    !city4.equalsIgnoreCase(city2) &&
                                    !city4.equalsIgnoreCase(city3)) {
                                    tripDistance += row3.get(city4);

                                    Map<String, Integer> row4 = distances.get(city4);
                                    for (String city5 : distances.keySet()) {
                                        if (!city5.equalsIgnoreCase(city1) &&
                                            !city5.equalsIgnoreCase(city2) &&
                                            !city5.equalsIgnoreCase(city3) &&
                                            !city5.equalsIgnoreCase(city4)) {
                                            tripDistance += row4.get(city5);

                                            Map<String, Integer> row5 = distances.get(city5);
                                            for (String city6 : distances.keySet()) {
                                                if (!city6.equalsIgnoreCase(city1) &&
                                                    !city6.equalsIgnoreCase(city2) &&
                                                    !city6.equalsIgnoreCase(city3) &&
                                                    !city6.equalsIgnoreCase(city4) &&
                                                    !city6.equalsIgnoreCase(city5)) {
                                                    tripDistance += row5.get(city6);

                                                    Map<String, Integer> row6 = distances.get(city6);
                                                    for (String city7 : distances.keySet()) {
                                                        if (!city7.equalsIgnoreCase(city1) &&
                                                            !city7.equalsIgnoreCase(city2) &&
                                                            !city7.equalsIgnoreCase(city3) &&
                                                            !city7.equalsIgnoreCase(city4) &&
                                                            !city7.equalsIgnoreCase(city5) &&
                                                            !city7.equalsIgnoreCase(city6)) {
                                                            tripDistance += row6.get(city7);

                                                            Map<String, Integer> row7 = distances.get(city7);
                                                            for (String city8 : distances.keySet()) {
                                                                if (!city8.equalsIgnoreCase(city1) &&
                                                                    !city8.equalsIgnoreCase(city2) &&
                                                                    !city8.equalsIgnoreCase(city3) &&
                                                                    !city8.equalsIgnoreCase(city4) &&
                                                                    !city8.equalsIgnoreCase(city5) &&
                                                                    !city8.equalsIgnoreCase(city6) &&
                                                                    !city8.equalsIgnoreCase(city7)) {
                                                                    tripDistance += row7.get(city8);

                                                                    if (tripDistance < minDistance) {
                                                                        minDistance = tripDistance;
                                                                        minTrip = city1 + "->" + city2 + "->" + city3 + "->" + city4 + "->" + city5 + "->" + city6 + "->" + city7 + "->" + city8;
                                                                    }

                                                                    if (tripDistance > maxDistance) {
                                                                        maxDistance = tripDistance;
                                                                        maxTrip = city1 + "->" + city2 + "->" + city3 + "->" + city4 + "->" + city5 + "->" + city6 + "->" + city7 + "->" + city8;
                                                                    }
                                                                    tripDistance -= row7.get(city8);
                                                                }
                                                            }
                                                            tripDistance -= row6.get(city7);
                                                        }
                                                    }
                                                    tripDistance -= row5.get(city6);
                                                }
                                            }
                                            tripDistance -= row4.get(city5);
                                        }
                                    }
                                    tripDistance -= row3.get(city4);
                                }
                            }
                            tripDistance -= row2.get(city3);
                        }
                    }
                    tripDistance -= row1.get(city2);
                }
            }
        }

        return minDistance;
    }

    public int solve2() {
        int tripDistance = 0;
        int minDistance = 999999999;

        Map<String, Integer> row;
        for (String city1 : distances.keySet()) {
            tripDistance = 0;
            Map<String, Integer> row1 = distances.get(city1);
            for (String city2 : distances.keySet()) {
                if (!city2.equalsIgnoreCase(city1)) {
                    tripDistance += row1.get(city2);
                    Map<String, Integer> row2 = distances.get(city2);
                    for (String city3 : distances.keySet()) {
                        if (!city3.equalsIgnoreCase(city1) &&
                                !city3.equalsIgnoreCase(city2)) {

                            tripDistance += row2.get(city3);

                            if (tripDistance < minDistance) {
                                minDistance = tripDistance;
                                minTrip = city1 + "->" + city2 + "->" + city3;
                            }

                            tripDistance -= row2.get(city3);
                        }
                    }
                    tripDistance -= row1.get(city2);
                }
            }
        }

        return minDistance;
    }
}
