package com.bds.cp.core;

import com.bds.cp.core.constants.CPConstants;
import com.bds.cp.core.constants.CommandProcessingMode;
import com.bds.cp.core.listener.CLCommandListener;
import com.bds.cp.core.network.Server;
import com.bds.cp.core.util.CPUtil;
import com.bds.cp.core.util.CPStartupUtil;
import org.apache.log4j.Logger;

import java.io.IOException;

public class Main {

	public static void main(String args[]){
		Logger log = Logger.getLogger(Main.class);
		CPStartupUtil.loadCommands();

		CPUtil.loadPropertiesFileIntoClass(CPUtil.getPathForString("cp.properties"), "CPConstants",true);

		if(CPConstants.getCommandProcessingMode() == CommandProcessingMode.COMMANDLINE) {
			log.info("Application is configured to run in CommandLine Mode, Starting it in command line mode now.");
			Thread t = new Thread(new CLCommandListener());
			t.start();
		}else if(CPConstants.getCommandProcessingMode() == CommandProcessingMode.NETWORK) {
			log.info("Application is configured to run in " + CommandProcessingMode.NETWORK.name() + ", mode, network mode stating now.");
			try {
				Thread srvr = new Server(CPConstants.getNetworkListenerPort());
				srvr.start();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}