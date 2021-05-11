package com.sap.idm.learning.commands;

import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.sap.idm.learning.exceptions.FileOperationException;
import com.sap.idm.learning.exceptions.UnexpectedArgumentsException;

public class DeleteFileCommand extends FileManagerCommand {
	private static final Logger LOGGER = Logger.getLogger(DeleteFileCommand.class.getName());

	@Override
	public void execute(final List<String> commandArguments)
			throws FileOperationException, UnexpectedArgumentsException {
		LOGGER.log(Level.FINE, "Command \" delete \" invoked with arguments: " + commandArguments + "\n");
		if (commandArguments.size() != 2) {
			throw new UnexpectedArgumentsException(
					"Expected number of arguments: 2, actual: " + commandArguments.size());
		}
		String filePath = commandArguments.get(FIRST_ARGUMENT);
		Path pathToFile = Paths.get(filePath);
		try {
			Files.delete(pathToFile);
			LOGGER.log(Level.INFO, "Successful deletion of " + filePath + "\n");
		} catch (DirectoryNotEmptyException dnee) {
			throw new FileOperationException("Directory " + filePath + " must be empty in order to be deleted!", dnee);
		} catch (IOException ioe) {
			throw new FileOperationException("Deletion of file: " + filePath + " was unsuccessful!", ioe);
		}

		System.out.println(SUCCESSFUL_OPERATION_MSG);
	}
}
