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
                	try
                	{

        	        	Scanner scanner= new Scanner(System.in);
                		System.out.print("Enter a message: ");

                		String message= scanner.nextLine();
                   		Socket skt = new Socket("127.0.0.1", 60000);

                        	DataOutputStream dout = new DataOutputStream(skt.getOutputStream());
                        	dout.writeUTF(message);
                        	dout.flush();
                        	dout.close();
                        	skt.close();
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
                        ServerSocket serverSocket = new ServerSocket(60000);
                        Socket skt = serverSocket.accept();

                        DataInputStream dis = new DataInputStream(skt.getInputStream());
                        String strng = dis.readUTF();

                        System.out.println("message= " + strng);
                        serverSocket.close();
                }

                catch (Exception e)
                {
                        System.out.println(e);
                }
        }
}
