package com.sap.calculator.implementations;

public class DoubleCalculator extends IntegerCalculator {

	public double getMultipliedNumbers(double firstNumber, double secondNumber, double thirdNumber) {
		double result = firstNumber * secondNumber * thirdNumber;
		return result;
	}

	public double getMultipliedNumbers(double firstNumber, double secondNumber) {
		double result = firstNumber * secondNumber;
		return result;
	}

	public double getSubstractedNumbers(double firstNumber, double secondNumber) {
		double result = firstNumber - secondNumber;
		return result;
	}

	public double getAddedNumbers(double firstNumber, double secondNumber) {
		double result = firstNumber + secondNumber;
		return result;
	}

}
