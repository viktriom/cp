package com.bds.cp.core.util.web;

import com.bds.cp.annotations.ExecutableCommand;
import com.bds.cp.bean.Command;
import com.bds.cp.bean.CommandMetaData;
import com.bds.cp.core.listener.CLCommandListener;
import com.bds.cp.core.util.CPStore;
import com.bds.cp.executors.Executor;
import org.apache.log4j.Logger;

import javax.persistence.PersistenceUtil;
import java.lang.reflect.Method;

/**
 * Created by sonu on 17/02/17.
 */
public class WebUtil {

    private static Logger log = Logger.getLogger(WebUtil.class);

    public static CommandMetaData getCommandMetadata(String commandName){
        log.info("Begining command parsing into web page info.");
        CommandMetaData commandMetaData = null;
        String commandDescription = "";
        String[] paramNames, paramNameDescription;
        Executor executor = CPStore.getCommandFromCommandStore(commandName);

        if(executor.getClass().isAnnotationPresent(ExecutableCommand.class)){
            ExecutableCommand executableCommand = (ExecutableCommand)executor.getClass().getAnnotation(ExecutableCommand.class);
            commandDescription = executableCommand.commandDescription();
            paramNames = executableCommand.commandParams();
            paramNameDescription = executableCommand.commandParamsDescription();
            commandMetaData = new CommandMetaData(commandName, commandDescription, paramNames, paramNameDescription);
        }
        log.info("Completed the convertion of command into web page info.");
        return commandMetaData;
    }
}
