package com.bds.cp.bean;

import com.bds.cp.core.constants.CPConstants;

public class CommandParser {
	private String[] tokens;
	private Command command;
	private String strCmd;
	
	public CommandParser(){
		this.command = new Command();
		this.strCmd = null;
	}
	
	public CommandParser(String strCmd) throws CommandParsingException {
		parseStringIntoCommand(strCmd);
	}
	
	public void parseStringIntoCommand(String strCmd) throws CommandParsingException {
		this.command = new Command();
		this.strCmd = strCmd;
		this.tokens = null;
		stripCommandAndToknizeParameters();
		parseParametersForCommand();
	}
	
	private void stripCommandAndToknizeParameters(){
		tokens = strCmd.split(CPConstants.getCommandStringTokenDelim());
		command.setCommandName(tokens[0]);
		tokens[0] = null;
	}
	
	private void parseParametersForCommand() throws CommandParsingException {
		if(tokens.length > 1){
			if(tokens[1].charAt(0) == CPConstants.getParamNameIndicator().charAt(0) && tokens[1].contains(".")){
				parseParametersHavingAllTheNamesTogether();
			} else {
				parseParametersHavingParamName();
			}
		}
	}
	
	private void parseParametersHavingAllTheNamesTogether() throws CommandParsingException {
		
	}
	
	private void parseParametersHavingParamName() {
		int paramNumber = 0;
		for(int i = 0; i < tokens.length; i++){
			String token = tokens[i];
			if(token != null && token.length() != 0 && (!token.isEmpty())){
				if(String.valueOf(token.charAt(0)).equals(CPConstants.getParamNameIndicator())){
					paramNumber++;
					command.addParameterToCommand(token.substring(1,token.length()), tokens[++i]);
				}else {
					command.addParameterToCommand(String.valueOf(paramNumber++), token);
				}
			}
		}
	}
}
