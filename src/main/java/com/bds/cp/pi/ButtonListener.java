package com.bds.cp.pi;

/**
 * The ButtonListener interface is used by the Button class to tell other objects if it is being pressed.
 *
 * If you want to find out when a button changes, create an object which implements this interface, and
 * "register" it using the Button's addListener method.
 *
 * @author Michael Kölling
 * @author Fabio Hedayioglu
 * @author Ian Utting
 * @version 1.0
 *
 */

public interface ButtonListener
{
    /**
     * Callback method invoked whenever the Button changes state (pressed or released)
     * @param   isPressed   The state of the button after the change.
     *
     */
    public void buttonChanged(boolean isPressed);
}