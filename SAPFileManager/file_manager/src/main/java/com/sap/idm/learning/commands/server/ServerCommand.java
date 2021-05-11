package com.sap.idm.learning.commands.server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.sap.idm.learning.commands.FileManagerCommand;
import com.sap.idm.learning.exceptions.FileOperationException;
import com.sap.idm.learning.file_manager_server.common_objects.Request;
import com.sap.idm.learning.file_manager_server.common_objects.Response;
import com.sap.idm.learning.server.ServerConnection;
import com.sap.idm.learning.file_manager_server.common_objects.Command;

public abstract class ServerCommand extends FileManagerCommand {
	private static final Logger LOGGER = Logger.getLogger(ServerCommand.class.getName());
	public static final int BUFFER_SIZE = 1024 * 1024 * 80;

	public void sendRequestToServer(final Command requestCommand) throws FileOperationException {

		sendRequestToServer(requestCommand, new ArrayList<>());
	}

	public void sendRequestToServer(final Command requestCommand, final List<String> requestArgument)
			throws FileOperationException {
		if (ServerConnection.isConnected()) {//reverse logic first check if disconnected
			Request uploadRequest = new Request(requestCommand, requestArgument);
			try {
				ServerConnection.getOutSocket().writeObject(uploadRequest);
				ServerConnection.getOutSocket().flush();
				LOGGER.log(Level.FINER,
						"Successfully sent a request to the server for command execution: " + requestArgument + "\n");
			} catch (IOException ioe) {
				throw new FileOperationException("Cannot send Request to Server properly!", ioe);
			}
			return;
		}

		throw new FileOperationException("Cannot start operation because there is no connection with the server!");
	}

	public Response receiveResponseFromServer() throws FileOperationException {
		Response responseFromServer = null;
		try {
			responseFromServer = (Response) ServerConnection.getInSocket().readObject();
			LOGGER.log(Level.FINER, "Received a response from server: " + responseFromServer + "\n");
		
			return responseFromServer;
		} catch (ClassNotFoundException cnfe) {
			LOGGER.log(Level.SEVERE,
					"An error occurred while processing the response from the server and connection with the server will be ceased!",
					cnfe);
			ServerConnection.disconnect();
		} catch (IOException ioe) {
			throw new FileOperationException("Cannot read Response from Server properly!", ioe);
		}
		return responseFromServer;

	}
}
