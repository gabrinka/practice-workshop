package com.sap.idm.learning.commands;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.sap.idm.learning.exceptions.FileOperationException;
import com.sap.idm.learning.exceptions.UnexpectedArgumentsException;

public class CreateEmptyFileCommand extends FileManagerCommand {
	private static final Logger LOGGER = Logger.getLogger(CreateEmptyFileCommand.class.getName());

	@Override
	public void execute(final List<String> commandArguments)
			throws FileOperationException, UnexpectedArgumentsException {
		LOGGER.log(Level.FINE, "Command \" mkfile \" invoked with arguments: " + commandArguments + "\n");
		if (commandArguments.size() != 2) {
			throw new UnexpectedArgumentsException(
					"Expected number of arguments: 2, actual: " + commandArguments.size());
		}

		Path filePath = Paths.get(commandArguments.get(FIRST_ARGUMENT));
		try {
			Files.createFile(filePath);
			LOGGER.log(Level.INFO, "Successful creation of the file: " + filePath + "\n");
		} catch (IOException ioe) {
			throw new FileOperationException(
					"Creation of file: " + commandArguments.get(FIRST_ARGUMENT) + " was unsuccessful!", ioe);
		}
		
		System.out.println(SUCCESSFUL_OPERATION_MSG);
	}
}
