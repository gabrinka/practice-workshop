package com.sap.idm.learning.file_manager_server.common_objects;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class Request implements Serializable {
	private static final long serialVersionUID = -322584219556446875L;

	private Command command;
	private List<String> commandArguments;

	public Request(final Command command, final List<String> commandArguments) {
		this.command = command;
		this.commandArguments = commandArguments;
	}

	public List<String> getCommandArgument() {
		return Collections.unmodifiableList(commandArguments);
	}

//TODO:to string
	public Command getCommand() {
		return command;
	}
}
