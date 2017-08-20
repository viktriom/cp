package com.bds.cp.bean;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Command{
	
	private String commandName;
	private Map<String,String> params;
	
	public Command(){
		params = new LinkedHashMap<String,String>();
		commandName = "";
	}
	
	
	public void setCommandName(String command){
		this.commandName = command;
	}
	
	public String getCommandName(){
		return this.commandName;
	}

	public void addParameterToCommand(String paramName, String paramValue){
    	params.put(paramName,paramValue);
    }

    public String getValueForParam(String paramName){
        return params.get(paramName);
    }

    public String getValueForParamByPosition(int pos){
        String param = null;
        int index = 0;
        for(String key : params.keySet()){
        	if(pos < 0)
        		break;
        	if(index == pos){
        		param = params.get(key);
        		break;
        	}
        	index ++;
        }
        return param;
    }
	
    public int getParameterCount(){
    	if(params.isEmpty())return 0;
    	return params.keySet().size();
    }
    
	public String getAllParamsAsString(){
		String arguments="";
        int j =0;
        Set<String> keys = params.keySet();
        for(String ch : keys){
			if(j< keys.size())
                arguments = arguments+" ";
            arguments = arguments + params.get(ch);
            j++;
		}
		return arguments.trim();
	}
	
	public String toString(){

        String strCmd = commandName + " ";
        String options="-";
        String args = "";
        int j =0;
        Set<String> keys = params.keySet();
		
        for(String ch : keys){
        	if(j==0)
        		options = options + String.valueOf(ch);
        	else
        		options = options + "." + String.valueOf(ch);

			if(j==0)
				args = args + params.get(ch);
			else
				args = args + " " + params.get(ch);
			j++;
		}
        strCmd = strCmd + options + " " + args;
		return strCmd;
	}
}
