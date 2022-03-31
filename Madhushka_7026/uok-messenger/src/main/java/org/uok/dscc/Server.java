package org.uok.dscc;

import java.io.*;
import java.net.*;


public class Server {
    public static void main( String[] args )
    {
        try
	{
            ServerSocket ss = new ServerSocket(60000);
		String string = new String();
            	while (!string.equalsIgnoreCase("end")) 
		{
                	Socket s = ss.accept();
                	DataInputStream dis = new DataInputStream(s.getInputStream());
                	string = dis.readUTF();

			if (string.equalsIgnoreCase("end"))
			{
                   	 	break;
			}

                	System.out.println("message= " +string);
                	dis.close();
            	}

	            	ss.close();
        }


	catch (Exception e)
	{
            System.out.println(e);
        }
    }
}
