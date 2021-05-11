package errorimplementations;

public class OutOfMemoryErrorSimulator extends ErrorSimulator {

	@Override
	void simulateError() {
		int arraySize = 1000000;
		String[] fillMemory = new String[arraySize];
		System.out.println("Available memory (in bytes): " + Runtime.getRuntime().freeMemory());

		/*
		 * while (true) { System.out.println("Available memory (in bytes): " +
		 * Runtime.getRuntime().freeMemory()); int[] fillMemory = new int[arraySize];
		 * arraySize = arraySize * 5; }
		 */
	}

}
