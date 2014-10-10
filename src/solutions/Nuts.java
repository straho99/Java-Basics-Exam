package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class Nuts {

	public static void main(String[] args) {
		// Problem 04:
		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());
		TreeMap<String, HashMap<String, Integer>> sortedOrders = new TreeMap<>();
		HashMap<String, ArrayList<String>> unsortedOrders = new HashMap<>();
		
		for (int i = 0; i < n; i++) {
			String[] row = scanner.nextLine().split(" ");
			String company = row[0];
			String nut = row[1];
			int quantity = Integer.parseInt(row[2].substring(0, row[2].length() - 2));
			if (sortedOrders.containsKey(company)) {
				if (sortedOrders.get(company).containsKey(nut)) {
					sortedOrders.get(company).put(nut, sortedOrders.get(company).get(nut) + quantity);
				}
				else {
					sortedOrders.get(company).put(nut, quantity);
					unsortedOrders.get(company).add(nut);
				}
			}
			else {
				HashMap<String, Integer> newNut = new HashMap<>();
				newNut.put(nut, quantity);
				sortedOrders.put(company, newNut);
				ArrayList<String> nuts = new ArrayList<>();
				nuts.add(nut);
				unsortedOrders.put(company, nuts);
			}
		}
		String output="";
		for (String companyName : sortedOrders.keySet()) {
			output = companyName + ": ";
			for (String nut : unsortedOrders.get(companyName)) {
				output = output + String.format("%s-%dkg, ", nut, sortedOrders.get(companyName).get(nut));
			}
			output= output.substring(0, output.length() - 2);
			System.out.println(output);
		}
	}

}
