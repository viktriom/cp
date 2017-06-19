package com.bds.cp.core.util;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.bds.cp.core.constants.CPConstants;
import com.bds.cp.core.constants.CommandProcessingMode;

/**
 * Created by sonu on 21/04/17.
 */
public class LogUtil {
	
    public static synchronized void log(Class className, Level level, String message){
    	if(CPConstants.getCommandProcessingMode().equals(CommandProcessingMode.NETWORK)){
    		if(level.equals(Level.INFO)){
    			Logger.getLogger(className).info(message);
    		}else if(level.equals(Level.WARN)){
    			Logger.getLogger(className).warn(message);
    		}else if(level.equals(Level.DEBUG)){
    			Logger.getLogger(className).debug(message);
    		}else if(level.equals(Level.TRACE)){
    			Logger.getLogger(className).trace(message);
    		}else if(level.equals(Level.ERROR)){
    			Logger.getLogger(className).error(message);
    		}else if(level.equals(Level.FATAL)){
    			Logger.getLogger(className).fatal(message);
    		}
    	}else if(CPConstants.getCommandProcessingMode().equals(CommandProcessingMode.COMMANDLINE)) {
    		StringBuilder sb = new StringBuilder();
    		sb.append("[");
    		sb.append(className.getName());
    		sb.append(":");
    		sb.append(level.toString());
    		sb.append("] - ");
    		sb.append(message);
    		System.out.println(message);
    	}
    }
}
