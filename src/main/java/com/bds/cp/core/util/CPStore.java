package com.bds.cp.core.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.bds.cp.executors.Executor;
import com.bds.cp.bean.CommandBean;

import org.apache.log4j.Logger;

/**
 * @author tripvi
 *
 */
public class CPStore {
	
	private static Map<String,CommandBean> commandStore = new HashMap<String,CommandBean>();

	public static void putCommandInCommandStore(String fullCommandName,Executor executor){
		CommandBean cmdBean = new CommandBean(executor,System.currentTimeMillis());
		commandStore.put(fullCommandName, cmdBean);
	}

	public static Executor getCommandFromCommandStore(String fullCommandName){
		CommandBean cmdBean = commandStore.get(fullCommandName);
		if(null == cmdBean)
			return null;
		cmdBean.setLastAccessTime(System.currentTimeMillis());
		Executor executor = cmdBean.getExecutor();
		return executor;
	}

	public static Set<String> getAvailableCommands(){
		return commandStore.keySet();
	}


	public static void clearCommandStore() {
		commandStore.clear();
	}

}
