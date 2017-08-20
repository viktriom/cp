/**
 * 
 */
package com.bds.cp.executors;

import com.bds.cp.annotations.ExecutableCommand;
import com.bds.cp.bean.Command;

/**
 * @author tripvi
 *
 */

@ExecutableCommand(commandDescription = "Provides more information about a command.", 
commandParams = {"cmd"}, 
commandParamsDescription = {"The name of the command for the information is required"},
commandParameterType = {"String"})
public class Sahayata implements Executable {

	public String execute(Command command) {
		return null;
	}

	public Command commandProcessor(String stringCommand) {
		return null;
	}

}
