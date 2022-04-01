package org.uok.dscc;

import java.io.*;
import java.net.*;

public class Server
{
        public static void main(String[] args)
        {
                try
                {
                        ServerSocket serverSocket = new ServerSocket(60000);
                        Socket skt = serverSocket.accept();

                        DataInputStream dataIS = new DataInputStream(skt.getInputStream());

                        String str = dataIS.readUTF();

                        System.out.println("message= " + str);
                        serverSocket.close();
                }

                catch (Exception e)
                {
                        System.out.println(e);
                }
        }
}
