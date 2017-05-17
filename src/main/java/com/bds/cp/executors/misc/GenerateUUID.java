package com.bds.cp.executors.misc;

import java.util.UUID;

import com.bds.cp.annotations.ExecutableCommand;
import com.bds.cp.bean.Command;
import com.bds.cp.executors.Executor;

@ExecutableCommand(commandDescription = "Generates Universal Identifier.", commandParams = {}, commandParamsDescription = {}, commandParameterType={})
public class GenerateUUID implements Executor {

	public String execute(Command command) {
		String uuid = UUID.randomUUID().toString();
		System.out.println(uuid);
		return uuid.toString();
	}

	public Command commandProcessor(String stringCommand) {
		return null;
	}

}
