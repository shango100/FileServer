package org.example.command;

import java.io.InputStreamReader;
import java.util.Scanner;

/*
A command parser gets a string and returns  a message
* */
public class CommandParser {
    //command
    private String command;
    private String message;

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public CommandParser(String command, String message) {
        this.command = command;
        this.message = message;
    }
    public void runcommand(String command){
        if(!(command.contains("exit"))){
//            System.out.print(">");
//            Scanner scan = new Scanner(new InputStreamReader(System.in));
            if (command.contains("add")){
                System.out.println("add operation successful");
            } else if (command.contains("get")) {
                System.out.println(" get operation successful");
            }
            else if (command.contains("delete")){
                System.out.println("delete operation successful");
            } else if (command.equals("\n")) {
                System.out.println("Type a command pls. If u dont know pls type help");
            } else{
                System.out.println("Mensch! can u just stick to the given commands pls");
            }
        }
    }

    public void acceptCommand(){
        System.out.print(">");
    }
}
