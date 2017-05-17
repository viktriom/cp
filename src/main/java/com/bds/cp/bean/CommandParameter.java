package com.bds.cp.bean;


public class CommandParameter{
	private String paramName;
	private String paramDescription;
	private CommandParameterType paramType;
	
	public CommandParameter(){
		
	}
	
	public CommandParameter(String paramName, String paramDescription, CommandParameterType paramType) {
		super();
		this.paramName = paramName;
		this.paramDescription = paramDescription;
		this.paramType = paramType;
	}
	public String getParamName() {
		return paramName;
	}
	public void setParamName(String paramName) {
		this.paramName = paramName;
	}
	public String getParamDescription() {
		return paramDescription;
	}
	public void setParamDescription(String paramDescription) {
		this.paramDescription = paramDescription;
	}
	public CommandParameterType getParamType() {
		return paramType;
	}
	public void setParamType(CommandParameterType paramType) {
		this.paramType = paramType;
	}		
}