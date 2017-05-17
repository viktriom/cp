package com.bds.cp.executors;

import com.bds.cp.annotations.ExecutableCommand;
import com.bds.cp.bean.Command;


@ExecutableCommand(
		commandDescription = "Ends the applicaiton.", 
		commandParams = {}, 
		commandParamsDescription = {},
		commandParameterType = {}
)
public class Exit implements Executor{

	public String execute(Command command){
		System.out.println("Bye");
		System.exit(0);
		return "Bye";
	}

    public Command commandProcessor(String stringCommand) {
        return null;
    }
}
