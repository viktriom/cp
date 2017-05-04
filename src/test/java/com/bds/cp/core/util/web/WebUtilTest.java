package com.bds.cp.core.util.web;

import com.bds.cp.bean.CommandMetaData;
import com.bds.cp.core.util.CPStartupUtil;
import com.bds.cp.core.util.CPUtil;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sonu on 17/02/17.
 */
public class WebUtilTest {
	
	String commandName = "";
	
    @Before
    public void setUp() throws Exception {
        CPStartupUtil.loadCommands();
        CPUtil.loadPropertiesFileIntoClass(CPUtil.getPathForString("cp.properties"), "CPConstants",true);
        commandName = "com.bds.cp.executors.SetContext";
    }

    @Test
    public void parseCommandIntoWebInfo() throws Exception {
        CommandMetaData commandMetaData = WebUtil.getCommandMetadata(commandName);
        assertNotNull(commandMetaData);
        assertEquals(commandName, commandMetaData.getCommandName());
        assertNotNull(commandMetaData.getCommandDescription());
        assertEquals("Sets the context from which the command is to be executed.", commandMetaData.getCommandDescription());
        assertEquals(new Integer(1), commandMetaData.getParamCount());
        assertNotNull(commandMetaData.getParamNames());
        assertEquals("index 0", commandMetaData.getParamNameAtIndex(0));
        assertNotNull(commandMetaData.getPraramDescriptions());
        assertEquals("The new command context", commandMetaData.getParamDescriptionAtIndex(0));
    }

    @Test
    public void testHtmlConversion(){
    	String htmlData = WebUtil.prepareHTMLForCommandMetadata(commandName);
    	System.out.println(htmlData);
    	assert(true);
    }
    
}