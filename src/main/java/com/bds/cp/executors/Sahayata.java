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

@ExecutableCommand(commandDescription = "Gives information about an available commans.", commandParams = {"cmd"}, commandParamsDescription = {"The name of the command for the information is required"})
public class Sahayata implements Executor {

	public void execute(Command command) {

		
	}

	public Command commandProcessor(String stringCommand) {
		return null;
	}

}
