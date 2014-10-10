package solutions;

import java.util.ArrayList;
import java.util.Scanner;

public class MagicSum {

	public static void main(String[] args) {
		// Problem 02:
		Scanner scanner = new Scanner(System.in);
		int divider=Integer.parseInt(scanner.nextLine());
		ArrayList<Integer> numbers = new ArrayList<>();
		String input=scanner.nextLine();
		while (!input.equals("End")) {
			numbers.add(Integer.parseInt(input));
			input=scanner.nextLine();
		} 
		int maxSum=Integer.MIN_VALUE;
		String combination="";
		int count = 0;
		for (int i = 0; i < numbers.size() - 2; i++) {
			for (int j = i + 1; j < numbers.size() - 1; j++) {
				for (int j2 = j + 1; j2 < numbers.size(); j2++) {
					int currentSum = numbers.get(i) + numbers.get(j) + numbers.get(j2);
					if (currentSum % divider == 0 && currentSum > maxSum) {
						maxSum = currentSum;
						combination = String.format("(%d + %d + %d) %% %d = 0", numbers.get(i), numbers.get(j), numbers.get(j2), divider);
						count++;
					}
				}
			}
		}
		if (count>0) {
			System.out.println(combination);
		}
		else {
			System.out.println("No");
		}
	}

}
