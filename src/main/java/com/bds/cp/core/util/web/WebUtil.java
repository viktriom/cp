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
            	if(paramNames[i].isEmpty() || paramNames[i].length() <= 0) continue;
            	commandMetaData.addParamNameAndDescription(paramNames[i], paramNameDescription[i]);
            }
        }
        log.info("Done collecting parameter metadata for command name : " + commandName);
        return commandMetaData;
    }
    
    public static String prepareHTMLForCommandMetadata(String commandName){
    	CommandMetaData cmdDetail = getCommandMetadata(commandName);
    	if(!CPUtil.isCommandAvailable(commandName)) return "<div><p> "+ commandName + " command not found.</p></div>";
    	StringBuilder sb = new StringBuilder();
    	sb.append("<div>");
    	sb.append("<p>");
    	sb.append("<p>");
    	sb.append("Command Name :: ");
    	sb.append(commandName);
    	sb.append("</p>");
    	sb.append("<p>");
    	sb.append(cmdDetail.getCommandDescription());
    	sb.append("</p>");
    	int i =0;
    	for(String paramName:cmdDetail.getParamNames()){
    		if(cmdDetail.getParamNames().isEmpty()) break;
    		String paramDesc = cmdDetail.getDescriptionForParam(paramName);
    		sb.append("<p>");
    		sb.append(paramDesc + " : ");
    		sb.append("<input name='" + paramName + "' id='paramName" + i++ + "'/>");
    		sb.append("</p>");
    	}
    	sb.append("</p>");
    	sb.append("</div>");
    	return sb.toString();
    }

    public static Set<String> getCommandList(){
    	Set<String> cmds = new LinkedHashSet<String>();
    	for(String cmd : CPStore.getAvailableCommands()){
    		cmds.add(cmd);
    	}
        return cmds;
    }
}
