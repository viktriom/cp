package com.bds.cp.executors.misc;

import java.util.UUID;

import com.bds.cp.annotations.ExecutableCommand;
import com.bds.cp.bean.Command;
import com.bds.cp.executors.Executor;

@ExecutableCommand
public class GenerateUUID implements Executor {

	public void execute(Command command) {
		String uuid = UUID.randomUUID().toString();
		System.out.println(uuid);
	}

	public Command commandProcessor(String stringCommand) {
		return null;
	}

}
