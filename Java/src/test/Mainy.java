package test;


import java.util.*;

public class Mainy {
    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();
        map.put("Shravan", 3);
        map.put("Manoj", 1);
        map.put("Rahul", 5);


        // Convert to TreeMap with descending order
        TreeMap<String, Integer> sortedMap = new TreeMap<>(Collections.reverseOrder());
        sortedMap.putAll(map);

        // Display
        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}

