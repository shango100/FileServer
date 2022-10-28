package org.example.prototypes;

import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;

import junit.framework.TestCase;

public class ServerTest extends TestCase {
    Server s = new Server(5000);
    public void testStart() {
        try {
            s.start(5000);
        }catch (IOException e){
            System.out.println(e);
        }
    }

    public void testConnect() throws IOException {
        try {
            s.start(5000);
            s.connect(5000);
        }catch (IOException e){
            System.out.println(e);
        }
    }

    public void testDisconnect() {
        try {
            s.start(5000);
            s.connect(5000);
            s.disconnect();
        }catch (IOException e){
            System.out.println(e);
        }
    }

    public void testOpenInputStream() {
        try {
            s.start(5000);
            s.connect(5000);
            DataInputStream ins = null;

            try{
                 ins = s.openInputStream();
            }catch (IOException exc){
                System.out.println("Error occurred while opening the input stream");
            }
            String line = "";
            while (!line.equals("Over")){
                try{
                    line = ins.readUTF();
                    System.out.println(line);
                }catch (IOException e){
                    System.out.println(e);
                }
            }
        }catch (IOException e){
            System.out.println(e);
        }
    }

    public void testCloseInputStream() throws IOException {
        try {
            s.start(5000);
            s.connect(5000);
            DataInputStream ins = null;

            try{
                ins = s.openInputStream();
            }catch (IOException exc){
                System.out.println("Error occurred while opening the input stream");
            }
            String line = "Over";//To avoid this depending on the client to issue Over command we assign line to over so the test ends
            while (!line.equals("Over")){
                try{
                    line = ins.readUTF();
                    System.out.println(line);
                }catch (IOException e){
                    System.out.println(e);
                }
            }
        }catch (IOException e){
            System.out.println(e);
        }finally {
            s.closeInputStream();
            System.out.println("Input stream has been closed successfully");
        }
    }

    public void testOpenOutputStream() {
    }

    public void testCloseOutputStream() {
    }
    public void testSaveInputStream(){

    }

    public void testTestSaveInputStream() {
        try{
            /* Initialise server*/
            s.start(5000);
            s.connect(5000);
            DataInputStream ins = null;

            /*open input stream for client to write*/
            try{
                ins = s.openInputStream();
                File testFile = new File("testfile");
                while (ins.readUTF()!="Over"){
                    testFile = s.saveInputStream(ins,testFile.getName());
                }
                System.out.println("File writing complete");
            }catch (IOException exc){
                System.out.println(exc);
            }
        }catch (IOException exception){
            System.out.println(exception);
        }

    }
}