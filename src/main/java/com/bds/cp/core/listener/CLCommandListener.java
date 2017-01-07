package com.bds.cp.core.listener;

import java.io.BufferedInputStream;
import java.util.Scanner;

import com.bds.cp.bean.Command;
import com.bds.cp.core.util.CPUtil;

import org.apache.log4j.Logger;

public class CLCommandListener implements Runnable{
	
	Logger log = Logger.getLogger(CLCommandListener.class);
	//The instance variables.
	private BufferedInputStream bi;
	private Scanner in;
	private String command;
	
	//The default constructor
	public CLCommandListener(){
		bi = new BufferedInputStream(System.in);
		in = new Scanner(bi);
		command = null;
	}
	
	
	/**
	 * This is one of the multiple command processing interfaces. This interface listens 
	 * for the command on the command line. It keeps on listening continuously until the exit command is called.
	 */
	public void run(){
		System.out.println("Listening..");
		String className="";
        String[] cmdParts;
        Command cmd = null;
        String tempAppCtx;


		while(true){
			command = in.nextLine();
			try{
				CPUtil.executeCommand(command);
			} catch (Exception e) {
				log.error("Command not found : " + className);
				log.error(e.getMessage());
				e.getStackTrace();
			}
		}
	}
}
