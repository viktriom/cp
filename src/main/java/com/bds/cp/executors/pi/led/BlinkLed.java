package com.bds.cp.executors.pi.led;

import com.bds.cp.annotations.ExecutableCommand;
import com.bds.cp.bean.Command;
import com.bds.cp.core.util.CPUtil;
import com.bds.cp.executors.Executor;
import com.bds.cp.pi.LED;
import com.bds.cp.pi.LEDController;

/**
 * Created by sonu on 11/12/16.
 */

@ExecutableCommand(commandDescription = "Blinks the LED connect Raspberry PI's GPIO pin 7", 
commandParams = {"0",""}, commandParamsDescription = {"Number of time the led is to be blinked","Time to wait for between consecutive Bliks"},
commandParameterType={"String", "String"})
public class BlinkLed implements Executor {
    public void execute(Command command) {
        int count;
        String ct = command.getArgumentForOption(0);
        if(CPUtil.isConvertibleToInt(ct) && ct.length() > 0)
            count = Integer.parseInt(command.getArgumentForOption(0));
        else
            count = 10;
        int waitTime = 1000;
        String wt = command.getArgumentForOption(1);
        if(wt == null || wt.length() <= 0 || CPUtil.isConvertibleToInt(ct))
            waitTime = 1000;
        else
            waitTime = Integer.parseInt(wt);

        LEDController ledController = LEDController.getLEDController();
        ledController.flashSOS(count, waitTime);

    }

    public Command commandProcessor(String stringCommand) {
        return null;
    }
}
