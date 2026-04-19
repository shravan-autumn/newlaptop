package test;

import java.util.*;

public class SortMapDescending {
	public static void main(String[] args) {

		// Map<String, Integer>
		Map<String, Integer> empMap = new HashMap<>();

		empMap.put("Shravan", 102);
		empMap.put("Rahul", 205);
		empMap.put("Anita", 150);
		empMap.put("Kiran", 50);

		System.out.println("Before Sorting: " + empMap);

		// ---- SORTING IN DESCENDING ORDER BASED ON ID ----
		List<Map.Entry<String, Integer>> list = new ArrayList<>(empMap.entrySet());

		list.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue())); // descending

		// ---- DISPLAY RESULT ----
		System.out.println("\nAfter Sorting (Descending by ID):");
		for (Map.Entry<String, Integer> entry : list) {
			System.out.println("Name: " + entry.getKey() + "   ID: " + entry.getValue());
		}
	}
}
