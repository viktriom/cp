package com.bds.cp.executors;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.log4j.Level;

import com.bds.cp.annotations.ExecutableCommand;
import com.bds.cp.bean.Command;
import com.bds.cp.core.util.CPUtil;
import com.bds.cp.core.util.LogUtil;

//CompuShare -i.n 100ary:50vt:200amy:90vs:200amy:100vt:110vs:200ary "ary=Arun Yadav:vt=Vivek Tripathi:amy=Amar Yashpal:vs=Vikas Singh"
@ExecutableCommand(commandDescription = "Given amount spend be individula of a group, the command computes the share to be paid by each member to each member.", 
commandParams = {"i"}, 
commandParamsDescription = {"The string containing the information about the amount paid by each individual."},
commandParameterType = {"String"})
public class CompuShare implements Executable {

	@Override
	public String execute(Command command) {
		LogUtil.log(this.getClass(), Level.INFO, "Starting Share computation.");
		String spendString = command.getValueForParam("i");
		String names = command.getValueForParam("n");
		String[] expences = spendString.split(":");
	
		Map<String, Integer> expMap = new LinkedHashMap<>(); 
		for(String str : expences){
			int amt = CPUtil.extractNumericPortionFromString(str);
			System.out.println(amt);
			String name = CPUtil.extractNonNumericPortionFromString(str);
			System.out.println(name);
			expMap.put(name, amt);
		}
		
		LogUtil.log(this.getClass(), Level.INFO, "Share Computation completed.");
		
		return null;
	}

	@Override
	public Command commandProcessor(String stringCommand) {
		// TODO Auto-generated method stub
		return null;
	}

}
