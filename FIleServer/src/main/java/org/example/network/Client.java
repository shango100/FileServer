package org.example.network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    private Socket socket = null;
    private DataInputStream in = null;
    private DataOutputStream out  = null;

    public Client (String address, int port){

       try{
           System.out.println("Waiting for server.....");
           socket = new Socket(address, port);
           System.out.println("Connected!!!");
           System.out.println("Type an action (type \"Over\" to end connection\n) ");

           in = new DataInputStream(System.in);
           out = new DataOutputStream((socket.getOutputStream()));


       }catch (IOException ex ){
           System.out.println(ex + "; "+ ex.getMessage());
       }

        String line = "";

        while (!line.equals("Over")){
            try{
                line = in.readLine();
                out.writeUTF(line);
            }catch (IOException e){
                System.out.println(e);
            }
        }

        //close the connection
        try{
            in.close();
            out.close();
            socket.close();
        }catch (IOException i){
            System.out.println(i);
        }

}
    public static void main(String args[]) throws IOException {
//        Client client = new Client("127.0.0.1",5000);
        org.example.prototypes.Client client = new org.example.prototypes.Client(5000,"127.0.0.1");

        client.connect(5000);
        client.openInputStream();
        client.openOutputStream();
        client.setDataInputStream(new DataInputStream(System.in));

        String line = "";

        while (!line.equals("Over")){
            try{
                line = client.getDataInputStream().readUTF();
                client.getDataOutputStream().writeUTF(line);
            }catch (IOException e){
                System.out.println(e);
            }
        }
    }
}
