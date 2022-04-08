package org.uok.dscc;

import java.util.*;
import java.io.*;
import java.net.*;

public class App
{

	public static void main(String[] args)
	{
		new Server().start();
		new Client().start();
	}

}

class Client extends Thread
{
	public void run()
	{
		Scanner scanner= new Scanner(System.in);
                String message = new String();

		System.out.print("Enter your message: ");

                try
                {
			while(!message.equalsIgnoreCase("stop"))
			{
                        	message =  scanner.nextLine(); 
                        	Socket skt = new Socket("127.0.0.1", 50000);

                        	 DataOutputStream dout = new DataOutputStream(skt.getOutputStream());
                        	dout.writeUTF(message);

				if(!message.equalsIgnoreCase("stop"))
				{
                		        dout.flush();
                        		dout.close();
                        		skt.close();
               			 }
			}
		}
                catch (Exception e)
                {
                        System.out.println(e);
                }

    	}
}

class Server extends Thread
{
	public void run()
	{
		try
		{
            		ServerSocket serverSocket = new ServerSocket(50000);
			String strng = new String();

            		while (!strng.equalsIgnoreCase("stop")) 
			{
                		Socket skt = serverSocket.accept();
                		DataInputStream dis = new DataInputStream(skt.getInputStream());
                		strng = dis.readUTF();

				if (strng.equalsIgnoreCase("stop"))
				{
                   	 		break;
				}

                		System.out.println("message= " +strng);
				System.out.print("\n");
				System.out.print("Enter your message: ");
                		dis.close();
            		}

	            	serverSocket.close();
        	}


		catch (Exception e)
		{
            		System.out.println(e);
        	}
    	}
}

