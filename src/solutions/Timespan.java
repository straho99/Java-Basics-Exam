package solutions;

import java.util.Scanner;

public class Timespan {

	public static void main(String[] args) {
		// Problem 01:
		Scanner scanner = new Scanner(System.in);
		String[] start = scanner.nextLine().split(":");
		String[] end = scanner.nextLine().split(":");
		int[] startTime=new int[3];
		int[] endTime=new int[3];
		for (int i = 0; i < 3; i++) {
			startTime[i]=Integer.parseInt(start[i]);
			endTime[i]=Integer.parseInt(end[i]);
		}
		int resultHour = startTime[0] - endTime[0];
		int resultMinute=0;
		if (startTime[1]<endTime[1]) {
			resultHour--;
			resultMinute = 60 + (startTime[1] - endTime[1]);
		}
		else {
			resultMinute = startTime[1] - endTime[1];
		}
		int resultSecond=0;
		if (startTime[2]<endTime[2]) {
			resultMinute--;
			resultSecond = 60 + (startTime[2] - endTime[2]);
		}
		else {
			resultSecond = startTime[2] - endTime[2];
		}
		System.out.printf("%d:%02d:%02d", resultHour, resultMinute, resultSecond);
	}
	

}
