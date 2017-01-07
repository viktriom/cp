/**
 * 
 */
package com.bds.cp.core.util;

import java.util.HashMap;
import java.util.Map;

import com.bds.cp.executors.Executor;
import com.bds.cp.bean.CommandBean;

import org.apache.log4j.Logger;

/**
 * @author tripvi
 *
 */
public class CPStore {

	private static Logger log = Logger.getLogger(CPStore.class);
	
	private static Map<String,CommandBean> commandStore = new HashMap<String,CommandBean>();

	public static void putCommandInCommandStore(String fullCommandName,Executor executor){
		CommandBean cmdBean = new CommandBean(executor,System.currentTimeMillis());
		commandStore.put(fullCommandName, cmdBean);
	}

	public static Executor getCommandFromCommandStore(String fullCommandName){
		CommandBean cmdBean = commandStore.get(fullCommandName);
		cmdBean.setLastAccessTime(System.currentTimeMillis());
		Executor executor = cmdBean.getExecutor();
		return executor;
	}

	public static void clearCommandStore() {
		commandStore.clear();
	}
}
