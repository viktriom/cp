package com.bds.cp.core;

import com.bds.cp.core.constants.CPConstants;
import com.bds.cp.core.constants.CommandProcessingMode;
import com.bds.cp.core.listener.CLCommandListener;
import com.bds.cp.core.network.Server;
import com.bds.cp.core.util.LogUtil;
import com.bds.cp.core.util.CPStartupUtil;

import org.apache.log4j.Level;

import java.io.IOException;

public class Main {

	public static void main(String args[]){
				
		CPStartupUtil.initializeCommandProcessingSystem();

		if(CPConstants.getCommandProcessingMode() == CommandProcessingMode.COMMANDLINE) {
			LogUtil.log(Main.class, Level.INFO, "Application is configured to run in CommandLine Mode, Starting it in command line mode now.");
			Thread t = new Thread(new CLCommandListener());
			t.start();
		}else if(CPConstants.getCommandProcessingMode() == CommandProcessingMode.NETWORK) {
			LogUtil.log(Main.class, Level.INFO, "Application is configured to run in " + CommandProcessingMode.NETWORK.name() + " mode, network mode stating now.");
			try {
				Thread srvr = new Server(CPConstants.getNetworkListenerPort());
				srvr.start();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}