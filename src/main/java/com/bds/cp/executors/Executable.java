package com.bds.cp.executors;

import com.bds.cp.bean.Command;


public interface Executable {
	/**
	 * Define/Implement the behavior of the command here.
	 * @param command : Instance of the Command object, use this to retrieve specifics regarding the command like arguments, options etc.
	 */
	public String execute(Command command);
	
	/**
	 * Implement this method if a custom implementation of Command parsing mechanism is required.
	 * The implementation of this method is required even if a custom implementation is not required but return null in that case.
	 * @param stringCommand : The command string read from the command line.
	 * @return The Command object after parsing the command string read from the command line (In case a custom implementation is required) null otherwise.
	 */
    public Command commandProcessor(String stringCommand);
}
