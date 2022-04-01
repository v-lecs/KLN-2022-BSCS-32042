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
			String str = new String();

            		while (!str.equalsIgnoreCase("end")) 
			{
                		Socket skt = serverSocket.accept();
                		DataInputStream dataIS = new DataInputStream(skt.getInputStream());
                		str = dataIS.readUTF();

				if (str.equalsIgnoreCase("end"))
				{
                   		 	break;
				}

                		System.out.println("message= " +str);
                		dataIS.close();
            		}

	            	serverSocket.close();
        	}


		catch (Exception e)
		{
            		System.out.println(e);
        	}
        }
}
