package net.thebyrdnest.aoc.aoc2019;

import java.util.HashMap;

public class Day14 {

    HashMap<String, HashMap<String, Integer>> hmReactions;

    public int solve1(String[] inReactions) {
        int OAR = 0;

        loadReactions(inReactions);
        return OAR;
    }

    public void loadReactions(String[] inReactions) {
        hmReactions = new HashMap<>();

        for (String reaction : inReactions) {
            // # CHEM, # CHEM => # CHEM
            String[] parts = reaction.split("=>");
            String inputs = parts[0];
            String output = parts[1];

            String[] components = inputs.split(",");
            HashMap<String, Integer> hmComponents = new HashMap<>();
            for (String component : components) {
                parts = component.split(" ");
                hmComponents.put(parts[1], Integer.parseInt(parts[0]));
            }

            //parts
        }



    }
}