package solutions;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WeirdStrings {

	public static void main(String[] args) {
		// Problem 03:
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		String clearedJunk = "";
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i)=='\\' || input.charAt(i)=='/' || input.charAt(i)=='(' || input.charAt(i)==')' ||  
					input.charAt(i)=='|' || input.charAt(i)==' ') {
				continue;
			}
			else {
				clearedJunk = clearedJunk + input.charAt(i);
			}
		}
		//System.out.println(clearedJunk);
		ArrayList<String> words = new ArrayList<>();
		String regExpression = "[a-zA-Z]+";
		Pattern wordPattern = Pattern.compile(regExpression);
		Matcher wordMatcher=wordPattern.matcher(clearedJunk);
		while (wordMatcher.find()) {
			words.add(wordMatcher.group());
			//System.out.println(wordMatcher.group());
		}
		//System.out.println(calculateWeight("Z"));
		int maxWeight=0;
		int index=0;
		for (int i = 1; i < words.size(); i++) {
			int currentWeight=calculateWeight(words.get(i-1)) + calculateWeight(words.get(i));
			if (currentWeight >= maxWeight) {
				maxWeight = currentWeight;
				index=i;
			}
		}
		System.out.println(words.get(index - 1));
		System.out.println(words.get(index));
	}
	
	public static int calculateWeight(String word){
		String lowerCaseWord=word.toLowerCase();
		int weight=0;
		for (int i = 0; i < lowerCaseWord.length(); i++) {
			weight += (int)(lowerCaseWord.charAt(i) - 96);
		}
		
		return weight;
	}

}
