package com.bds.cp.executors;

import org.apache.log4j.Level;

import com.bds.cp.annotations.ExecutableCommand;
import com.bds.cp.bean.Command;
import com.bds.cp.core.constants.CPConstants;
import com.bds.cp.core.util.LogUtil;
import com.bds.cp.executors.test.GenCombinations;


@ExecutableCommand(commandDescription = "Shows the current context from which the commands are being executed.", 
commandParams = {}, 
commandParamsDescription = {},
commandParameterType = {})
public class ShowContext implements Executor {

	public String execute(Command command) {
		LogUtil.log(ShowContext.class, Level.INFO, CPConstants.getApplicationContext());
		return CPConstants.getApplicationContext();
	}

	public Command commandProcessor(String stringCommand) {
		return null;
	}

}
