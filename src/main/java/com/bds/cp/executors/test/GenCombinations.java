package com.bds.cp.executors.test;

import com.bds.cp.annotations.ExecutableCommand;
import com.bds.cp.bean.Command;
import com.bds.cp.executors.Executor;

@ExecutableCommand(commandDescription = "Generates all possible combinations of a string", 
commandParams = {"The string whose possible combinations are to be generated"}, commandParamsDescription = {"0"},
commandParameterType={"String"})
public class GenCombinations implements Executor {

	public void execute(Command command) {
		String permutationString = command.getArgumentForOption(0);
		char[] pChars = permutationString.toCharArray();
		int totalChars = pChars.length;
		int totalCombinations = getTotalPermutations(totalChars);
		System.out.println("Total no. Of combination possible for the string are " + totalCombinations);
		for(int i=0;i<totalCombinations;i++){
			for(int j=0;j<totalChars;j++){
				
			}
		}
	}
	
	private char getCharacterforPosition(){
		char ch=' ';
		
		return ch;
	}

	
	private int getTotalPermutations(int totalChars){
		int noOfPermutations = 1;
		
		for(int i=totalChars;i>0;i--){
			noOfPermutations = noOfPermutations*i;
		}
		
		
		return noOfPermutations;
	}
	
	public Command commandProcessor(String stringCommand) {
		return null;
	}

}
