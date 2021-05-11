package errorimplementations;

public class StackOverflowErrorSimulator extends ErrorSimulator {

	@Override
	void simulateError() {
		System.out.println("Is this the real life?");
		simulateError();
	}
}
