package com.bds.cp.executors;

import com.bds.cp.annotations.ExecutableCommand;
import com.bds.cp.bean.Command;


@ExecutableCommand
public class Exit implements Executor{
	
	
	//the default constructor.
	public Exit(){

	}

	public void execute(Command command){
		System.out.println("Bye");
		System.exit(0);
	}

    public Command commandProcessor(String stringCommand) {
        return null;
    }
}
