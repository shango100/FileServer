package org.example.command;

import junit.framework.TestCase;

public class CommandParserTest extends TestCase {
    CommandParser commandParser = new CommandParser("create parser","this is a test command parser object");

    public void testGetCommand() {
        assertEquals(commandParser.getCommand(),"create parser");
    }

    public void testSetCommand() {
//        assertEquals(commandParser.setCommand("Get File"),"create parser");
    }

    public void testGetMessage() {
    }

    public void testSetMessage() {
    }

    public void testRuncommand() {
    }

    public void testAcceptCommand() {
    }
}