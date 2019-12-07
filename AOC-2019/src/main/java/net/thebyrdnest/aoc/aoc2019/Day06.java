package net.thebyrdnest.aoc.aoc2019;

import java.util.*;

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

        public void setParent(Planet parent) {
            this.parent = parent;
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
            Planet satellite = solarSystem.get(parts[1]);
            if (satellite == null)
                satellite = new Planet(parts[1], parent);
            else
                satellite.setParent(parent);
            parent.addSatellite(satellite);
            solarSystem.put(parts[0], parent);
            solarSystem.put(parts[1], satellite);
        }
    }

    public int getOrbitCount(String startName) {
        Planet startPlanet = solarSystem.get(startName);
        return getOrbitCount(startPlanet, null);
    }

    public int getOrbitCount(Planet start, Planet end) {
        int iOrbits = 0;

        Planet parent = start.getParent();
        while (parent != null && parent != end) {
            iOrbits++;
            parent = parent.getParent();
        }

        return iOrbits;
    }

    public int getAllOrbitCount() {
        int iOrbits = 0;
        Planet COM = solarSystem.get("COM");

        for (String planetName : solarSystem.keySet()) {
            Planet planet = solarSystem.get(planetName);
            iOrbits += getOrbitCount(planet, null);
        }

        return iOrbits;
    }

    public void listCounts() {
        Map<String, Integer> counts = new HashMap<>();
        int iTotalCount = 0;
        for (String planetName : solarSystem.keySet()) {
            Planet planet = solarSystem.get(planetName);
            if (!counts.containsKey(planetName)) {
                counts.put(planetName, planet.getSatellites().size());
                System.out.println(planetName + ", " + planet.getSatellites().size());
                iTotalCount++;
            } else {
                System.out.println(planetName + " already in there");
            }
        }

        System.out.println("");
        System.out.println("solarSystem Count: " + solarSystem.keySet().size());
        System.out.println("my Count:" + iTotalCount);
    }

    public List<String> getOrbitalChain(String planetName, String end) {
        List<String> chain = new ArrayList<>();

        Planet current = solarSystem.get(planetName);

        while (current != null && current.getParent() != null) {
            current = current.getParent();
            chain.add(current.getPlanetName());
            if (current.getPlanetName() == end) {
                break;
            }
        }

        return chain;
    }

    public int getOrbitalChainLength(String planetName, String end) {
        int iLength = 0;

        Planet current = solarSystem.get(planetName);
        current = current.getParent();

        while (current != null && current.getParent() != null) {
            current = current.getParent();
            iLength++;
            if (current.getPlanetName() == end) {
                break;
            }
        }

        return iLength;
    }

    public String findCommonPlanet(String from, String to) {
        List<String> fromChain = getOrbitalChain(from, "COM");
        List<String> toChain = getOrbitalChain(to, "COM");

        for (int i=0; i<fromChain.size(); i++) {
            String curr = (String)fromChain.toArray()[i];
            if (toChain.contains(curr)) {
                return curr;
            }
        }

        return "";
    }

    public int findOrbitChangeLength(String from, String to) {

        String commonPlanet = findCommonPlanet(from, to);
        return getOrbitalChainLength(from, commonPlanet)
                + getOrbitalChainLength(to, commonPlanet);
    }
}
