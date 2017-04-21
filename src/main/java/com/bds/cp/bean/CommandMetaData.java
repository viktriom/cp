package com.bds.cp.bean;

/**
 * Created by sonu on 17/02/17.
 */
public class CommandMetaData {
    private String commandName;
    private String commandDescription;
    private String[] commandParams;
    private String[] commandParamDescriptions;

    public CommandMetaData() {
    }

    public CommandMetaData(String commandName, String commandDescription, String[] commandParams, String[] commandParamDescriptions) {
        this.commandName = commandName;
        this.commandDescription = commandDescription;
        this.commandParams = commandParams;
        this.commandParamDescriptions = commandParamDescriptions;
    }


    public String getCommandName() {
        return commandName;
    }

    public void setCommandName(String commandName) {
        this.commandName = commandName;
    }

    public String getCommandDescription() {
        return commandDescription;
    }

    public void setCommandDescription(String commandDescription) {
        this.commandDescription = commandDescription;
    }

    public String[] getCommandParams() {
        return commandParams;
    }

    public void setCommandParams(String[] commandParams) {
        this.commandParams = commandParams;
    }

    public String[] getCommandParamDescriptions() {
        return commandParamDescriptions;
    }

    public void setCommandParamDescriptions(String[] commandParamDescriptions) {
        this.commandParamDescriptions = commandParamDescriptions;
    }
}
