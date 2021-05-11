package com.sap.idm.learning.file_factory;

import com.sap.idm.learning.commands.FileManagerCommand;
import com.sap.idm.learning.commands.CommandType;
import com.sap.idm.learning.commands.CopyFileCommand;
import com.sap.idm.learning.commands.CreateDirectoryCommand;
import com.sap.idm.learning.commands.CreateEmptyFileCommand;
import com.sap.idm.learning.commands.DeleteFileCommand;
import com.sap.idm.learning.commands.ListFilesCommand;
import com.sap.idm.learning.commands.MoveFileCommand;
import com.sap.idm.learning.commands.ShowPropertiesCommand;
import com.sap.idm.learning.commands.server.Connect;
import com.sap.idm.learning.commands.server.Disconnect;
import com.sap.idm.learning.commands.server.Download;
import com.sap.idm.learning.commands.server.ListServerFiles;
import com.sap.idm.learning.commands.server.Upload;
import com.sap.idm.learning.exceptions.UnexpectedArgumentsException;

public class CommandFactory {
	public FileManagerCommand getCommand(final CommandType operation) throws UnexpectedArgumentsException {
		switch (operation) {
		case COPY:
			return new CopyFileCommand();
		case DELETE:
			return new DeleteFileCommand();
		case LS:
			return new ListFilesCommand();
		case MKDIR:
			return new CreateDirectoryCommand();
		case MKFILE:
			return new CreateEmptyFileCommand();
		case MOVE:
			return new MoveFileCommand();
		case PROPERTIES:
			return new ShowPropertiesCommand();
		case CONNECT:
			return new Connect();
		case DISCONNECT:
			return new Disconnect();
		case UPLOAD:
			return new Upload();
		case DOWNLOAD:
			return new Download();
		case LISTFILES:
			return new ListServerFiles();
		default:
			throw new UnexpectedArgumentsException("Command is invalid!");
		}
	}
}
