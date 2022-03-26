package org.uok.dscc;

import java.io.DataInput;
import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main( String[] args )
    {
        new Server();
    }

    public Server(){
        try{
            ServerSocket ss = new ServerSocket(60000);
            System.out.println("Server Started");
            Socket s = ss.accept();
            DataInputStream dis = new DataInputStream(s.getInputStream());
            String str = dis.readUTF();
            System.out.println("message = " +str);
            ss.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
