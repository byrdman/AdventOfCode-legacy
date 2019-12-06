package net.thebyrdnest.aoc.aoc2019;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Day06 {

    private class Planet {
        String planetName;
        Set<Planet> satellites;
        Planet parent;

        Planet(String planetName, Planet parent) {
            this.planetName = planetName;
            this.parent = parent;
            satellites = new HashSet<>();
        }

        public void addSatellite(Planet satellite) {
            satellites.add(satellite);
        }

        public Planet getParent() {
            return parent;
        }

        public String getPlanetName() {
            return planetName;
        }

        public Set<Planet> getSatellites() {
            return satellites;
        }
    }

    Planet COM = new Planet("COM", null);
    Map<String, Planet> solarSystem = new HashMap<>();

    public int solve1(String[] input) {
        buildSolarSystem(input);
        return 0;
    }

    public int solve2(String[] input) {
        return 0;
    }

    public void buildSolarSystem(String[] inputs) {
        for (String input : inputs) {
            String[] parts = input.split(",");
            Planet parent = solarSystem.get(parts[0]);
            if (parent == null) {
                parent = new Planet(parts[0], null);
            }
            Planet satellite = new Planet(parts[1], parent);
            parent.addSatellite(satellite);
            solarSystem.put(parts[0], parent);
            solarSystem.put(parts[1], satellite);
        }
    }

    public int getOrbitCount(String planetName) {
        int iOrbits = 0;
        Planet planet = solarSystem.get(planetName);
        Planet parent = planet.getParent();
        while (parent != null) {
            iOrbits++;
            parent = parent.getParent();
        }

        return iOrbits;
    }

    public int getAllOrbitCount() {
        int iOrbits = 0;

        for (String planet : solarSystem.keySet())
            iOrbits += getOrbitCount(planet);

        return iOrbits;
    }

    public void listCounts() {
        Map<String, Integer> counts = new HashMap<>();
        for (String planetName : solarSystem.keySet()) {
            Planet planet = solarSystem.get(planetName);
            if (!counts.containsKey(planetName)) {
                counts.put(planetName, planet.getSatellites().size());
                System.out.println(planetName + ": " + planet.getSatellites().size());
            } else {
                System.out.println(planetName + " already in there");
            }
        }
    }
}
