package com.sap.idm.learning.commands.server;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
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

public class Download extends ServerCommand {
	private static final Logger LOGGER = Logger.getLogger(Download.class.getName());
	private File fileToDownload;

	@Override
	public void execute(final List<String> commandArguments)
			throws FileOperationException, UnexpectedArgumentsException {
		LOGGER.log(Level.FINE, "Command \" download \" invoked with arguments: " + commandArguments + "\n");
		if (commandArguments.size() != 2) {
			throw new UnexpectedArgumentsException(
					"Expected number of arguments: 2, actual: " + commandArguments.size());
		}
		String fileName = commandArguments.get(FIRST_ARGUMENT);
		fileToDownload = new File(fileName);
		List<String> requestArguments = new ArrayList<>();
		requestArguments.add(fileName);

		sendRequestToServer(Command.DOWNLOAD, requestArguments);
		Response response = receiveResponseFromServer();

		boolean isResponseOk = response.isResponsePositive();
		if (isResponseOk) {
			long fileSize = Long.parseLong(response.getResponseDetails().get(0));
			downloadFile(ServerConnection.getInputStream(), fileSize);
		} // TODO:else print negative message
	}

	private void downloadFile(final InputStream inputStream, long fileSize) throws FileOperationException {

		byte[] buffer = new byte[BUFFER_SIZE];

		try (FileOutputStream outputStream = new FileOutputStream(fileToDownload)) {
			while (fileSize > 0) {
				long data = inputStream.read(buffer);
				if (data < BUFFER_SIZE) {
					byte[] smallerBuffer = Arrays.copyOf(buffer, (int) data);
					outputStream.write(smallerBuffer);
					//Files.write(fileToDownload.toPath(), smallerBuffer, StandardOpenOption.APPEND);
				} else {
					outputStream.write(buffer);
					//Files.write(fileToDownload.toPath(), buffer, StandardOpenOption.APPEND);
				}
				fileSize -= data;
			}

			LOGGER.log(Level.INFO,
					"File " + fileToDownload.toString() + " has been successfully downloaded from the server!" + "\n");
			System.out.println(SUCCESSFUL_OPERATION_MSG);
		} catch (IOException ioe) {
			throw new FileOperationException("Could not download file successfully!", ioe);
		}
	}
}
