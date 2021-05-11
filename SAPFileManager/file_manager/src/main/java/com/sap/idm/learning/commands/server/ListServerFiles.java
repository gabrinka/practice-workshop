package com.sap.idm.learning.commands.server;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.sap.idm.learning.exceptions.FileOperationException;
import com.sap.idm.learning.exceptions.UnexpectedArgumentsException;
import com.sap.idm.learning.file_manager_server.common_objects.Command;
import com.sap.idm.learning.file_manager_server.common_objects.Response;
import com.sap.idm.learning.server.ServerConnection;

public class ListServerFiles extends ServerCommand {
	private static final Logger LOGGER = Logger.getLogger(ListServerFiles.class.getName());

	@Override
	public void execute(final List<String> commandArguments)
			throws FileOperationException, UnexpectedArgumentsException {
		LOGGER.log(Level.FINE, "Command \" listfiles \" invoked with arguments: " + commandArguments + "\n");
		if (commandArguments.size() != 1) {
			throw new UnexpectedArgumentsException(
					"Expected number of arguments: 1, actual: " + commandArguments.size());
		}
		sendRequestToServer(Command.LISTFILES);
		Response response = receiveResponseFromServer();
		boolean isResponseOk = response.isResponsePositive();
		if (isResponseOk) {
			List<String> serverFilesNames = getFilesNames();
			for (String fileName : serverFilesNames) {
				System.out.println(fileName);
			}
		}
	}

	private List<String> getFilesNames() throws FileOperationException {
		List<String> filesList = null;
		try {

			Object receivedObject = ServerConnection.getInSocket().readObject();
			if (receivedObject instanceof List) {
				filesList = (List<String>) receivedObject;
			} else {
				throw new FileOperationException("Read object is of different instance type than used cast!");
			}
		} catch (IOException ioe) {
			throw new FileOperationException("Could not upload file successfully!", ioe);
		} catch (ClassNotFoundException cnfe) {
			LOGGER.log(Level.SEVERE,
					"An error occurred while reading object from Client socket and the server will be disconnected!",
					cnfe);
			ServerConnection.disconnect();
		}
		return filesList;
	}
}