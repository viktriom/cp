package com.bds.cp.executors;

import com.bds.cp.annotations.ExecutableCommand;
import com.bds.cp.bean.Command;
import com.bds.cp.core.constants.CPConstants;


@ExecutableCommand(commandDescription = "Shows the current context from which the commands are being executed.", 
commandParams = {}, 
commandParamsDescription = {},
commandParameterType = {})
public class ShowContext implements Executor {

	public String execute(Command command) {
		System.out.println(CPConstants.getApplicationContext());
		return CPConstants.getApplicationContext();
	}

	public Command commandProcessor(String stringCommand) {
		return null;
	}

}
