package com.bds.cp.core.listener;

import com.bds.cp.core.network.Server;
import com.bds.cp.core.util.CPUtil;

import java.io.*;
import java.net.Socket;
import java.util.Date;

/**
 * Created by sonu on 06/12/16.
 */
public class NetworkCommandListener extends Thread{

    private Socket socket = null;
    private Server server = null;
    private int id = -1;
    private DataInputStream in = null;
    private DataOutputStream out = null;

    public NetworkCommandListener(Server server, Socket socket){
        this.server = server;
        this.socket = socket;
        this.id = socket.getPort();
    }

    public void run(){
        System.out.println("NetworkCommandListener with ID : " + String.valueOf(id) + "running.");
        while(true){
            try{
                String message = in.readUTF();
                System.out.println(message);
                CPUtil.executeCommand(message);
                sendMessage("Message received at : "+(new Date(System.currentTimeMillis())).toString());
            } catch (EOFException eofEx){
                try {
                    close();
                    return;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (IOException exception){
                exception.printStackTrace();
            }
        }
    }

    public void sendMessage(String message){
        try{
            out.writeUTF(message);
        } catch (IOException ioe){
            System.out.println("Unable to send message to the remote host.");
            ioe.printStackTrace();
        }
    }

    public void open() throws IOException {
        in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        out = new DataOutputStream(socket.getOutputStream());
        out.writeUTF("Connected");
    }

    public void close() throws IOException {
        if (socket != null)
            socket.close();
        if (in!= null)
            in.close();
        if (null != out)
            out.close();
    }
}
