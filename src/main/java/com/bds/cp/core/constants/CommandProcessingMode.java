package com.bds.cp.core.constants;

/**
 * Created by sonu on 10/12/16.
 */
public enum CommandProcessingMode {
    COMMANDLINE,
    NETWORK;

    private String cpMode;

    public static CommandProcessingMode getCommandProcessingMode(String cpMode){
        for(CommandProcessingMode cpm : CommandProcessingMode.values()){
            if(cpm.name().equals(cpMode))
                return cpm;
        }
        return null;
    }

}
