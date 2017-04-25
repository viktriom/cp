package com.bds.cp.core.util;

import org.apache.log4j.Logger;

/**
 * Created by sonu on 21/04/17.
 */
public class LogUtil {
    public static Logger logger(Class cls){
        return org.apache.log4j.Logger.getLogger(cls);
    }
}
