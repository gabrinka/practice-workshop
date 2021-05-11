package com.sap.calculator.implementations;

public class IntegerCalculator {
	public int getMultipliedNumbers(int firstNumber, int secondNumber, int thirdNumber) {
		int result = firstNumber * secondNumber * thirdNumber;
		return result;
	}

	public int getMultipliedNumbers(int firstNumber, int secondNumber) {
		int result = firstNumber * secondNumber;
		return result;
	}

	public int getSubstractedNumbers(int firstNumber, int secondNumber) {
		int result = firstNumber - secondNumber;
		return result;
	}

	public int getAddedNumbers(int firstNumber, int secondNumber) {
		int result = firstNumber + secondNumber;
		return result;
	}
}
