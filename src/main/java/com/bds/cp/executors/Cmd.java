package com.bds.cp.executors;

import com.bds.cp.annotations.ExecutableCommand;
import com.bds.cp.bean.Command;
import com.bds.cp.core.util.CPStore;
import com.bds.cp.core.util.CPUtil;
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
        LogUtil.logger(this.getClass()).info("Following commands are available for executions.");
        return null;
    }

    public Command commandProcessor(String stringCommand) {
        return null;
    }
}
