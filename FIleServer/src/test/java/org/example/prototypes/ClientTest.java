package org.example.prototypes;

import java.io.IOException;

import junit.framework.TestCase;

public class ClientTest extends TestCase {
    Client client = new Client(5000,"127.0.0.1");
    public void testConnect() {
        try{
            client.connect(5000);
        }catch (IOException e){
            System.out.println(e);
        }
    }

    public void testDisconnect() {
        try {
            client.connect(5000);
            if (client.getSocket()!=null){
                client.disconnect();
            }else {

            }
        }catch (IOException exception){
            System.out.println(exception);
        }
    }

    public void testOpenInputStream() {
        try {
            client.connect(5000);
            client.openInputStream();

        }catch (IOException exception){
            System.out.println(exception);
        }finally {
            System.out.println("Input stream was opened successfully");
        }
    }

    public void testCloseInputStream() {
        try {
            client.connect(5000);
            client.openInputStream();

        }catch (IOException exception){
            System.out.println(exception);
        }finally {
            System.out.println("Input stream was opened successfully");
            try{
                client.closeInputStream();
            }catch (IOException exception){
                System.out.println(exception);
            }finally {
                System.out.println("Input stream was closed successfully");
            }
        }
    }

    public void testOpenOutputStream() {
    }

    public void testCloseOutputStream() {
    }
}