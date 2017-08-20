package com.bds.cp.executors;

import java.util.LinkedHashSet;
import java.util.Set;

import org.apache.log4j.Level;

import com.bds.cp.annotations.ExecutableCommand;
import com.bds.cp.bean.Command;
import com.bds.cp.core.util.CPStore;
import com.bds.cp.core.util.LogUtil;
import com.bds.cp.executors.test.GenCombinations;
import com.google.gson.Gson;

@ExecutableCommand(commandDescription = "Shows a list of all the executable commands available with the system.", 
commandParams = {}, 
commandParamsDescription = {}, 
commandParameterType = {})
public class CmdList implements Executable {

	@Override
	public String execute(Command command) {
		Gson gson = new Gson();
		Set<String> cmds = new LinkedHashSet<String>();
    	for(String cmd : CPStore.getAvailableCommands()){
    		cmds.add(cmd);
    	}
    	String cmdList = gson.toJson(cmds);
    	LogUtil.log(CmdList.class, Level.INFO, cmdList);
        return cmdList;
	}

	@Override
	public Command commandProcessor(String stringCommand) {
		return null;
	}

}
