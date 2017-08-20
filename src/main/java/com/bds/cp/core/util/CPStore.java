package com.bds.cp.core.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.bds.cp.executors.Executable;
import com.bds.cp.bean.CommandBean;

import org.apache.log4j.Logger;

/**
 * @author tripvi
 *
 */
public class CPStore {
	
	private static Map<String,CommandBean> commandStore = new HashMap<String,CommandBean>();

	public static void addCommandToStore(Executable command){
		CommandBean cmdBean = new CommandBean(command,System.currentTimeMillis());
		commandStore.put(command.getClass().getName(), cmdBean);
	}

	public static Executable getCommandFromCommandStore(String fullCommandName){
		CommandBean cmdBean = commandStore.get(fullCommandName);
		if(null == cmdBean)
			return null;
		cmdBean.setLastAccessTime(System.currentTimeMillis());
		Executable executor = cmdBean.getExecutor();
		return executor;
	}

	public static Set<String> getAvailableCommands(){
		return commandStore.keySet();
	}


	public static void clearCommandStore() {
		commandStore.clear();
	}

}
