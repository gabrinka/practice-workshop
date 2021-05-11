package com.sap.idm.learning.commands;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.sap.idm.learning.exceptions.FileOperationException;
import com.sap.idm.learning.exceptions.UnexpectedArgumentsException;

public class MoveFileCommand extends FileManagerCommand {
	private static final Logger LOGGER = Logger.getLogger(MoveFileCommand.class.getName());
	@Override
	public void execute(final List<String> commandArguments) throws FileOperationException, UnexpectedArgumentsException {
		LOGGER.log(Level.FINE, "Command \" move \" invoked with arguments: " + commandArguments + "\n");
		if (commandArguments.size() != 3) {
			throw new UnexpectedArgumentsException("Expected number of arguments: 3, actual: " + commandArguments.size());
		}

		Path source = Paths.get(commandArguments.get(FIRST_ARGUMENT));
		Path target = Paths.get(commandArguments.get(SECOND_ARGUMENT));

		try {
			Files.move(source, target.resolve(source.getFileName()),StandardCopyOption.REPLACE_EXISTING);
			LOGGER.log(Level.INFO,"Successfully moved the file: " + source.toString() + " to " + target.toString() + "\n");
		} catch (IOException ioe) {
			throw new FileOperationException("Moving " + source + " was unsuccessful" , ioe);
		}
		
		System.out.println(SUCCESSFUL_OPERATION_MSG);
	}
}
