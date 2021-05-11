package com.sap.calculator.implementations.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.sap.calculator.implementations.IntegerCalculator;

public class TestIntegerCalculator {
	private IntegerCalculator intCalculator;

	@Before
	public void setUp() {
		intCalculator = new IntegerCalculator();
	}

	@Test
	public void testAddUsingIntegers() {
		assertEquals(9, intCalculator.getAddedNumbers(4, 5));
	}

	@Test
	public void testSubstractUsingIntegers() {
		assertEquals(-1, intCalculator.getSubstractedNumbers(4, 5));
	}

	@Test
	public void testMultiplyUsingTwoIntegers() {
		assertEquals(20, intCalculator.getMultipliedNumbers(4, 5));
	}

	@Test
	public void testMultiplyUsingThreeIntegers() {
		assertEquals(40, intCalculator.getMultipliedNumbers(4, 5, 2));
	}
}
