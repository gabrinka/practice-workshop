package com.sap.idm.learning.commands.server;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.sap.idm.learning.commands.FileManagerCommand;
import com.sap.idm.learning.exceptions.FileOperationException;
import com.sap.idm.learning.exceptions.UnexpectedArgumentsException;
import com.sap.idm.learning.server.ServerConnection;

public class Connect extends FileManagerCommand {
	private static final Logger LOGGER = Logger.getLogger(Connect.class.getName());

	@Override
	public void execute(final List<String> commandArguments)
			throws FileOperationException, UnexpectedArgumentsException {
		LOGGER.log(Level.FINE, "Command \" connect \" invoked with arguments: " + commandArguments + "\n");
		if (commandArguments.size() != 3) {
			throw new UnexpectedArgumentsException("Expected number of arguments: 3, actual: " + commandArguments.size());
		}

		String host = commandArguments.get(FIRST_ARGUMENT);
		int port = validatePort(commandArguments.get(SECOND_ARGUMENT));

		ServerConnection connection = new ServerConnection(port, host);
		connection.connect();
	}

	private int validatePort(final String port) throws FileOperationException {
		int resultPort;
		try {
			resultPort = Integer.parseInt(port);
		} catch (NumberFormatException nfe) {
			throw new FileOperationException("Invalid format of port!Cannot connect with server!", nfe);
		}
		return resultPort;
	}
}
