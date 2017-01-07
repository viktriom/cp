package com.bds.cp.core.network;

import com.bds.cp.core.listener.NetworkCommandListener;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by sonu on 05/12/16.
 */
public class Server extends Thread{

    private ServerSocket serverSocket = null;
    private NetworkCommandListener client = null;

    public Server(int port) throws IOException{
        serverSocket = new ServerSocket(port);
    }

    public void run(){
        System.out.println("Listening on port : " + serverSocket.getLocalPort() + "....");
        while(true) {
            try {
                Socket socket = serverSocket.accept();
                System.out.println("Incoming connection request accepted from : " + socket.getRemoteSocketAddress());
                addThread(socket);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public void addThread(Socket socket)
    {  System.out.println("Client accepted: " + socket);
        client = new NetworkCommandListener(this, socket);
        try {
            client.open();
            client.start();
        } catch(IOException ioe)
        {  System.out.println("Error opening thread: " + ioe); }
    }

}
