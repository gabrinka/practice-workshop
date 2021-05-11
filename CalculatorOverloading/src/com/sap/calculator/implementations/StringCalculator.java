package com.sap.calculator.implementations;

import com.sap.calculator.exception.StringFomatException; //dont need it

public class StringCalculator extends IntegerCalculator {//better to use composition

	public int getMultipliedNumbers(final String firstNumber, final String secondNumber, final String thirdNumber)
			throws StringFomatException {
		try {
			int result = Integer.valueOf(firstNumber) * Integer.valueOf(secondNumber) * Integer.valueOf(thirdNumber);
			return result;
		} catch (NumberFormatException nfe) {
			throw new StringFomatException("String number has invalid format!", nfe);
		}
	}

	public int getMultipliedNumbers(final String firstNumber, final String secondNumber) throws StringFomatException {
		try {
			int result = Integer.valueOf(firstNumber) * Integer.valueOf(secondNumber);
			return result;
		} catch (NumberFormatException nfe) {
			throw new StringFomatException("String number has invalid format!", nfe);
		}
	}

	public int getSubstractedNumbers(final String firstNumber, final String secondNumber) throws StringFomatException {
		try {
			int result = Integer.valueOf(firstNumber) - Integer.valueOf(secondNumber);
			return result;
		} catch (NumberFormatException nfe) {
			throw new StringFomatException("String number has invalid format!", nfe);
		}
	}

	public int getAddedNumbers(final String firstNumber, final String secondNumber) throws StringFomatException {
		try {
			int result = Integer.valueOf(firstNumber) + Integer.valueOf(secondNumber);
			return result;
		} catch (NumberFormatException nfe) {
			throw new StringFomatException("String number has invalid format!", nfe);
		}
	}
}
