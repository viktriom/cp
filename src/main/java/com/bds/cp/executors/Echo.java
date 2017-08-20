package com.bds.cp.executors;

import org.apache.log4j.Level;

import com.bds.cp.annotations.ExecutableCommand;
import com.bds.cp.bean.Command;
import com.bds.cp.core.util.LogUtil;
import com.bds.cp.executors.test.GenCombinations;

@ExecutableCommand(commandDescription = "Prints the given String.", 
commandParams = {"Echo-"}, 
commandParamsDescription = {"The String to be printed."}, 
commandParameterType = {"String"})
public class Echo implements Executable{
	
	public String execute(Command command){
		LogUtil.log(Echo.class, Level.INFO, command.getAllParamsAsString());
		return command.getAllParamsAsString();
	}

    public Command commandProcessor(String stringCommand) {
        return null;
    }
}
