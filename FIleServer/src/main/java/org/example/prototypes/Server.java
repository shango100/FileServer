package org.example.prototypes;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Peer{

    private ServerSocket server = null;

    /**
     * Constructs a peer object with a given port
     *
     * @param port
     */
    public Server(int port) {
        super(port);
    }


    /**
     * @param port
     * @throws IOException
     */
    public void start(int port) throws RuntimeException, IOException {
        server = new ServerSocket(port);
        System.out.println("Server started!");
        System.out.println("Waiting for client to connect...");
    }

    @Override
    public void connect(int port) throws IOException {
        super.setSocket(server.accept());
        System.out.println("Client accepted !");
    }

    /**
     * @throws IOException
     */
    @Override
    public void disconnect() throws IOException {
        getSocket().close();
        System.out.println("server disconnected !");
    }

    /**Opens an input stream through which clients can send data. Also returns a DataInputStream object
     * @return
     * @throws IOException
     */
    @Override
    public DataInputStream openInputStream() throws IOException {
        DataInputStream inputStream = new DataInputStream(super.getSocket().getInputStream());
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
        /**to be implemented */
        DataOutputStream out = new DataOutputStream(System.out);
        return out;
    }

    /**
     * @throws IOException
     */
    @Override
    public void closeOutputStream() throws IOException {
        /**to be implemented */
        if(getDataOutputStream()!=null)
            getDataOutputStream().close();
        System.out.println("Output stream closed");
    }
    /**Takes a stream as parameter and saves it to a file in the server.
     * Returns an object of type file
     * @param dataInputStream
     * @param filename  represents the name of the file to be stored*/
    public File saveInputStream(DataInputStream dataInputStream,String filename) throws FileNotFoundException {
        File clientFile = new File(filename);
        //remember to handle case where file already exists

        PrintStream printStream = new PrintStream(clientFile);
        try{
            printStream.print(this.openInputStream());
        } catch (IOException e) {
            System.out.println("error occured while printing input stream ");
            throw new RuntimeException(e);
        }

        return clientFile;
    }

}
