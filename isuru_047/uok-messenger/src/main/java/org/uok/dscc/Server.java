package org.uok.dscc;

import java.io.*;
import java.net.*;

public class Server {
    public static void main( String[] args )
    {
        try
	{
            ServerSocket ssoc1 = new ServerSocket(60000);

            	while (true) 
		{
                	Socket soc1 = ssoc1.accept();
                	DataInputStream dis = new DataInputStream(soc1.getInputStream());
                	String str1 = dis.readUTF();

			if (str1.equalsIgnoreCase("exit"))
			{
                   	 	break;
			}

                	System.out.println("message = " +str1);
                	dis.close();
            	}

	            	ssoc1.close();
        }

	catch (Exception e)
	{
            System.out.println(e.getMessage());
        }
    }
}
