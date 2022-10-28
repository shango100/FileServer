package org.example;

import java.io.InputStreamReader;
import java.util.Scanner;

import org.example.command.CommandParser;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello Welcome to our File server!" );
        System.out.println( "Type in a command add!" );
        Scanner scan = new Scanner(new InputStreamReader(System.in));
        CommandParser commandParser = new CommandParser("","");
            while(true){
                commandParser.acceptCommand();
                commandParser.runcommand(scan.next());

            }


    }
}
