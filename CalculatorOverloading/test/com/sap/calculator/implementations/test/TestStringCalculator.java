package com.sap.calculator.implementations.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.sap.calculator.exception.StringFomatException;
import com.sap.calculator.implementations.StringCalculator;

public class TestStringCalculator {

	private StringCalculator stringCalculator;

	@Before
	public void setUp() {
		stringCalculator = new StringCalculator();
	}

	@Test
	public void testAddUsingIntegerStrings() throws StringFomatException {
		assertEquals(9, stringCalculator.getAddedNumbers("4", "5"));
	}

	@Test
	public void testSubstractUsingIntegerStrings() throws StringFomatException {
		assertEquals(-1, stringCalculator.getSubstractedNumbers("4", "5"));
	}

	@Test
	public void testMultiplyUsingTwoIntegerStrings() throws StringFomatException {
		assertEquals(20, stringCalculator.getMultipliedNumbers("4", "5"));
	}

	@Test
	public void testMultiplyUsingThreeIntegerStrings() throws StringFomatException {
		assertEquals(40, stringCalculator.getMultipliedNumbers("4", "5", "2"));
	}

	@Test(expected = StringFomatException.class)
	public void testMultiplyUsingInvalidInput() throws StringFomatException {
		stringCalculator.getMultipliedNumbers("", "5", "2");
	}
}
