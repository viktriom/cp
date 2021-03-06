package com.bds.cp.core.constants;

import org.apache.log4j.Level;

import com.bds.cp.core.network.Server;
import com.bds.cp.core.util.CPUtil;
import com.bds.cp.core.util.LogUtil;

public class CPConstants {

	private static String commandContext = "com.bds.cp.executors.";
	private static String filePathSeperator = System.getProperty("file.separator");
	private static String initialCommandContext;
	private static CommandProcessingMode commandProcessingMode;
	private static Integer networkListenerPort;
	private static Boolean isInitializationComplete = false;
	private static String commandStringTokenDelim;
	private static String dotTokenSeparator;
	private static String paramNameIndicator;
	private static String contextLocation;
	private static String dbUrl;
	private static String dbHost;
	private static String dbPort;
	private static String dbName;
	private static String dbUser;
	private static String dbPassword;
	private static String jdbcDBDriver;
	
	public static void setComandContext(String commandContext){	
		if(commandContext == null || commandContext.length()<=0){
			CPConstants.fallToDefaultApplicationContext();
			LogUtil.log(CPConstants.class, Level.INFO, "The new application context is : " + CPConstants.commandContext);
			return;
		}
		
		if(commandContext.contains(".")){			
			if(commandContext.charAt(commandContext.length()-1)=='.')
				CPConstants.commandContext = commandContext;
			else
				CPConstants.commandContext = commandContext + ".";
		}else{
			if(commandContext.charAt(commandContext.length()-1)=='.')
				CPConstants.commandContext = CPConstants.commandContext + commandContext;
			else
				CPConstants.commandContext = CPConstants.commandContext + commandContext + ".";
		}
		
		LogUtil.log(CPConstants.class, Level.INFO, "The new application context is : " + CPConstants.commandContext);
	}
	
	public static String getCommandContext(){
		return CPConstants.commandContext;
	}
	
	public static void fallToDefaultApplicationContext(){
		CPConstants.commandContext = initialCommandContext;		
		LogUtil.log(CPConstants.class, Level.INFO, "The new application context is : " + CPConstants.commandContext);
	}
	
	public static String getDefaultCommandContext(){
		return initialCommandContext;
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

	public static Boolean getIsInitializationComplete() {
		return isInitializationComplete;
	}

	public static void setIsInitializationComplete(Boolean isInitializationComplete) {
		CPConstants.isInitializationComplete = isInitializationComplete;
	}

	public static String getInitialCommandContext() {
		return initialCommandContext;
	}

	public static void setInitialCommandContext(String initialCommandContext) {
		CPConstants.initialCommandContext = initialCommandContext;
	}

	public static String getCommandStringTokenDelim() {
		return commandStringTokenDelim;
	}

	public static void setCommandStringTokenDelim(String commandStringTokenDelim) {
		CPConstants.commandStringTokenDelim = commandStringTokenDelim;
	}

	public static String getDotTokenSeparator() {
		return dotTokenSeparator;
	}

	public static void setDotTokenSeparator(String dotTokenSeparator) {
		CPConstants.dotTokenSeparator = dotTokenSeparator;
	}

	public static String getParamNameIndicator() {
		return paramNameIndicator;
	}

	public static void setParamNameIndicator(String paramNameIndicator) {
		CPConstants.paramNameIndicator = paramNameIndicator;
	}

	public static String getContextLocation() {
		return contextLocation;
	}

	public static void setContextLocation(String contextLocation) {
		CPConstants.contextLocation = contextLocation;
	}

	public static String getDbUrl() {
		return dbUrl;
	}

	public static void setDbUrl(String dbUrl) {
		CPConstants.dbUrl = dbUrl;
	}

	public static String getDbHost() {
		return dbHost;
	}

	public static void setDbHost(String dbHost) {
		CPConstants.dbHost = dbHost;
	}

	public static String getDbPort() {
		return dbPort;
	}

	public static void setDbPort(String dbPort) {
		CPConstants.dbPort = dbPort;
	}

	public static String getDbUser() {
		return dbUser;
	}

	public static void setDbUser(String dbUser) {
		CPConstants.dbUser = dbUser;
	}

	public static String getDbPassword() {
		return dbPassword;
	}

	public static void setDbPassword(String dbPassword) {
		CPConstants.dbPassword = dbPassword;
	}		
	
	public static String getDbName() {
		return dbName;
	}

	public static void setDbName(String dbName) {
		CPConstants.dbName = dbName;
	}
	
	public static String getJdbcDBDriver() {
		return jdbcDBDriver;
	}

	public static void setJdbcDBDriver(String jdbcDBDriver) {
		CPConstants.jdbcDBDriver = jdbcDBDriver;
	}

	public static String getCompleteDBUrl(){
		String completeDBUrl = "";
		completeDBUrl = dbUrl + dbHost + ":" + dbPort + "/" + dbName;
		return completeDBUrl;
	}
}