package com.bds.cp.executors.pi.led;

import com.bds.cp.annotations.ExecutableCommand;
import com.bds.cp.bean.Command;
import com.bds.cp.executors.Executable;
import com.bds.cp.pi.Button;
import com.bds.cp.pi.LED;
import com.bds.cp.pi.LEDController;

/**
 * Created by sonu on 10/12/16.
 */
@ExecutableCommand(commandDescription = "Turns the LED OFF connected to Raspberry PI's GPIO pin 7", commandParams = {}, commandParamsDescription = {}, commandParameterType={})
public class TurnOff implements Executable{

    public String execute(Command command) {
        LEDController ledController = LEDController.getLEDController();
        ledController.turnLEDOff();
        return "LED Turned OFF.";
    }

    public Command commandProcessor(String stringCommand) {
        return null;
    }
}
