package net.thebyrdnest.aoc.aoc2015;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day13 {
    class Person {
        private String person_name;
        private int happyness;
        private Map<String, Integer> happynessChange;
        private String leftNeighbor;
        private String rightNeighbor;

        public Person(String person_name) {
            this.person_name = person_name;
            happynessChange = new HashMap<>();
        }

        public String getPerson_name() {
            return person_name;
        }

        public void addHappynessChange(String neighbor, int happinessUnits) {
            happynessChange.put(neighbor, happinessUnits);
        }

        public int getHappynessChange(String neighbor) {
            return happynessChange.get(neighbor);
        }
    }

    /*
    0 - name
    2 - gain/lose
    3 - units
    10 - neighbor
    Alice would gain 54 happiness units by sitting next to Bob.
Alice would lose 79 happiness units by sitting next to Carol.
Alice would lose 2 happiness units by sitting next to David.
Bob would gain 83 happiness units by sitting next to Alice.
Bob would lose 7 happiness units by sitting next to Carol.
Bob would lose 63 happiness units by sitting next to David.
Carol would lose 62 happiness units by sitting next to Alice.
Carol would gain 60 happiness units by sitting next to Bob.
Carol would gain 55 happiness units by sitting next to David.
David would gain 46 happiness units by sitting next to Alice.
David would lose 7 happiness units by sitting next to Bob.
David would gain 41 happiness units by sitting next to Carol.
     */
    public Map<String, Person> guests = new HashMap<>();

    public void loadData(String[] list) {
        for (String record : list) {
            String[] parts = record.split(" ");
            Person guest = guests.get(parts[0]);
            if (guest == null) {
                guest = new Person(parts[0]);
            }
            if (parts[2].equalsIgnoreCase("gain"))
                guest.addHappynessChange(parts[10].substring(0, parts[10].length()-1), Integer.parseInt(parts[3]));
            else
                guest.addHappynessChange(parts[10].substring(0, parts[10].length()-1), 0 - Integer.parseInt(parts[3]));
            guests.put(parts[0], guest);
        }
    }



    public int calcHappyness(ArrayList<String> table) {
        int happynessIndex = 0;
        for (int i=0; i < table.size()-1; i++) {
            String personName = table.get(i);
            Person person1 = guests.get(personName);
            Person person2 = guests.get(table.get(i+1));

            happynessIndex += person2.getHappynessChange(personName);
            happynessIndex += person1.getHappynessChange(person2.getPerson_name());
        }

        Person person1 = guests.get(table.get(table.size()-1));
        Person person2 = guests.get(table.get(0));
        happynessIndex += person1.getHappynessChange(person2.getPerson_name());
        happynessIndex += person2.getHappynessChange(person1.getPerson_name());

        return happynessIndex;
    }

    public int solve1() {
        ArrayList<String> allGuests = new ArrayList<>();
        for (String guestName : guests.keySet())
            allGuests.add(guestName);

        buildAllTables(allGuests, 0, guests.size()-1);

        int maxHappyness = 0;
        for (ArrayList<String> table : allTables) {
            int happyness = calcHappyness(table);
            if (happyness > maxHappyness)
                maxHappyness = happyness;

            //printTable(table);
        }

        return maxHappyness;
    }

    public StringBuilder printTable(ArrayList<String> table) {
        StringBuilder sb = new StringBuilder();
        boolean bFirst = true;
        for (String guestName : table) {
            if (bFirst)
                bFirst = false;
            else
                sb.append(", ");

            sb.append(guestName);
        }

        return sb;
    }


    public ArrayList<ArrayList<String >> allTables = new ArrayList<>();

    public void buildAllTables(ArrayList<String> guests, int left, int right) {

        if (left == right) {
            allTables.add(guests);
        } else {
            for (int i=left; i <= right; i++) {
                guests = swap(guests, left, right);
                buildAllTables(guests, left+1, right);
            }
        }
    }

    public ArrayList<String> swap(ArrayList<String> oldArray, int i, int j)
    {
        ArrayList<String> newArray = new ArrayList<>();
        for (int k=0; k < oldArray.size(); k++) {
            if (k == i)
                newArray.add(oldArray.get(j));
            else if (k == j)
                newArray.add(oldArray.get(i));
            else
                newArray.add(oldArray.get(k));
        }

        return newArray;
    }
}
