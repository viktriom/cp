package com.bds.cp.executors;

import com.bds.cp.bean.Command;

public class SetSystemParam implements Executable{

	@Override
	public String execute(Command command) {
		String propertyName = command.getValueForParam("pn");
		String propertyVal = command.getValueForParam("pv");
		
		return null;
	}

	@Override
	public Command commandProcessor(String stringCommand) {
		return null;
	}

}
