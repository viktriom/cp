package com.bds.cp.core.util;

import static org.junit.Assert.*;

/**
 * Created by sonu on 10/12/16.
 */
public class CPUtilTest {

    @org.junit.Before
    public void setUp() throws Exception {

    }

    @org.junit.Test
    public void loadPropertiesFileIntoClass() throws Exception {

    }

    @org.junit.Test
    public void isConvertibleToInt() throws Exception {
        assertTrue(CPUtil.isConvertibleToInt("123456"));
        assertFalse(CPUtil.isConvertibleToInt("1234xyz"));
        assertFalse(CPUtil.isConvertibleToInt("xyz1234"));
        assertFalse(CPUtil.isConvertibleToInt("1x2y3z4"));
        assertFalse(CPUtil.isConvertibleToInt("xyz"));
        assertFalse(CPUtil.isConvertibleToInt("xy1234z"));
    }

    @org.junit.Test
    public void getPathForString() throws Exception {
        assertEquals("./cp.properties",CPUtil.getPathForString(".:cp.properties"));
    }

    @org.junit.Test
    public void getInitCapString() throws Exception {
        //assertEquals("CommandProcessor", CPUtil.getInitCapString("commandProcessor"));
    }

    @org.junit.Test
    public void parseCommand() throws Exception {

    }

    @org.junit.Test
    public void executorExists() throws Exception {

    }

    @org.junit.Test
    public void getIndexOfCharFromRight() throws Exception {

    }

    @org.junit.Test
    public void getParams() throws Exception {

    }

    @org.junit.Test
    public void prepareQuery() throws Exception {

    }

    @org.junit.Test
    public void obtainParametersForCommand() throws Exception {

    }
    
    @org.junit.Test
    public void  getNumericPortionFromString(String string){
    	String str = "1234ay";
    	int num = CPUtil.extractNumericPortionFromString(str);
    	assertEquals(1234, num);
    	
    }

}