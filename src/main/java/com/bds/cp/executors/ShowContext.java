package com.bds.cp.executors;

import com.bds.cp.annotations.ExecutableCommand;
import com.bds.cp.bean.Command;
import com.bds.cp.core.constants.CPConstants;


@ExecutableCommand
public class ShowContext implements Executor {

	public void execute(Command command) {
		System.out.println(CPConstants.getApplicationContext());
	}

	public Command commandProcessor(String stringCommand) {
		return null;
	}

}
