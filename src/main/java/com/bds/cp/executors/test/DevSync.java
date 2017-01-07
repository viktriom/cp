package com.bds.cp.executors.test;

import com.bds.cp.annotations.ExecutableCommand;
import com.bds.cp.bean.Command;
import com.bds.cp.executors.Executor;

/**
 * @author tripvi
 * Sends a Development Database Synchronization request from the production server.
 */
@ExecutableCommand
public class DevSync implements Executor {

	//Instance Variables
	private String destination,source;

	
	private void init(){
		destination = "";
		source = "";
	}

	public void execute(Command command) {
		System.out.println("------ DevSync Begin-----");
		init();
		System.out.println("The parameters passed are:");
		source = command.getArgumentForOption(0);
		System.out.println("The source : " + source);
		destination = command.getArgumentForOption(1);
		System.out.println("The destination : " + destination);
		
		System.out.println("------ DevSync End ------");
		
	}

    public Command commandProcessor(String stringCommand) {
        return null;
    }
}
