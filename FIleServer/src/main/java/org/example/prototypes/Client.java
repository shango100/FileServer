package org.example.prototypes;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;

public class Client extends Peer{
    /**This string holds the address of the server to which the Client connects */
    private  String address;
    /**
     * Constructs a peer object with a given port
     *
     * @param port
     */
    public Client(int port) {
        super(port);
    }
    /**
     * Constructs a peer object with a given port and address
     *
     * @param port
     * @param address
     */
    public Client(int port, String address) {
        super(port);
        this.address = address;
    }

    /**
     * Connect Client to server
     * @param port
     * @throws IOException,ConnectException
     */
    @Override
    public void connect(int port) throws IOException,ConnectException {
        System.out.println("Waiting for server.....");
        super.setSocket(new Socket(address,super.getPort()));
        System.out.println("Connected!!!");

    }

    /**
     * @throws IOException
     */
    @Override
    public void disconnect() throws IOException {
        if (super.getSocket()==null){
            System.out.println("Client already disconnected");
        }else {
            super.getSocket().close();
            System.out.println("Client disconnected ");
        }
    }

    /**
     * Opens a stream for client to send data
     * @return
     * @throws IOException
     */
    @Override
    public DataInputStream openInputStream() throws IOException {
//        super.setDataInputStream(System.in);
        DataInputStream inputStream = new DataInputStream(System.in);
        super.setDataInputStream(inputStream);
        return inputStream;
    }

    /**
     * @throws IOException
     */
    @Override
    public void closeInputStream() throws IOException {
        if (getDataInputStream()!=null)
            getDataInputStream().close();
        System.out.println("input stream closed !");
    }

    /**
     * @return
     * @throws IOException
     */
    @Override
    public DataOutputStream openOutputStream() throws IOException {
        DataOutputStream out = new DataOutputStream(System.out);
        return out;
    }

    /**
     * @throws IOException
     */
    @Override
    public void closeOutputStream() throws IOException {
        if (getDataOutputStream()!=null)
            getDataOutputStream().close();
        System.out.println("input stream closed !");
    }
}
