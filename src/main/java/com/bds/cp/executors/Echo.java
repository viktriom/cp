package com.bds.cp.executors;

import com.bds.cp.annotations.ExecutableCommand;
import com.bds.cp.bean.Command;

@ExecutableCommand(commandDescription = "", commandParams = {""}, commandParamsDescription = {""}, commandParameterType = {""})
public class Echo implements Executor{

	public Echo(){
		
	}
	
	public void execute(Command command){
		System.out.println(command.getAllArgumentsAsString());
	}

    public Command commandProcessor(String stringCommand) {
        return null;
    }
}
