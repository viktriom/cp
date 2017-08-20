/**
 * 
 */
package com.bds.cp.executors;

import com.bds.cp.annotations.ExecutableCommand;
import com.bds.cp.bean.Command;
import com.bds.cp.core.constants.CPConstants;

/**
 * @author tripvi
 *
 */
@ExecutableCommand(commandDescription = "Sets the context from which the command is to be executed.", 
commandParams = {"index 0"}, 
commandParamsDescription = {"The new command context"},
commandParameterType = {"String"})
public class SetContext implements Executable {

	/* (non-Javadoc)
	 * @see com.gs.fw.automator.executors.Executor#execute(com.gs.fw.automator.bean.Command)
	 */
	public String execute(Command command) {
		String newApplicationContext = command.getValueForParamByPosition(0);
		
		if(newApplicationContext==null || newApplicationContext.length()<=0 || command.getArgumentsCount()<=0){
			CPConstants.fallToDefaultApplicationContext();
			return CPConstants.getCommandContext();
		}
		
		CPConstants.setComandContext(newApplicationContext);
		return CPConstants.getCommandContext();
	}

	/* (non-Javadoc)
	 * @see com.gs.fw.automator.executors.Executor#commandProcessor(java.lang.String)
	 */
	public Command commandProcessor(String stringCommand) {
		return null;
	}

}
