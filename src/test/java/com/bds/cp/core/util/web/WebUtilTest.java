package com.bds.cp.core.util.web;

import com.bds.cp.annotations.ExecutableCommand;
import com.bds.cp.bean.CommandMetaData;
import com.bds.cp.core.util.CPStartupUtil;
import com.bds.cp.core.util.CPStore;
import com.bds.cp.core.util.CPUtil;
import com.bds.cp.executors.Executor;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sonu on 17/02/17.
 */
public class WebUtilTest {
    @Before
    public void setUp() throws Exception {
        CPStartupUtil.loadCommands();
        CPUtil.loadPropertiesFileIntoClass(CPUtil.getPathForString("cp.properties"), "CPConstants",true);
    }

    @Test
    public void parseCommandIntoWebInfo() throws Exception {
        String commandName = "com.bds.cp.executors.SetContext";
        Executor cmd = CPStore.getCommandFromCommandStore(commandName);
        CommandMetaData commandMetaData = WebUtil.getCommandMetadata(commandName);
        assertNotNull(commandMetaData);
        assertEquals(commandName, commandMetaData.getCommandName());
        assertNotNull(commandMetaData.getCommandDescription());
        assertEquals("Sets the context from which the command is to be executed.", commandMetaData.getCommandDescription());
        assertNotNull(commandMetaData.getCommandParams());
        assertNotNull(commandMetaData.getCommandParamDescriptions());
    }

}