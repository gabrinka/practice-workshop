package com.sap.idm.learning.commands.server;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.sap.idm.learning.exceptions.FileOperationException;
import com.sap.idm.learning.exceptions.UnexpectedArgumentsException;
import com.sap.idm.learning.file_manager_server.common_objects.Command;
import com.sap.idm.learning.file_manager_server.common_objects.Response;
import com.sap.idm.learning.server.ServerConnection;

public class Upload extends ServerCommand {
	private static final Logger LOGGER = Logger.getLogger(Upload.class.getName());
	private File fileToUpload;

	@Override
	public void execute(final List<String> commandArguments)
			throws FileOperationException, UnexpectedArgumentsException {
		LOGGER.log(Level.FINE, "Command \" upload \" invoked with arguments: " + commandArguments + "\n");
		if (commandArguments.size() != 2) {
			throw new UnexpectedArgumentsException(
					"Expected number of arguments: 2, actual: " + commandArguments.size());
		}
		fileToUpload = new File(commandArguments.get(FIRST_ARGUMENT));

		boolean isValidFile = fileToUpload.exists();
		if (isValidFile) {
			String fileName = fileToUpload.getName();
			String fileSize = Long.toString(fileToUpload.length());

			List<String> requestArguments = new ArrayList<>();
			requestArguments.add(fileName);
			requestArguments.add(fileSize);
			sendRequestToServer(Command.UPLOAD, requestArguments);

			Response response = receiveResponseFromServer();
			boolean isResponseOk = response.isResponsePositive();
			if (isResponseOk) {
				uploadFile(ServerConnection.getOutputStream(), fileToUpload.length());
			}
			return;
		}
		throw new FileOperationException("No such file: " + fileToUpload.getName() + " exists!");//TODO:reverse logic
	}

	private void uploadFile(final OutputStream outputStream, long fileSize) throws FileOperationException {
		byte[] buffer = new byte[BUFFER_SIZE];
		try (FileInputStream inputStream = new FileInputStream(fileToUpload)) {
			while (fileSize > 0) {
				int data = inputStream.read(buffer);

				if (data < BUFFER_SIZE) {
					byte[] smallerBuffer = Arrays.copyOf(buffer, data);
					outputStream.write(smallerBuffer);
				} else {
					outputStream.write(buffer);
				}
				fileSize -= data;
			}

			LOGGER.log(Level.INFO,
					"File " + fileToUpload.toString() + " has been successfully uploaded from the server!" + "\n");
			System.out.println(SUCCESSFUL_OPERATION_MSG);
		} catch (IOException ioe) {
			throw new FileOperationException("Could not upload file successfully!", ioe);
		}
	}
}
