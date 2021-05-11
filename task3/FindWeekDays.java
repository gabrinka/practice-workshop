package com.sap.intern.task3;

import java.util.Random;

public class FindWeekDays {
	private static final int RANDOM_NUMBERS_COUNT = 8;
	private static String returnDayName(int dayOfTheWeekNumber) {
		switch (dayOfTheWeekNumber) {

		case 1:
			return "Monday";

		case 2:
			return "Tuesday";

		case 3:
			return "Wednesday";

		case 4:
			return "Thursday";

		case 5:
			return "Friday";

		case 6:
			return "Saturday";

		case 7:
			return "Sunday";

		default:
			return "Invalid!";
		}
	}

	public static void main(String[] args) {
		Random random = new Random();

		for (int i = 0; i < RANDOM_NUMBERS_COUNT; i++) {
			int day = random.nextInt(8);
			String resultDay = returnDayName(day);

			System.out.print("Random number: " + day + " and corresponding weekday is " + resultDay + "\n");
		}
	}
}
