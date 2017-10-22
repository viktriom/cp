package com.bds.cp.executors;

import java.util.LinkedList;
import java.util.List;

import com.bds.cp.annotations.ExecutableCommand;
import com.bds.cp.bean.Command;

//GenComb -i a,b,c,d:i,j,k:p,q,r,s:w,x,y,z
//GenComb -i 0,1,2,3,4,5,6,7,8,9:0,1,2,3,4,5,6,7,8,9:0,1,2,3,4,5,6,7,8,9:0,1,2,3,4,5,6,7,8,9
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
		int colCt = 0,row = 0,totalComb = 1;
		
		/*Preparing input variable into a list*/
		List<String> comb = new LinkedList<>();
		for(String str : arr){
			String[] s = str.split(",");
			List<String> l = new LinkedList<String>();
			for(String st : s){
				l.add(st);
			}
			colCts[row] = l.size();
			totalComb = totalComb * colCts[row];
			comb.add(row, l.get(0));
			row++;
			colCt = l.size()>colCt?l.size():colCt;
			lst.add(l);
		}
		
		List<List<String>> combs = generateCombinations(lst);
		
		System.out.println(combs.toString());
		System.out.println("The Command completed.");
		
		return combs.toString().replaceAll("], ", "]\n");
		
	}

	@Override
	public Command commandProcessor(String stringCommand) {
		return null;
	}
	
	public List<List<String>> generateCombinations(List<List<String>> lst){
		
		int rowCt = lst.size();
		int[] colCts = new int[rowCt];
		int rowIndex = 0,totalComb = 1;
		List<String> comb = new LinkedList<>();
		
		for(List<String> row : lst){
			colCts[rowIndex] = row.size();
			totalComb = totalComb * colCts[rowIndex];
			comb.add(rowIndex, row.get(0));
			rowIndex++;
		}
		
		System.out.println("colCt = " + colCts[rowIndex-1] + ", rowCt = " + rowCt + ", total combinations: " + totalComb);
		
		List<List<String>> combs = new LinkedList<>();
		
		for(int i =0;i < totalComb; i++){
			int num =i, index = rowCt-1;
			while(num != 0 && index >= 0){
				int value = num%colCts[index];
				comb.remove(index);
				comb.add(index,lst.get(index).get(value));
				num = num/colCts[index];
				index--;
			}
			List<String> temp = new LinkedList<String>();
			temp.addAll(comb);
			combs.add(temp);
		}
		return combs;
	}

}
