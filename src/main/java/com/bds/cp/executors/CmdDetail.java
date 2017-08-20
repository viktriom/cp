package com.bds.cp.executors;


import org.apache.log4j.Level;

import com.bds.cp.annotations.ExecutableCommand;
import com.bds.cp.bean.Command;
import com.bds.cp.bean.CommandMetaData;
import com.bds.cp.core.network.Server;
import com.bds.cp.core.util.CPUtil;
import com.bds.cp.core.util.LogUtil;
import com.google.gson.Gson;

@ExecutableCommand(commandDescription = "Get command detail for a particualr command (ex: Parameters required, type of params etc..)", 
commandParams = {"c"}, 
commandParamsDescription = {"Fully qualitifed Command Name"}, 
commandParameterType = {"String"})
public class CmdDetail implements Executable {
	
	@Override
	public String execute(Command command) {
		Gson gson = new Gson();
		String cmdName = command.getValueForParam("c");
		LogUtil.log(CmdDetail.class, Level.INFO, "Request to get command detail received, for command : " + cmdName);
		CommandMetaData cmdDetail = CPUtil.getCommandMetadata(cmdName);
		LogUtil.log(CmdDetail.class, Level.INFO, "");
		String jsonCmdDetail = gson.toJson(cmdDetail);
		LogUtil.log(CmdDetail.class, Level.INFO, "The command details sent to server are : " + jsonCmdDetail);
		return jsonCmdDetail;
	}

	@Override
	public Command commandProcessor(String stringCommand) {
		return null;
	}

}
