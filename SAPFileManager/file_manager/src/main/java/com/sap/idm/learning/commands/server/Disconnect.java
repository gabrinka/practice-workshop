package com.sap.idm.learning.commands.server;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.sap.idm.learning.exceptions.FileOperationException;
import com.sap.idm.learning.file_manager_server.common_objects.Command;
import com.sap.idm.learning.server.ServerConnection;

public class Disconnect extends ServerCommand {
	private static final Logger LOGGER = Logger.getLogger(Disconnect.class.getName());
	@Override
	public void execute(final List<String> commandArguments) throws FileOperationException {
		LOGGER.log(Level.FINE, "Command \" disconnect \" invoked."  + "\n");
		sendRequestToServer(Command.DISCONNECT);
		ServerConnection.disconnect();
		
	}
}
