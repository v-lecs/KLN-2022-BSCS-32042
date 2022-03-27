package org.uok.dscc;

import java.io.DataInput;
import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main( String[] args )
    {
        strtserver();
    }

    public static void strtserver(){
        try{
            String str;
            ServerSocket ss = new ServerSocket(60000);
            System.out.println("Server Started");
            while (true) {
                Socket s = ss.accept();
                DataInputStream dis = new DataInputStream(s.getInputStream());
                str = dis.readUTF();
                if (str.equalsIgnoreCase("over"))
                    break;
                System.out.println("message = " +str);
                dis.close();
            }
            ss.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
