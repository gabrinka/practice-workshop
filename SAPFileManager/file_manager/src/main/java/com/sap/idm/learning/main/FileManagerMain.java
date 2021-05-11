
package com.sap.idm.learning.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sap.idm.learning.commands.CommandType;
import com.sap.idm.learning.commands.FileManagerCommand;
import com.sap.idm.learning.exceptions.FileOperationException;
import com.sap.idm.learning.exceptions.UnexpectedArgumentsException;
import com.sap.idm.learning.file_factory.CommandFactory;

import jline.console.ConsoleReader;
import jline.console.completer.Completer;
import jline.console.completer.StringsCompleter;

public class FileManagerMain {
	private static final Logger ROOT_LOGGER = Logger.getLogger("");
	private static final Logger LOGGER = Logger.getLogger(FileManagerMain.class.getName());
	private static Map<String, CommandType> commands;

//mvn -q clean compile exec:java -Dexec.mainClass="com.sap.idm.learning.main.FileManagerMain"
	public static void main(String[] args) throws IOException {
		configurateLogger();
		try (ConsoleReader reader = new ConsoleReader()) {
			LOGGER.log(Level.INFO, "File Manager started!");
			initializeReader(reader);
			commands = initializeCommands();
			String line;
			CommandFactory factory = new CommandFactory();

			while ((line = reader.readLine()) != null) {
				System.out.println("======>\"" + line + "\"");
				try {
					CommandType operation = getCommandFromLine(line);
					if (operation.equals(CommandType.QUIT)) {
						LOGGER.log(Level.INFO, "Application is quit.");
						break;
					}
					if (operation.equals(CommandType.CLS)) {
						LOGGER.log(Level.INFO, "Cleared screen.");
						reader.clearScreen();
						continue;
					}

					FileManagerCommand command = factory.getCommand(operation);
					List<String> commandArguments = splitCommandLineArguments(line);
					command.execute(commandArguments);

				} catch (FileOperationException foe) {
					LOGGER.log(Level.SEVERE, foe.getMessage(), foe);
					System.out.println(foe.getMessage());
				} catch (UnexpectedArgumentsException uae) {
					LOGGER.log(Level.WARNING, uae.getMessage(), uae);
					System.out.println(uae.getMessage());
				}
			}
		}
	}

	private static void configurateLogger() {
		try {
			FileHandler fileHandler = new FileHandler("FileManager.log", true);
			fileHandler.setFormatter(new SimpleFormatter());
			ROOT_LOGGER.removeHandler(ROOT_LOGGER.getHandlers()[0]);
			ROOT_LOGGER.addHandler(fileHandler);
			ROOT_LOGGER.setLevel(Level.ALL);
		} catch (IOException ioe) {
			System.out.println("Cannot create file handler: " + ioe.getMessage());
		}
	}

	private static Map<String, CommandType> initializeCommands() {
		Map<String, CommandType> result = new HashMap<>();
		result.put(Constants.COPY, CommandType.COPY);
		result.put(Constants.MKDIR, CommandType.MKDIR);
		result.put(Constants.MKFILE.toString(), CommandType.MKFILE);
		result.put(Constants.DELETE.toString(), CommandType.DELETE);
		result.put(Constants.LS.toString(), CommandType.LS);
		result.put(Constants.MOVE.toString(), CommandType.MOVE);
		result.put(Constants.PROPERTIES.toString(), CommandType.PROPERTIES);
		result.put(Constants.QUIT.toString(), CommandType.QUIT);
		result.put(Constants.CLS.toString(), CommandType.CLS);
		result.put(Constants.CONNECT.toString(), CommandType.CONNECT);
		result.put(Constants.DISCONNECT.toString(), CommandType.DISCONNECT);
		result.put(Constants.UPLOAD.toString(), CommandType.UPLOAD);
		result.put(Constants.DOWNLOAD.toString(), CommandType.DOWNLOAD);
		result.put(Constants.LISTFILES.toString(), CommandType.LISTFILES);

		return result;
	}

	private static CommandType getCommandFromLine(final String line) throws UnexpectedArgumentsException {
		if (line.isEmpty()) {
			throw new UnexpectedArgumentsException(Constants.INVALID_COMMAND_MESSAGE);
		}
		List<String> commandLineArguments = splitCommandLineArguments(line);
		String lineCommand = commandLineArguments.get(0);
		CommandType command = commands.get(lineCommand);
		if (command == null) {
			throw new UnexpectedArgumentsException(Constants.INVALID_COMMAND_MESSAGE);
		}

		return command;
	}

	private static void initializeReader(final ConsoleReader reader) {
		reader.setPrompt(Constants.PROMPT);
		Completer commandsCompleters = new StringsCompleter(Constants.LS, Constants.MKDIR, Constants.MKFILE,
				Constants.COPY, Constants.PROPERTIES, Constants.MOVE, Constants.DELETE, Constants.QUIT, Constants.CLS,
				Constants.CONNECT, Constants.DISCONNECT, Constants.UPLOAD, Constants.DOWNLOAD, Constants.LISTFILES);
		reader.addCompleter(commandsCompleters);
		usage();
	}

	private static List<String> splitCommandLineArguments(final String commandLine) {
		List<String> commandArguments = new ArrayList<>();
		Matcher matcher = Pattern.compile(Constants.REGEX_FOR_COMMAND).matcher(commandLine);
		while (matcher.find()) {
			commandArguments.add(matcher.group(1).replace("\"", ""));
		}
		return commandArguments;
	}

	private static void usage() {
		System.out.println("Usage: java " + FileManagerMain.class.getName());
		System.out.println(" autocompletable commands -  " + Constants.LS + " " + Constants.MKDIR + " "
				+ Constants.MKFILE + " " + Constants.COPY + " " + Constants.PROPERTIES + " " + Constants.MOVE + " "
				+ Constants.DELETE + " " + Constants.QUIT + " " + Constants.CLS + " " + Constants.CONNECT + " "
				+ Constants.DISCONNECT + " " + Constants.UPLOAD + " " + Constants.DOWNLOAD + " " + Constants.LISTFILES);
	}
}
