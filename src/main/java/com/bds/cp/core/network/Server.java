package com.bds.cp.core.network;

import com.bds.cp.core.listener.NetworkCommandListener;
import com.bds.cp.core.util.LogUtil;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.log4j.Level;

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
    	LogUtil.log(Server.class, Level.INFO, "Listening on port : " + serverSocket.getLocalPort() + "....");
        while(true) {
            try {
                Socket socket = serverSocket.accept();
                LogUtil.log(Server.class, Level.INFO, "Incoming connection request accepted from : " + socket.getRemoteSocketAddress());
                addThread(socket);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
    

    public void addThread(Socket socket){ 
    	LogUtil.log(Server.class, Level.INFO, "Client accepted: " + socket);
        client = new NetworkCommandListener(this, socket);
        try {
        	LogUtil.log(Server.class, Level.INFO, "Opening the socket connection.");
            client.open();
            LogUtil.log(Server.class, Level.INFO, "Starting the clinet.");
            client.start();
        } catch(IOException ioe){  
        	LogUtil.log(Server.class, Level.INFO, "Error opening thread: " + ioe); 
        }
    }

}
