package com.bds.cp.executors;

import org.apache.log4j.Level;

import com.bds.cp.annotations.ExecutableCommand;
import com.bds.cp.bean.Command;
import com.bds.cp.core.util.LogUtil;
import com.bds.cp.executors.test.GenCombinations;


@ExecutableCommand(
		commandDescription = "Ends the applicaiton.", 
		commandParams = {}, 
		commandParamsDescription = {},
		commandParameterType = {}
)
public class Exit implements Executor{

	public String execute(Command command){
		LogUtil.log(Exit.class, Level.INFO, "Bye");
		System.exit(0);
		return "Bye";
	}

    public Command commandProcessor(String stringCommand) {
        return null;
    }
}
