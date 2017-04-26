package com.bds.cp.core.util.web;

import com.bds.cp.annotations.ExecutableCommand;
import com.bds.cp.bean.CommandMetaData;
import com.bds.cp.core.util.CPStartupUtil;
import com.bds.cp.core.util.CPStore;
import com.bds.cp.core.util.CPUtil;
import com.bds.cp.executors.Executor;

import java.util.LinkedHashSet;
import java.util.Set;

import org.apache.log4j.Logger;

/**
 * Created by sonu on 17/02/17.
 */
public class WebUtil {

    private static Logger log = Logger.getLogger(WebUtil.class);
    
    public static void initializeCPSystem(){
    	CPStartupUtil.loadCommands();
        CPUtil.loadPropertiesFileIntoClass(CPUtil.getPathForString("cp.properties"), "CPConstants",true);
    }

    public static CommandMetaData getCommandMetadata(String commandName){
        log.info("Preparing Command metadata for command : ." + commandName);
        CommandMetaData commandMetaData = null;
        String commandDescription = "";
        String[] paramNames, paramNameDescription;
        Executor executor = CPStore.getCommandFromCommandStore(commandName);
        
        if(null != executor && executor.getClass().isAnnotationPresent(ExecutableCommand.class)){
        	
        	commandMetaData = new CommandMetaData();
            
        	ExecutableCommand executableCommand = (ExecutableCommand)executor.getClass().getAnnotation(ExecutableCommand.class);
            
            commandDescription = executableCommand.commandDescription();
            
            commandMetaData.setCommandName(commandName);
            commandMetaData.setCommandDescription(commandDescription);
            
            paramNames = executableCommand.commandParams();
            paramNameDescription = executableCommand.commandParamsDescription();
            
            for(int i = 0;i <paramNames.length;i++){
            	commandMetaData.addParamNameAndDescription(paramNames[i], paramNameDescription[i]);
            }
        }
        log.info("Completed the convertion of command into web page info.");
        return commandMetaData;
    }

    public static Set<String> getCommandList(){
    	Set<String> cmds = new LinkedHashSet<String>();
    	for(String cmd : CPStore.getAvailableCommands()){
    		cmds.add(cmd);
    	}
        return cmds;
    }
}
