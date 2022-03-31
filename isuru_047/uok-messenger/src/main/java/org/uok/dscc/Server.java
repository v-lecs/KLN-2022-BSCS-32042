package org.uok.dscc;

import java.io.*;
import java.net.*;

public class Server
{
        public static void main(String[] args)
        {
                try
                {
                        ServerSocket ssoc1 = new ServerSocket(60000);
                        Socket soc1 = ssoc1.accept();
                        DataInputStream dis = new DataInputStream(soc1.getInputStream());
                        String str = dis.readUTF();
                        System.out.println("message= " + str);
                        ssoc1.close();
                }

                catch (Exception e)
                {
                        System.out.println(e);
                }
        }
}
