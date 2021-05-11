package com.sap.idm.learning.commands;

import java.io.File;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ListFilesCommand extends FileManagerCommand {
	private static final Logger LOGGER = Logger.getLogger(ListFilesCommand.class.getName());

	@Override
	public void execute(final List<String> commandArguments) {
		LOGGER.log(Level.FINE, "Command \" ls \" invoked." + "\n");
		File currentDirectory = new File(ROOT_DIRECTORY);
		File[] filesList = currentDirectory.listFiles();
		for (File file : filesList) {
			System.out.print(file.getName() + " ");
		}
	}
}
