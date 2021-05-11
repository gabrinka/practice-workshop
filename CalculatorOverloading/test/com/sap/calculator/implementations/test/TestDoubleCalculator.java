package com.sap.calculator.implementations.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.sap.calculator.implementations.DoubleCalculator;

public class TestDoubleCalculator {
	private final static double DELTA = 0.0000000001;
	 private DoubleCalculator doubleCalculator;

		@Before
		public void setUp() {
			doubleCalculator = new DoubleCalculator();
		}

		@Test
		public void testAddUsingDoubles() {
			assertEquals(9.4, doubleCalculator.getAddedNumbers(4.2, 5.2),DELTA);
		}

		@Test
		public void testSubstractUsingDoubles() {
			assertEquals(-0.6, doubleCalculator.getSubstractedNumbers(4.6, 5.2),DELTA);
		}

		@Test
		public void testMultiplyUsingTwoDoubles() {
			assertEquals(8.4, doubleCalculator.getMultipliedNumbers(4.2, 2),DELTA);
		}

		@Test
		public void testMultiplyUsingThreeDoubles() {
			assertEquals(40, doubleCalculator.getMultipliedNumbers(4, 5, 2));
		}
}
