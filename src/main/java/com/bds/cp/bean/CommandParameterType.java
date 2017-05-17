package com.bds.cp.bean;

public enum CommandParameterType{
	FILE("File"),
	STRING("String");
	
	private String commandParamType;
	
	private CommandParameterType(String commandParamType){
		this.commandParamType = commandParamType;
	}
	
	public static CommandParameterType getCommandParameterType(String cmdParamType){
		 for(CommandParameterType type : CommandParameterType.values()){
			 if(type.commandParamType.equals(cmdParamType))
				 return type;
		 }
		 throw new EnumConstantNotPresentException(CommandParameterType.class, cmdParamType);
	}
}
