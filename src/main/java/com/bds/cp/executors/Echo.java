package com.bds.cp.executors;

import com.bds.cp.annotations.ExecutableCommand;
import com.bds.cp.bean.Command;

@ExecutableCommand(commandDescription = "Prints the given String.", 
commandParams = {"Echo-"}, 
commandParamsDescription = {"The String to be printed."}, 
commandParameterType = {"String"})
public class Echo implements Executor{
	
	public String execute(Command command){
		System.out.println(command.getAllArgumentsAsString());
		return command.getAllArgumentsAsString();
	}

    public Command commandProcessor(String stringCommand) {
        return null;
    }
}
