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
@ExecutableCommand
public class SetContext implements Executor {

	/* (non-Javadoc)
	 * @see com.gs.fw.automator.executors.Executor#execute(com.gs.fw.automator.bean.Command)
	 */
	public void execute(Command command) {
		String newApplicationContext = command.getArgumentForOption(0);
		
		if(newApplicationContext==null || newApplicationContext.length()<=0 || command.getArgumentsCount()<=0){
			CPConstants.fallToDefaultApplicationContext();
			return;
		}
		
		CPConstants.setApplicationContext(newApplicationContext);

	}

	/* (non-Javadoc)
	 * @see com.gs.fw.automator.executors.Executor#commandProcessor(java.lang.String)
	 */
	public Command commandProcessor(String stringCommand) {
		return null;
	}

}
