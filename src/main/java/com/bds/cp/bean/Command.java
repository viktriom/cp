package com.bds.cp.bean;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Command{
	
	//Declaration of instances
	
	//The basic command
	private String command;
	
	//The options and arguments for this command.

    //private Map<Character,String> argsWithOptions;
	private Map<String,String> argsWithOptions;
	
	//The option counter;
	int argumentCount;
	
	//The default constructor
	public Command(){
        //argsWithOptions = new LinkedHashMap<Character,String>();
		argsWithOptions = new LinkedHashMap<String,String>();
		command = "";
		argumentCount =0;
	}
	
	
	public void setCommand(String command){
		this.command = command;
	}
	
	public String getCommandName(){
		return this.command;
	}

    //public void setArgumentForOption(char option, String argument){
	public void setArgumentForOption(String option, String argument){
        //argsWithOptions.put(Character.valueOf(option),argument);
    	argsWithOptions.put(option,argument);
        this.argumentCount ++;
    }

    public String getArgumentForOption(String option){
        return argsWithOptions.get(option);
    }

    public String getArgumentForOption(int option){
        return argsWithOptions.get(String.valueOf(option));
    }
	
	public String getAllArgumentsAsString(){
		String arguments="";
        int j =0;
        //Set<Character> keys = argsWithOptions.keySet();
        Set<String> keys = argsWithOptions.keySet();
		//for(char ch : keys){
        for(String ch : keys){
			if(j< keys.size())
                arguments = arguments+" ";
            arguments = arguments + argsWithOptions.get(ch);
            j++;
		}
		return arguments.trim();
	}
	
	
	public int getArgumentsCount(){
		return argumentCount;
	}
	
	public String toString(){

        String strCmd = command + " ";
        String options="-";
        String args = "";
        int j =0;
		//Set<Character> keys = argsWithOptions.keySet();
        Set<String> keys = argsWithOptions.keySet();
		
        for(String ch : keys){
        	if(j==0)
        		options = options + String.valueOf(ch);
        	else
        		options = options + "." + String.valueOf(ch);

			if(j==0)
				args = args + argsWithOptions.get(ch);
			else
				args = args + " " + argsWithOptions.get(ch);
			j++;
		}
        strCmd = strCmd + options + " " + args;
		return strCmd;
	}
}
