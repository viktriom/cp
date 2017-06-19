package com.bds.cp.pi;

import org.apache.log4j.Level;

import com.bds.cp.core.util.LogUtil;
import com.bds.cp.executors.test.GenCombinations;

/**
 * A controller for an LED at pin 6 and a Button at pin 7.
 *
 * Creates an LED (called led) and a Button (called button) for you to control.
 *
 * Class used for the BlueJ on Raspberry Pi turorial.
 *
 */
public class LEDController implements ButtonListener
{
    private LED led;
    private Button button;
    private static LEDController ledController;

    /**
     * Setup the LEDController.
     */
    public LEDController()
    {
        led = new LED(6);             // Create the LED at pin 6 controlled by this
        button = new Button(7);       // Create the Button at pin 7 controlled by this
        button.addListener(this);     // Make the button tell us when it has changed (See buttonChanged() below)
    }

    /**
     * Turn the led on.
     * (Exercise 1.2)
     *
     */
    public void turnLEDOn()
    {
        led.on();
    }

    /**
     * Turn the led off.
     * (Exercise 1.2)
     *
     */
    public void turnLEDOff()
    {
        led.off();
    }

    /**
     * Keep the LED on for a given period of time, then turn it off.
     * @param time the length of the flash in milliseconds (1/1000ths of a second).
     * (Exercise 1.3)
     *
     */
    public void flash(int time)
    {
        turnLEDOn();
        sleepMillisec(time);
        turnLEDOff();
    }

    /**
     * Blink the LED a number of times, each time the LED is kept on for a given period.
     * (Exercise 1.4)
     *
     */
    public void flashSOS(int count, int intervelInMills)
    {
        for(int i =0;i < count; i++){
            turnLEDOn();
            sleepMillisec(intervelInMills);
            turnLEDOff();
            sleepMillisec(intervelInMills);
        }
    }

    /**
     * To be called by the Button when it is pressed or released.
     * (Exercises 2.1, 2.2 and 2.3)
     *
     */
    public void buttonChanged(boolean isPressed)
    {
    	LogUtil.log(LEDController.class, Level.INFO, "Method called.");
        if(isPressed){
            turnLEDOn();
        }else{
            turnLEDOff();
        }
    }

    /**
     * Returns the amount of time in milliseconds between the LED turning on and the button being pressed.
     * @return the reaction time in milliseconds.
     * (Exercise 2.4)
     *
     */
    public int reactionTime()
    {
        // Replace the line below with your code
        return 0;
    }


   /*
    *  You don't need to change the methods below this point.
    *  They are just to help you with the examples on the web page.
    */

    /**
     * Cause the program to sleep for a short time.
     * @param the number of milliseconds to sleep.
     *
     */
    public void sleepMillisec(int millisec)
    {
        try
        {
            Thread.sleep(millisec);
        }
        catch ( InterruptedException e)
        {
        }
    }

    private static long startTime = System.currentTimeMillis();

    /**
     * The current time, measured in milliseconds since the program started.
     * @return integer with measured time in milliseconds.
     *
     */
    public int timeNow()
    {
        return ((int) (System.currentTimeMillis() - startTime));
    }

    public static LEDController getLEDController(){
        if(null == ledController)
            ledController = new LEDController();
        return ledController;
    }

}