package com.sap.intern.task10;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class CalculateDates {
	private static final DateFormat VALID_DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");

	public static void main(String[] args) {
		boolean isValid = validateInput(args);
		if (!isValid) {
			System.exit(0);
		}

		String userInputFOne = args[0];
		String userInputTwo = args[1];

		VALID_DATE_FORMAT.setLenient(false);
		Date first = null;
		Date second = null;

		try {
			first = VALID_DATE_FORMAT.parse(userInputFOne);
			second = VALID_DATE_FORMAT.parse(userInputTwo);
		} catch (ParseException pe) {
			System.out.println("Dates could not be parsed: " + pe.getMessage());
			System.exit(0);
		}

		long numberOfDaysBetweenDates = getDaysBetweenDates(first, second);
		System.out.println("Number of days between dates is " + numberOfDaysBetweenDates);
	}

	private static boolean validateInput(String[] args) {

		if (args == null) {
			System.out.println("No arguments passed!");
			return false;
		}

		else if (args.length != 2) {
			System.out.println("Invalid number of arguments! Expected arguments are two dates!");
			return false;
		}
		return true;
	}

	private static long getDaysBetweenDates(final Date firstDate, final Date secondDate) {
		long differenceBetweenDates = Math.abs(firstDate.getTime() - secondDate.getTime());

		return TimeUnit.DAYS.convert(differenceBetweenDates, TimeUnit.MILLISECONDS);
	}

}
