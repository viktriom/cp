package com.bds.cp.core.util;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

import org.apache.log4j.Level;

import com.bds.cp.annotations.ExecutableCommand;
import com.bds.cp.bean.Command;
import com.bds.cp.bean.CommandMetaData;
import com.bds.cp.bean.CommandParameter;
import com.bds.cp.bean.CommandParameterType;
import com.bds.cp.core.constants.CPConstants;
import com.bds.cp.core.network.Server;
import com.bds.cp.executors.Executor;


public class CPUtil {
	
	@SuppressWarnings({"rawtypes"})
	/**
	 * This method uses the reflection to load a properties file into a class. The name of the properties in the properties file should be same as the name in the Class 
	 * For example: 
	 * If the class has a property 
	 * 		private static String hostName;
	 * then the property file should have a property named : 
	 * 		hostName=127.0.0.1  
	 * @param fileName - The name of the properties file which is to be loaded.
	 * @param fullyQualifiedClassName - Fully qualified class name in which the properties are to be loaded.
	 * @param isStatic - Used to identify if a constructor is to be called or not.
	 * @return Returns a new instance of the class with all properties initialized from a properties file.
	 */
	public static Object loadPropertiesFileIntoClass(String fileName, String fullyQualifiedClassName, boolean isStatic){
		
		String methodName = "";
		String parameter = "";
		Object obj=null;
		
		if(fullyQualifiedClassName.indexOf('.')<0){
			fullyQualifiedClassName = "com.bds.cp.core.constants."+fullyQualifiedClassName;
		}
		
		try{
			Properties properties = new Properties();
			InputStream propStream = CPUtil.class.getClassLoader().getResourceAsStream(fileName);
			properties.load(propStream);
			
			Class cls = Class.forName(fullyQualifiedClassName);
			if(!isStatic){
				Constructor cnstr = cls.getConstructor();
				obj = cnstr.newInstance(null);
			}
			
			for(String key:properties.stringPropertyNames()){
				try{
					methodName = "set" + capitalizeFirstLetter(key);
					parameter = properties.getProperty(key);
					Method method = cls.getDeclaredMethod(methodName, String.class);
					if(isStatic)
						method.invoke(null, parameter);
					else
						method.invoke(obj, parameter);
				}catch (SecurityException e) {
					LogUtil.log(CPUtil.class, Level.ERROR, "A security exception was generated for the method name \""+methodName +"\" exists in the class \"" + fullyQualifiedClassName +"\".");
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					LogUtil.log(CPUtil.class, Level.ERROR, "No method with the name \""+methodName +"\" exists in the class \"" + fullyQualifiedClassName +"\".");
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					LogUtil.log(CPUtil.class, Level.ERROR, "IllegalArgumentException while calling the method \""+methodName +"\" exists in the class \"" + fullyQualifiedClassName +"\".");
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					LogUtil.log(CPUtil.class, Level.ERROR, "IllegalAccessException occured while accessing the method name \""+methodName +"\" exists in the class \"" + fullyQualifiedClassName +"\".");
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					LogUtil.log(CPUtil.class, Level.ERROR, "InvocationTargetException occured while accessing the method name \""+methodName +"\" exists in the class \"" + fullyQualifiedClassName +"\".");
					e.printStackTrace();
				}
			}
			
		} catch(IOException ex){
			LogUtil.log(CPUtil.class, Level.ERROR, "There was an error reading the property file, proceeding with defaults." + ex.getMessage());
		} catch (ClassNotFoundException e) {
			LogUtil.log(CPUtil.class, Level.ERROR, "The specified class not found, properties not loaded.");
			e.printStackTrace();
		} catch (InstantiationException e) {
			LogUtil.log(CPUtil.class, Level.ERROR, "Unable to Intantiate the class");
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			LogUtil.log(CPUtil.class, Level.ERROR, "There was an exception.");
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} 
		return obj;
	}
	
	/**
	 * Tells if a given string contains anything other than digits 0 to 9. 
	 * Using that it can be identified whether the string can be converted to decimal number or not.
	 * @param string - The string which is to be tested.
	 * @return - If the string can be converted to a decimal integer or not.
	 */
	public static boolean isConvertibleToInt(String string){
		if(null == string || string.length() <=0)
			return false;
		boolean isNumber = true;
		char ch=' ';
		for(int i=0;i<string.length();i++){
			ch = string.charAt(i);
			if(!Character.isDigit(ch)){
				isNumber = false;
				break;
			}
		}
		return isNumber;
	}
	
	public static String getPathForString(String colonSeparatedPath){
		String pathElems[] = colonSeparatedPath.split(":");
		String path="";
		int i=0;
		for(i=0;i<=(pathElems.length-1);i++){
			if(i==0)
				path = pathElems[i];
			else
				path = path + CPConstants.getFilePathSeperator() + pathElems[i];
		}
		if(colonSeparatedPath.charAt(colonSeparatedPath.length()-1)==':')
			path = path + CPConstants.getFilePathSeperator();
		return path;
	}
	
	public static String getInitCapString(String normalString){
		int intChar;
		String camelCaseString;
		normalString = normalString.toLowerCase();
		intChar = normalString.charAt(0);
        //converting the first character of the command to caps.
        if(intChar>97 && intChar<123){
            char c= (char)(intChar-32);
            camelCaseString = String.valueOf(c)+normalString.substring(1,normalString.length());
            return camelCaseString;
        }
        return normalString;
	}
	
	private static String capitalizeFirstLetter(String normalString){
		int intChar;
		intChar = normalString.charAt(0);
        //converting the first character of the command to caps.
        if(intChar>=97 && intChar<123){
            char c= (char)(intChar-32);
            normalString = String.valueOf(c)+normalString.substring(1,normalString.length());
        }
        return normalString;
	}
	
	public static Command parseCommand(String command){
		Command cmd=new Command();
		/*LogUtil.log(CPUtil.class, Level.INFO, "Command parsed by Util.parseCommand().");
		LogUtil.log(CPUtil.class, Level.INFO, "The command string is : " + command);*/
		String[] commandParts = command.split(" ");
        cmd.setCommand(commandParts[0]);
        if(commandParts.length==1)
            return cmd;
        String options = commandParts[1];
        char chr = options.charAt(0);
        
        if(chr == '-'){
            options = options.substring(1,options.length());
            if(options.indexOf('.')<0){
            	char[] opts = options.toCharArray();
            	putArgInCommand(commandParts,opts,cmd);
            }else{
            	String[] opts = options.split("\\.");
            	putArgInCommand(commandParts, opts, cmd);
            }
            
        }else{
            for(int i =1;i<commandParts.length;i++){
                cmd.setArgumentForOption(String.valueOf(i-1),commandParts[i]);
            }
        }
		return cmd;
	}
		
	private static void putArgInCommand(String[] commandParts, char[] opts,Command cmd){
		String opt="";
		for(int i=2,j=0;i<commandParts.length;i++,j++){
        	
        	if(j>=opts.length)
        		opt = String.valueOf(j-opts.length);
        	else
        		opt = String.valueOf(opts[j]);
        	
        	if(j>commandParts.length){
        		LogUtil.log(CPUtil.class, Level.INFO, "Arguments cannot be more than options.");
        		break;
        	}
        	
            cmd.setArgumentForOption(opt,commandParts[i]);
        }
	}
	
	private static void putArgInCommand(String[] commandParts, String[] opts,Command cmd){
		String opt="";
		for(int i=2,j=0;i<commandParts.length;i++,j++){
        	
        	if(j>=opts.length)
        		opt = String.valueOf(j-opts.length);
        	else
        		opt = opts[j];
        	
        	if(j>commandParts.length){
        		LogUtil.log(CPUtil.class, Level.INFO, "Arguments cannot be more than options.");
        		break;
        	}
        	
            cmd.setArgumentForOption(opt,commandParts[i]);
        }
	}
	
	@SuppressWarnings("unchecked")
	public static boolean executorExists(String fullyQualifiedClassName){
		boolean classExists = false;
		try {
			Class<Executor> exec = (Class<Executor>)Class.forName(fullyQualifiedClassName);
			classExists = true;
		} catch (ClassNotFoundException e) {
			classExists = false;
		}
		return classExists;
	}
	
	public static int getIndexOfCharFromRight(String string, char chr){
		int index=-1;
		for(int i=(string.length()-1);i>=0;i--){
			if(string.charAt(i)==chr){
				index=i;
				break;
			}
		}
		return index;
	}
	
	public static ArrayList<String> getParams(String cmdVal){
		ArrayList<String> argList = new ArrayList<String>();
		String[] arr = cmdVal.split("<");
	
		for(int i=0;i<arr.length;i++){
			String str = arr[i];
			if(str.indexOf('>')>=0){
				argList.add(str.substring(0,str.indexOf('>')));
			}
		}
		return argList;
	}
	
	public static String prepareQuery(String query,Command command){
		String[] arr = query.split("<");
		String actStr = "";
		int paramCt = 0;
 
		for(int i=0;i<arr.length;i++){
			String str = arr[i];
			if(str.indexOf('>')>=0){
				arr[i] = str.substring(str.indexOf('>')+1,str.length());
				actStr = actStr + command.getArgumentForOption(paramCt++) + arr[i];
			}else{
				actStr = actStr + arr[i];
			}
		}
		return actStr;
	}
	
	public static void obtainParametersForCommand(ArrayList<String> argSet, Command command){
		Scanner in = new Scanner(System.in);
		int argCt = command.getArgumentsCount();
		String arg = "";
		int fact = 0;
		for(int j=argCt;j<argSet.size();j++){
			if(command.getArgumentForOption(j)==null){
				fact=j;
				break;
			}
		}
		
		for(int i=fact;i<argSet.size();i++){
			LogUtil.log(CPUtil.class, Level.INFO, "Enter " + argSet.get(i) +":");
			arg = in.nextLine();
			command.setArgumentForOption(String.valueOf(i), arg);
		}
	}


    /**
     * This interface defines a event based command processing.
     * When called it processes a single command at a time.
     * @param command - The string form of the command to be processed in the format [CommandName -<paramList> <valueList>]
     * (ex: CommandName -param1.param2.param3 value1 value2 value3).
     */
	public static String executeCommand(String command){

		String className="";
		String[] cmdParts;
		Command cmd = null;
		String tempAppCtx;

		if(command==null || command.length()<=0)
			return null;
		cmdParts = command.split(" ");

		tempAppCtx= CPConstants.getApplicationContext();
		className = CPConstants.getApplicationContext() + cmdParts[0];

		while((!CPUtil.executorExists(className)) && tempAppCtx.length()>= CPConstants.getDefaultApplicationContext().length()){
			tempAppCtx = tempAppCtx.substring(0, CPUtil.getIndexOfCharFromRight(tempAppCtx,'.'));
			className = tempAppCtx + "." + cmdParts[0];
		}

		Executor e = CPStore.getCommandFromCommandStore(className);
		if(e==null){
			LogUtil.log(CPUtil.class, Level.INFO, "Command \""+className + "\" not found.");
			return null;
		}
		cmd = e.commandProcessor(command);
		if(cmd==null)
			cmd = CPUtil.parseCommand(command);
		return e.execute(cmd);
	}
	
	public static boolean isCommandAvailable(String commandName){
		if(null == commandName || commandName.isEmpty()) return false;
		if(!CPStore.getAvailableCommands().contains(commandName)) return false;
		return true;
	}
	

	/**
	 * Extracts metadata of a command for a given command name. The metadata includes the name of the command and what type parameters the command accepts.
	 * This metadata can be used to display information for displaying information about a command.
	 * @param commandName - The name of the command for which metadata information is required.
	 * Just the command name if the command context is already set. 
	 * The fully qualified class name if the command context in not already set.  
	 * @return - The metadata Object.
	 */
    public static CommandMetaData getCommandMetadata(String commandName){
        LogUtil.log(CPUtil.class, Level.INFO, "Preparing Command metadata for command : ." + commandName);
        CommandMetaData commandMetaData = null;
        String commandDescription = "";
        String[] paramNames, paramNameDescription, paramType;
        Executor executor = CPStore.getCommandFromCommandStore(commandName);
        
        if(null != executor && executor.getClass().isAnnotationPresent(ExecutableCommand.class)){
        	
        	commandMetaData = new CommandMetaData();
            
        	ExecutableCommand executableCommand = (ExecutableCommand)executor.getClass().getAnnotation(ExecutableCommand.class);
            
            commandDescription = executableCommand.commandDescription();
            
            commandMetaData.setCommandName(commandName);
            commandMetaData.setCommandDescription(commandDescription);
            
            paramNames = executableCommand.commandParams();
            paramNameDescription = executableCommand.commandParamsDescription();
            paramType = executableCommand.commandParameterType();
            
            for(int i = 0;i <paramNames.length;i++){
            	if(paramNames[i].isEmpty() || paramNames[i].length() <= 0) continue;
            	CommandParameter cp = new com.bds.cp.bean.CommandParameter(paramNames[i], paramNameDescription[i], CommandParameterType.getCommandParameterType(paramType[i]));
            	commandMetaData.addParamNameAndDescription(paramNames[i], cp);
            }
        }
        LogUtil.log(CPUtil.class, Level.INFO, "Done collecting parameter metadata for command name : " + commandName);
        return commandMetaData;
    }    
}