package com.sap.idm.learning.main;

public final class Constants {
	// used for setting up the console and parsing the input
	public static final String REGEX_FOR_COMMAND = "([^\"]\\S*|\".+?\")\\s*";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String RESET = "\u001B[0m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String PROMPT = ANSI_RED + "gabi" + RESET + "@" + ANSI_GREEN + "mycomputer" + RESET + "<";
	public static final String INVALID_COMMAND_MESSAGE = "Invalid command!";

	// used for autocompleting commands and displaying them
	public static final String COPY = "copy";
	public static final String MKDIR = "mkdir";
	public static final String MKFILE = "mkfile";
	public static final String DELETE = "delete";
	public static final String LS = "ls";
	public static final String MOVE = "move";
	public static final String PROPERTIES = "properties";
	public static final String CONNECT = "connect";
	public static final String DISCONNECT = "disconnect";
	public static final String LISTFILES = "listfiles";
	public static final String UPLOAD = "upload";
	public static final String DOWNLOAD = "download";
	public static final String QUIT = "quit";
	public static final String CLS = "cls";

}
