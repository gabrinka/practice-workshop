package com.sap.idm.learning.commands;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.sap.idm.learning.exceptions.FileOperationException;
import com.sap.idm.learning.exceptions.UnexpectedArgumentsException;

public class CopyFileCommand extends FileManagerCommand {
	private static final Logger LOGGER = Logger.getLogger(CopyFileCommand.class.getName());
private String fileSource;
private String fileDestination;
	public CopyFileCommand() {
		
	}

	@Override
	public void execute(final List<String> commandArguments)
			throws FileOperationException, UnexpectedArgumentsException {
		LOGGER.log(Level.FINE, "Command \" copy \" invoked with arguments: " + commandArguments + "\n");
		if (commandArguments.size() != 3) {
			throw new UnexpectedArgumentsException(
					"Expected number of arguments: 3, actual: " + commandArguments.size());
		}

		String fileSource = commandArguments.get(FIRST_ARGUMENT);
		String fileDestination = commandArguments.get(SECOND_ARGUMENT);

		try {
			Files.copy(Paths.get(fileSource), Paths.get(fileDestination));
		} catch (IOException ioe) {
			throw new FileOperationException("Could not copy: " + fileSource + " successfully!", ioe);
		}

		LOGGER.log(Level.INFO, "Successful copy of " + fileSource + " to " + fileDestination + "\n");
		System.out.println(SUCCESSFUL_OPERATION_MSG);
	}
}
