package com.bds.cp.executors;

import org.apache.log4j.Level;

import com.bds.cp.annotations.ExecutableCommand;
import com.bds.cp.bean.Command;
import com.bds.cp.core.util.LogUtil;

/**
 * Created by sonu on 21/04/17.
 */
@ExecutableCommand(commandDescription = "Shows all the available commands that can be executed.", 
commandParams = {}, 
commandParamsDescription = {},
commandParameterType={})
public class Cmd implements Executor{

    public String execute(Command command) {
        LogUtil.log(this.getClass(),Level.INFO,"Following commands are available for executions.");
        return null;
    }

    public Command commandProcessor(String stringCommand) {
        return null;
    }
}
