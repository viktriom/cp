package com.bds.cp.pi;

import com.pi4j.io.gpio.*;
import com.pi4j.io.gpio.event.*;

import java.util.Collection;

/**
 * This class represents a Button connected to the Raspberry pi on a given pin.
 * Connect the button to 3.3v power and to a GPIO.
 *
 * @author Fabio Hedayioglu
 * @author Ian Utting
 * @author Michael Kölling
 * @version 1.0
 *
 */
public class Button
{
    // the button instance is an input pin.
    private GpioPinDigitalInput button;

    //this array maps the GPIO pin numbers to integers
    private static final Pin[] pinMap = new Pin[] {RaspiPin.GPIO_00, RaspiPin.GPIO_01, RaspiPin.GPIO_02, RaspiPin.GPIO_03, RaspiPin.GPIO_04,
            RaspiPin.GPIO_05, RaspiPin.GPIO_06, RaspiPin.GPIO_07, RaspiPin.GPIO_08, RaspiPin.GPIO_09, RaspiPin.GPIO_10,
            RaspiPin.GPIO_11, RaspiPin.GPIO_12, RaspiPin.GPIO_13, RaspiPin.GPIO_14, RaspiPin.GPIO_15, RaspiPin.GPIO_16,
            RaspiPin.GPIO_17, RaspiPin.GPIO_18, RaspiPin.GPIO_19, RaspiPin.GPIO_20};

    //the default pin, used by the constructor without parameters.
    private final static int defaultPin = 7;



    /**
     * Creates a Button at the default GPIO pin (7).
     *
     */
    public Button()
    {
        //create the Button in the default pin.
        this(defaultPin);
    }


    public Button(int p)
    {
        //get a gpio controller
        GpioController gpio = GpioFactory.getInstance();
        Collection<GpioPin> existingPins = gpio.getProvisionedPins();

        //if this button wasn't previously privioned, do it.
        button = getProvidedPin(pinMap[p]);
        if (button == null){
            button = gpio.provisionDigitalInputPin(pinMap[p], PinPullResistance.PULL_DOWN);
        }

    }

    private GpioPinDigitalInput getProvidedPin(Pin desiredPin)
    {
        GpioController gpio = GpioFactory.getInstance();
        Collection<GpioPin> existingPins = gpio.getProvisionedPins();
        for (GpioPin pin:existingPins){
            if (pin.getPin() == desiredPin){
                //this pin is already provisioned. take it.
                return (GpioPinDigitalInput) pin;
            }
        }
        return null; //not found
    }

    /**
     * Checks in the button is pressed.
     *
     */
    public boolean isPressed()
    {
        return button.isHigh();
    }

    /**
     * Add a listener to this button.
     *
     */
    public void addListener(final ButtonListener listener)
    {
        //creates a GpioPinListener to listen to this pin..
        GpioPinListenerDigital l = new GpioPinListenerDigital() {
            public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event)
            {
                //checks if the raised event is for this pin.
                if (event.getPin().getName().equals(button.getPin().getName())){
                    //if it is, then call the event buttonChange in  our ButtonListener class and pass the
                    //current state of the button (pressed = true, released = false)
                    listener.buttonChanged(event.getState().isHigh());
                }
            }
        };
        //add the listener to this button.
        button.addListener(l);
    }

    /**
     * Remove all listeners from this button.
     *
     */
    public void removeAllListeners()
    {
        button.removeAllListeners();
    }

}