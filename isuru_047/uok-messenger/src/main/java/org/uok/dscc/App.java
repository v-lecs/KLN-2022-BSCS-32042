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

        	        	Scanner scan= new Scanner(System.in);
                		System.out.print("Enter the message: ");
                		String message= scan.nextLine();
                   		Socket soc = new Socket("127.0.0.1", 60000);
                        	DataOutputStream dout = new DataOutputStream(soc.getOutputStream());
                        	dout.writeUTF(message);
                        	dout.flush();
                        	dout.close();
                        	soc.close();
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
                        ServerSocket ssoc = new ServerSocket(60000);
                        Socket soc = ssoc.accept();
                        DataInputStream din = new DataInputStream(soc.getInputStream());
                        String str = din.readUTF();
                        System.out.println("message= " + str);
                        ssoc.close();
                }

                catch (Exception e)
                {
                        System.out.println(e);
                }

        }
}
