

import java.io.File;
import java.util.Scanner;

import com.sap.filemanager.exception.OperationException;
import com.sap.filemanager.factory.FileManagerFactory;
import com.sap.filemanager.operations.AbstractOperation;

public class testOperations {
	private static Scanner scanner = new Scanner(System.in);


	public static void main(String[] args) throws OperationException {
		System.out.println("Please input a command: Create empty file, Create directory or Delete file:");
		String command = scanner.nextLine();

		System.out.println("Please input file path:");
		String filePath = scanner.nextLine();

		File file = new File(filePath);
		FileManagerFactory operationFactory = new FileManagerFactory();
		AbstractOperation operation = operationFactory.getOperation(command);
		if (operation == null) {
			System.out.println("Invalid file operation!");
		} else {
			operation.execute(file);
		}

	}
}
