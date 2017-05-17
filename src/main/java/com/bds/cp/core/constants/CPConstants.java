package com.bds.cp.core.constants;

import com.bds.cp.core.util.CPUtil;

public class CPConstants {

	private static String applicationContext = "com.bds.cp.executors.";
	
	private static String filePathSeperator = System.getProperty("file.separator");
	
	private static final String defaultApplicationContext = "com.bds.cp.executors.";

	private static CommandProcessingMode commandProcessingMode;

	private static Integer networkListenerPort;
	
	public static void setApplicationContext(String applicContext){
		
		if(applicContext == null || applicContext.length()<=0){
			CPConstants.fallToDefaultApplicationContext();
			System.out.println("The new application context is : " + CPConstants.applicationContext);
			return;
		}
		
		if(applicContext.contains(".")){			
			if(applicContext.charAt(applicContext.length()-1)=='.')
				CPConstants.applicationContext = applicContext;
			else
				CPConstants.applicationContext = applicContext + ".";
		}else{
			if(applicContext.charAt(applicContext.length()-1)=='.')
				CPConstants.applicationContext = CPConstants.applicationContext + applicContext;
			else
				CPConstants.applicationContext = CPConstants.applicationContext + applicContext + ".";
		}
		
		System.out.println("The new application context is : " + CPConstants.applicationContext);
	}
	
	public static String getApplicationContext(){
		return CPConstants.applicationContext;
	}
	
	public static void fallToDefaultApplicationContext(){
		CPConstants.applicationContext = defaultApplicationContext;
		
		System.out.println("The new application context is : " + CPConstants.applicationContext);
	}
	
	public static String getDefaultApplicationContext(){
		return defaultApplicationContext;
	}

	public static String getFilePathSeperator() {
		return filePathSeperator;
	}

	public static void setFilePathSeperator(String filePathSeperator) {
		CPConstants.filePathSeperator = filePathSeperator;
	}

	public static CommandProcessingMode getCommandProcessingMode() {
		return commandProcessingMode;
	}

	public static void setCommandProcessingMode(String commandProcessingMode) {
		CPConstants.commandProcessingMode = CommandProcessingMode.getCommandProcessingMode(commandProcessingMode);
	}

	public static Integer getNetworkListenerPort() {
		return networkListenerPort;
	}

	public static void setNetworkListenerPort(String networkListenerPort) {
		if(CPUtil.isConvertibleToInt(networkListenerPort))
			CPConstants.networkListenerPort = Integer.parseInt(networkListenerPort);
	}
	
}
