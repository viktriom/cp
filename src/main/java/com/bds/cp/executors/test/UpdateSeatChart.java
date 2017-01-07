/**
 * 
 */
package com.bds.cp.executors.test;

import com.bds.cp.annotations.ExecutableCommand;
import com.bds.cp.bean.Command;
import com.bds.cp.executors.Executor;

/**
 * @author tripvi
 *
 */
@ExecutableCommand
public class UpdateSeatChart implements Executor {

	/* (non-Javadoc)
	 * @see com.gs.fw.automator.executors.Executor#execute(com.gs.fw.automator.bean.Command)
	 */

	public void execute(Command command) {
		
	}

	/* (non-Javadoc)
	 * @see com.gs.fw.automator.executors.Executor#commandProcessor(java.lang.String)
	 */
	public Command commandProcessor(String stringCommand) {
		return null;
	}

}
