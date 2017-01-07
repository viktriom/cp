package com.bds.cp.executors.pi.led;

import com.bds.cp.annotations.ExecutableCommand;
import com.bds.cp.bean.Command;
import com.bds.cp.executors.Executor;
import com.bds.cp.pi.LED;
import com.bds.cp.pi.LEDController;

/**
 * Created by sonu on 10/12/16.
 */
@ExecutableCommand
public class TurnOn implements Executor{
    public void execute(Command command) {
        LEDController ledController = LEDController.getLEDController();
        ledController.turnLEDOn();
    }

    public Command commandProcessor(String stringCommand) {
        return null;
    }
}
