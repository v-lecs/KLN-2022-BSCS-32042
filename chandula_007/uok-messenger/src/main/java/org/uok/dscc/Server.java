package org.uok.dscc;

import java.io.DataInput;
import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable {
    @Override
    public void run() {
        try{
            AppProperties appProperties = AppProperties.getInstance();
            String str;
            ServerSocket ss = new ServerSocket(Integer.parseInt(appProperties.getProperty("Server_port")));
            System.out.println("Server Started");

            while (true) {
                Socket s = ss.accept();
                DataInputStream dis = new DataInputStream(s.getInputStream());
                str = dis.readUTF();
                if (str.equalsIgnoreCase("over"))
                    break;
                System.out.println(str);
                dis.close();
            }
            ss.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
