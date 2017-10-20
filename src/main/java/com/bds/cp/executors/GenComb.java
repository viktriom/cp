package com.bds.cp.executors;

import java.util.LinkedList;
import java.util.List;

import com.bds.cp.annotations.ExecutableCommand;
import com.bds.cp.bean.Command;

//GenComb -i a,b,c,d:i,j,k:p,q,r,s:w,x,y,z
@ExecutableCommand(commandDescription = "Generate Combinations, for given array of strings.", 
commandParams = {"i"}, 
commandParamsDescription = {"The string for which combination is to be generated."},
commandParameterType = {"String"})
public class GenComb implements Executable {

	@Override
	public String execute(Command command) {
		System.out.println("Starting command execution.");
		String input = command.getValueForParam("i");
		System.out.println("The input is : " + input);
		List<List<String>> lst = new LinkedList<>();
		String[] arr = input.split(":");
		int rowCt = arr.length;
		int[] colCts = new int[rowCt];
		int colCt = 0,row = 0;
		for(String str : arr){
			String[] s = str.split(",");
			List<String> l = new LinkedList<String>();
			for(String st : s){
				l.add(st);
			}
			colCts[row++] = l.size();
			colCt = l.size()>colCt?l.size():colCt;
			lst.add(l);
		}
		int totalComb = 1;
		for(int i = 0;i < rowCt; i++){
			totalComb = totalComb * colCts[i];
		}
		
		
		System.out.println("colCt = " + colCt + ", rowCt = " + rowCt + ", total combinations: " + totalComb);
		
		int[] indices = new int[rowCt]; 
		for(int r = 0;r < rowCt; r++){
			indices[r] = 0;
		}
		
		for(int i =0;i < totalComb; i++){
			int num =i, index = rowCt-1;
			while(num != 0 && index <= rowCt){
				indices[index] = num%colCts[index--];
				num = num/colCt;
			}
			
			System.out.print(i + "> ");
			for(int r = 0;r < rowCt; r++){
				System.out.print(lst.get(r).get(indices[r]) + ",");
				
			}
			System.out.println();			
		}
		System.out.println("The Command completed.");
		return null;
	}

	@Override
	public Command commandProcessor(String stringCommand) {
		return null;
	}

}
