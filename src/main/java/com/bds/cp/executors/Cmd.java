package com.bds.cp.executors;

import com.bds.cp.annotations.ExecutableCommand;
import com.bds.cp.bean.Command;
import com.bds.cp.core.util.CPStore;
import com.bds.cp.core.util.CPUtil;
import com.bds.cp.core.util.LogUtil;

/**
 * Created by sonu on 21/04/17.
 */
@ExecutableCommand(commandDescription = "Shows all the available commands that can be executed.", commandParams = {"none"}, commandParamsDescription = {"note-test"})
public class Cmd implements Executor{

    public void execute(Command command) {
        LogUtil.logger(this.getClass()).info("Following commands are available for executions.");
    }

    public Command commandProcessor(String stringCommand) {
        return null;
    }
}
