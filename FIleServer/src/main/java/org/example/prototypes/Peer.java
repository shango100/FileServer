package org.example.prototypes;
/*The peer interface defines a blueprint for a client or server */

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.net.Socket;
/**Peer represents the blueprint for the construction of either
 * a Server or client. It defines the basic functionalities and properties of the fore mentioned.
*@author Shango100
*/
public abstract class Peer {
    /**The endpoint for communication with other endpoints*/
    private Socket socket;

    /**A data input stream that allows us to get data from other endpoints*/
    private DataInputStream dataInputStream;

    /**A data output stream that allows us to write data to other endpoints*/
    private DataOutputStream dataOutputStream;

    /**This represents the port on which the Peer is available*/
    private int port;

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    /**Returns a socket object representing the value of our socket  */
    public Socket getSocket() {
        return socket;
    }

    /** Gives us access to set the value of the socket endpoint */
    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public DataInputStream getDataInputStream() {
        return dataInputStream;
    }

    public void setDataInputStream(DataInputStream dataInputStream) {
        this.dataInputStream = dataInputStream;
    }

    public DataOutputStream getDataOutputStream() {
        return dataOutputStream;
    }

    public void setDataOutputStream(DataOutputStream dataOutputStream) {
        this.dataOutputStream = dataOutputStream;
    }

    /**Constructs a peer object with a given port*/
    public Peer(int port) {
        this.port = port;
    }

    /**This method's implementation defines how our Peer connects*/
    public abstract void connect(int port) throws IOException;

    /**This method's implementation defines how our Peer disconnects*/
    public abstract void disconnect() throws IOException;

    /**Opens up a DataInput stream from which other endpoints can send data. Returns a DataInputStreqm
     * object */
    public abstract DataInputStream openInputStream() throws IOException;

    /**Opens up a DataInput stream from which other endpoints can send data.*/
    public abstract void closeInputStream() throws IOException;


    public abstract DataOutputStream openOutputStream() throws IOException;

    public abstract void closeOutputStream() throws IOException;
}
