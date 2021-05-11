package com.sap.idm.learning.commands;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.sap.idm.learning.exceptions.FileOperationException;

public class ShowPropertiesCommand extends FileManagerCommand {
	private static final String FILE_EXTENSION_DELIMITER = ".";
	private static final Logger LOGGER = Logger.getLogger(ShowPropertiesCommand.class.getName());

	@Override
	public void execute(final List<String> commandArguments) throws FileOperationException {
		LOGGER.log(Level.FINE, "Command \" properties \" invoked with arguments: " + commandArguments + "\n");
		Path filePath = Paths.get(commandArguments.get(FIRST_ARGUMENT));
		if (!Files.exists(filePath)) {
			throw new FileOperationException("File: " + filePath + " does not exist!");
		}
		try {
			if (Files.isDirectory(filePath)) {
				System.out.println("Directory: " + filePath.toAbsolutePath());
			} else {
				printFileProperties(filePath);
			}
		} catch (IOException ioe) {
			throw new FileOperationException("File: " + filePath + " cannot be processed!", ioe);
		}

		System.out.println(SUCCESSFUL_OPERATION_MSG);
	}

	private void printFileProperties(final Path filePath) throws IOException {
		long size = Files.size(filePath);
		System.out.println(size + " bytes");
		System.out.println(filePath);

		Optional<String> fileExtension = getFileExtension(filePath);
		fileExtension.ifPresent(System.out::println);
	}

	private Optional<String> getFileExtension(final Path filePath) {
		return Optional.ofNullable(filePath.toString()).filter(file -> file.contains(FILE_EXTENSION_DELIMITER))
				.map(file -> file.substring(filePath.toString().lastIndexOf(FILE_EXTENSION_DELIMITER) + 1));
	}
}