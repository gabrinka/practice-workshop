package com.sap.idm.learning.commands;

import java.util.List;

import com.sap.idm.learning.exceptions.FileOperationException;
import com.sap.idm.learning.exceptions.UnexpectedArgumentsException;

public abstract class FileManagerCommand {
	protected static final int FIRST_ARGUMENT = 1;
	protected static final int SECOND_ARGUMENT = 2;
	protected static final String ROOT_DIRECTORY = ".";
	protected static final String DELIMETER = " ";

	public static final String SUCCESSFUL_OPERATION_MSG = "Operation was successful!";
	public static final String UNSUCCESSFUL_OPERATION_MSG = "Operation was unsuccessful!";

	public abstract void execute(final List<String> commandArguments)
			throws FileOperationException, UnexpectedArgumentsException;
}
