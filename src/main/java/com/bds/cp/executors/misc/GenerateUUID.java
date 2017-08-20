package com.bds.cp.executors.misc;

import java.util.UUID;

import org.apache.log4j.Level;

import com.bds.cp.annotations.ExecutableCommand;
import com.bds.cp.bean.Command;
import com.bds.cp.core.util.LogUtil;
import com.bds.cp.executors.Executable;

@ExecutableCommand(commandDescription = "Generates Universal Identifier.", commandParams = {}, commandParamsDescription = {}, commandParameterType={})
public class GenerateUUID implements Executable {

	public String execute(Command command) {
		String uuid = UUID.randomUUID().toString();
		LogUtil.log(GenerateUUID.class, Level.INFO, uuid);
		return uuid.toString();
	}

	public Command commandProcessor(String stringCommand) {
		return null;
	}

}
