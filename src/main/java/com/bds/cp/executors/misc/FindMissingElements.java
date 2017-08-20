package com.bds.cp.executors.misc;

import java.util.Set;

import com.bds.cp.annotations.ExecutableCommand;
import com.bds.cp.bean.Command;
import com.bds.cp.executors.Executable;
import com.vt.o2f.dataReader.FileDataReader;
import com.vt.o2f.dataReader.FileDataStore;

@ExecutableCommand(
		commandDescription = "Compares two lists (read from a file) and finds the element present in list 2 but not in list one. The missing elements are marked with a blank line.", commandParams = {"l1","l2","op"}, 
		commandParamsDescription = {"Name of the file from which to read the first list","Name of the file from which to read the second list", "Output File Name"},
		commandParameterType = {"File", "File", "String"}
)
public class FindMissingElements implements Executable{

	@Override
	public String execute(Command command) {
		String fileNameForL1 = command.getValueForParam("l1");
		String fileNameForL2 = command.getValueForParam("l2");
		
		FileDataReader fileReader1 = new FileDataReader(fileNameForL1);
		FileDataReader fileReader2 = new FileDataReader(fileNameForL2);
		
		Set<String> list1, list2;
		
		FileDataStore store1 = fileReader1.readFile();
		FileDataStore store2 = fileReader2.readFile();
		
		return null;
	}

	@Override
	public Command commandProcessor(String stringCommand) {
		// TODO Auto-generated method stub
		return null;
	}

}
