package net.thebyrdnest.aoc.aoc2019;

import net.thebyrdnest.aoc.utils.Moon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Day12 {



    public Day12() {
    }

    public void step() {

    }

    ArrayList<Moon> moons = null;

    public int solve1(String[] input, int steps) {
        moons = new ArrayList<>();
        for (String line : input) {
            // <x=-4, y=-9, z=-3>
            String[] coords = line.split("[=,>]");
            Moon moon = new Moon(Integer.parseInt(coords[1]), Integer.parseInt(coords[3]), Integer.parseInt(coords[5]));
            moons.add(moon);
        }

        int totalEnergy = 0;
        for (int i=0; i < steps; i++) {
            ArrayList<Moon> newMoons = new ArrayList<>();
            for (Moon moon : moons) {
                for (Moon otherMoon : moons) {
                    if (!moon.equals(otherMoon))
                        moon.applyGravity(otherMoon);
                }
                newMoons.add(moon);
            }

            // apply velocities & calc energy
            moons = new ArrayList<>();
            totalEnergy = 0;
            for (Moon moon : newMoons) {
                moon.applyVelocity();
                moons.add(moon);
                totalEnergy += moon.calcTotalEnergy();
            }
        }

        return totalEnergy;
    }


    public String buildState(ArrayList<Moon> moons) {
        StringBuilder sb = new StringBuilder();
        for (Moon moon : moons) {
            sb.append(moon.toString());
        }
        return sb.toString();
    }

    public long solve2(String[] input) {
        Set<String> states = new HashSet<>();

        moons = new ArrayList<>();
        for (String line : input) {
            // <x=-4, y=-9, z=-3>
            String[] coords = line.split("[=,>]");
            Moon moon = new Moon(Integer.parseInt(coords[1]), Integer.parseInt(coords[3]), Integer.parseInt(coords[5]));
            moons.add(moon);
        }



        int totalEnergy = 0;
        long steps = 0;

        states.add(buildState(moons));
        steps++;

        String stateString = "";

        do {
            ArrayList<Moon> newMoons = new ArrayList<>();
            for (Moon moon : moons) {
                for (Moon otherMoon : moons) {
                    if (!moon.equals(otherMoon))
                        moon.applyGravity(otherMoon);
                }
                newMoons.add(moon);
            }

            // apply velocities & calc energy
            moons = new ArrayList<>();
            totalEnergy = 0;
            for (Moon moon : newMoons) {
                moon.applyVelocity();
                moons.add(moon);
                totalEnergy += moon.calcTotalEnergy();
            }
            states.add(buildState(moons));
            steps++;
        } while (steps == states.size());

        return steps - 1;
    }
}
