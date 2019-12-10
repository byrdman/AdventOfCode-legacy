package net.thebyrdnest.aoc.aoc2015;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.*;

public class Day13 {
    class Person {
        private String person_name;
        private Map<String, Integer> happynessChange;

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
    public ArrayList<String> allGuests;
    public Set<String> allTables;
    public Map<String, String> nameMap;

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

        nameMap = new HashMap<>();
        allGuests = new ArrayList<>();
        for (String guestName : guests.keySet()) {
            allGuests.add(guestName);
            nameMap.put(guestName.substring(0, 1), guestName);
        }
    }

    public int calcHappyness(String table) {
        int happynessIndex = 0;
        for (int i=0; i < table.length()-1; i++) {
            String personName = nameMap.get(table.substring(i, i+1));
            Person person1 = guests.get(personName);
            Person person2 = guests.get(nameMap.get(table.substring(i+1, i+2)));

            happynessIndex += person2.getHappynessChange(personName);
            happynessIndex += person1.getHappynessChange(person2.getPerson_name());
        }

        Person person1 = guests.get(nameMap.get(table.substring(table.length()-1, table.length())));
        Person person2 = guests.get(nameMap.get(table.substring(0, 1)));
        happynessIndex += person1.getHappynessChange(person2.getPerson_name());
        happynessIndex += person2.getHappynessChange(person1.getPerson_name());

        return happynessIndex;
    }

     void Permutation(String str, String ans)
    {
        // If string is empty
        if (str.length() == 0) {

            // Add the generated permutation to the
            // set in order to avoid duplicates
            allTables.add(ans);
            return;
        }

        for (int i = 0; i < str.length(); i++) {

            // ith character of str
            char ch = str.charAt(i);

            // Rest of the string after excluding
            // the ith character
            String ros = str.substring(0, i)
                    + str.substring(i + 1);

            // Recurvise call
            Permutation(ros, ans + ch);
        }
    }

    public void buildAllTables(ArrayList<String> allGuests) {
        String sGuests = "";
        for (String guestName : allGuests) {
            sGuests += guestName.substring(0, 1);
        }

        Permutation(sGuests, "");
    }

    public int solve1() {
        allTables = new HashSet<>();
        nameMap = new HashMap<>();

        ArrayList<String> allGuests = new ArrayList<>();
        for (String guestName : guests.keySet()) {
            allGuests.add(guestName);
            nameMap.put(guestName.substring(0, 1), guestName);
        }

        buildAllTables(allGuests);

        int maxHappyness = 0;
        for (String table : allTables) {
            int happyness = calcHappyness(table);
            if (happyness > maxHappyness)
                maxHappyness = happyness;

            //printTable(table);
        }

        return maxHappyness;
    }

    public int solve2() {
        allTables = new HashSet<>();
        nameMap = new HashMap<>();

        ArrayList<String> allGuests = new ArrayList<>();
        for (String guestName : guests.keySet()) {
            allGuests.add(guestName);
            nameMap.put(guestName.substring(0, 1), guestName);
        }

        buildAllTables(allGuests);

        int maxHappyness = 0;
        for (String table : allTables) {
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
}
