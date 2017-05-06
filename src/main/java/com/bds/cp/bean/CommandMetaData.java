package com.bds.cp.bean;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by sonu on 17/02/17.
 */
public class CommandMetaData {
    private String commandName;
    private String commandDescription;
    
    private Map<String, String> paramMap = new LinkedHashMap<String,String>();

    public CommandMetaData() {
    }

    public String getCommandName() {
        return commandName;
    }

    public void setCommandName(String commandName) {
        this.commandName = commandName;
    }

    public String getCommandDescription() {
        return commandDescription;
    }

    public void setCommandDescription(String commandDescription) {
        this.commandDescription = commandDescription;
    }

    public void addParamNameAndDescription(String attrib, String value){
    	paramMap.put(attrib,value);
    }
    
    public String getDescriptionForParam(String attribute){
    	return paramMap.get(attribute);
    }
    
    public Integer getParamCount(){
    	return paramMap.keySet().size();
    }
    
    public String getParamNameAtIndex(int index){
    	if(index < 0 || index > paramMap.keySet().size())
    		return null;
    	for(String paramName: paramMap.keySet()){
    		if(index-- <= 0) return paramName;
    		
    	}
    	return null;
    }
    
    public String getParamDescriptionAtIndex(int index){
    	if(index < 0 || index > paramMap.keySet().size())
    		return null;
    	for(String paramName: paramMap.keySet()){
    		if(index-- <= 0) return paramMap.get(paramName);
    		
    	}
    	return null;
    }
    
    public Set<String> getParamNames(){
    	return paramMap.keySet();
    }
    
    public Set<String> getPraramDescriptions(){
    	return paramMap.entrySet().stream().map(e -> e.getValue()).collect(Collectors.toSet());
    }

	@Override
	public String toString() {
		return "CommandMetaData [commandName=" + commandName + ", commandDescription=" + commandDescription
				+ ", attributeMap=" + paramMap + "]";
	}


    
}
