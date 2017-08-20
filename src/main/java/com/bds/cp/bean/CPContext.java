package com.bds.cp.bean;

import java.util.HashMap;
import java.util.Map;

public class CPContext {

	private static String ctxtName;
	
	private static Map<String, String> ctxtVars = new HashMap<>();
	
	public void setContextName(String contextName){
		this.ctxtName = contextName;
	}
	
	public String getContextName(){
		return this.ctxtName;
	}
	
	public void setContextVariable(String varName, String varValue){
		ctxtVars.put(varName, varValue);
	}
	
	public String getContextVaribale(String varName){
		return ctxtVars.get(varName);
	}
	
	public Map<String, String> getAllSystemVariables(){
		Map<String, String> cvs = new HashMap<>();
		cvs.putAll(ctxtVars);
		return cvs;
	}
}