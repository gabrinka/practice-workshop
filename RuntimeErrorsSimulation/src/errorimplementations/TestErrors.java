package errorimplementations;

public class TestErrors {

	public static void main(String[] args) {
		System.out.println("Simulating StackOverflow Error:");
		simulateStackOverflowError();
		
		System.out.println("Simulating OutOfMemory Error:");
		simulateOutOfMemoryError();
	}

	private static void simulateOutOfMemoryError() {
		ErrorSimulator outOfMemoryErrorSimulator = new OutOfMemoryErrorSimulator();
		outOfMemoryErrorSimulator.simulateError();
	}

	private static void simulateStackOverflowError() {
		ErrorSimulator stackOverflowErrorSimulator = new StackOverflowErrorSimulator();
		stackOverflowErrorSimulator.simulateError();
	}
}
