package org.example.network;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private ServerSocket server = null;
    private Socket socket = null;
    private  DataInputStream in = null;


    public Server(int port){
        try {
            server = new ServerSocket(port);
            System.out.println("Server started!");
            System.out.println("Waiting for client to connect...");
            socket = server.accept();
            System.out.println("Client accepted !");

            in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));

            String line = "";

            while (!line.equals("Over")){
                try{
                    line = in.readUTF();
                    System.out.println(line);
                }catch (IOException e){
                    System.out.println(e);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //close connection
        try{
            in.close();
            socket.close();
        }catch (Exception i){
            System.out.println(i);
        }
    }


    public static void main(String args[]) throws IOException {
//        Server server = new Server(5000);
        org.example.prototypes.Server server1 =new org.example.prototypes.Server(5000);
        server1.start(5000);
        server1.connect(5000);
        server1.setDataInputStream((DataInputStream) server1.getSocket().getInputStream());
     /* TODO Fix this error Exception in thread "main" java.lang.ClassCastException: class java.net.Socket$SocketInputStream cannot be cast to class java.io.DataInputStream (java.net.Socket$SocketInputStream and java.io.DataInputStream are in module java.base of loader 'bootstrap')
        	at org.example.network.Server.main(Server.java:57)*/
        server1.openOutputStream();
        String line = "";

        while (!line.equals("Over")){
            try{
                line = server1.getDataInputStream().readUTF();
                System.out.println(line);
            }catch (IOException e){
                System.out.println(e);
            }
        }
    }
}
