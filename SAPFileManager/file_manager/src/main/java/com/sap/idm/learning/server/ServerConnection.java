package com.sap.idm.learning.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.sap.idm.learning.exceptions.FileOperationException;

public class ServerConnection {
	private static final Logger LOGGER = Logger.getLogger(ServerConnection.class.getName());
	private int port;
	private static boolean isConnected;
	private String host;
	private static Socket connection;
	private static ObjectInputStream inSocket;
	private static ObjectOutputStream outSocket;
	private static InputStream input;
	private static OutputStream output;

	public ServerConnection(int port, final String host) {
		this.port = port;
		this.host = host;
	}

	public void connect() throws FileOperationException {
		try {
			if (isConnected) {
				LOGGER.log(Level.WARNING, "Already connected to a server!" + "\n");
				System.out.println("Already connected to a server!");
				return;
			}

			connection = new Socket(host, port);
			isConnected = true;
			LOGGER.log(Level.INFO, "Successfully connected to server: host:" + host + " port:" + port + "\n");
			System.out.println("Successfully connected to server!");
			setDataTransferStreams();

		} catch (IOException ioe) {
			throw new FileOperationException("Can't connect to surver: " + host + " successfully!", ioe);
		}
	}

	public static boolean isConnected() {
		return isConnected;
	}

	public static ObjectInputStream getInSocket() {
		return inSocket;
	}

	public static ObjectOutputStream getOutSocket() {
		return outSocket;
	}

	public static InputStream getInputStream() {
		return input;
	}

	public static OutputStream getOutputStream() {
		return output;
	}

	private void setDataTransferStreams() throws FileOperationException {
		try {
			output = connection.getOutputStream();
			input = connection.getInputStream();
			outSocket = new ObjectOutputStream(output);
			inSocket = new ObjectInputStream(input);
		} catch (IOException ioe) {
			throw new FileOperationException("Could not parse data successfully!", ioe);
		}
	}

	public static void disconnect() throws FileOperationException {
		try {
			if (isConnected) {
				connection.close();
				isConnected = false;
				LOGGER.log(Level.INFO, "Successfully disconnected!" + "\n");
				System.out.println("Succesffully disconnected from server!");
			} else {
				LOGGER.log(Level.WARNING, "Cannot disconnect from server since connection was not established!" + "\n");
				System.out.println("Unsuccessful operation!");
			}
		} catch (SocketException se) {
			throw new FileOperationException(
					" Cannot close the connection because there are unfinished I/O operations!", se);
		} catch (IOException ioe) {
			throw new FileOperationException("Cannot close the socket successfully!", ioe);
		}
	}
}
