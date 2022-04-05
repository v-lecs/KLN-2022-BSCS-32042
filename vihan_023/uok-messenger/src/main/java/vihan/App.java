package vihan;

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
			Scanner sc = new Scanner(System.in);
			String msg = new String();

			System.out.println("Enter messages: ");

			while (!msg.equalsIgnoreCase("exit"))
			{
                		//System.out.println("Enter a message: ");
                		msg = sc.nextLine();

				try
				{
            				Socket s= new Socket("127.0.0.1", 60000);
            				DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            				dout.writeUTF(msg);
            				if (msg.equalsIgnoreCase("exit"))
					{
                				dout.flush();
                				dout.close();
                				s.close();
            				}

        			}

			        catch (Exception e)
				{
            				System.out.println(e.getMessage());
                		}

            		}

        	}


		catch (Exception e)
		{
            		System.out.println(e.getMessage());

        	}
        }


}

class Server extends Thread
{
        public void run()
        {
		try
		{
            		ServerSocket ss = new ServerSocket(60000);

            		while (true)
			{
                		Socket s = ss.accept();
                		DataInputStream dis = new DataInputStream(s.getInputStream());
                		String str = dis.readUTF();

				if (str.equalsIgnoreCase("exit"))
				{
                   	 		break;
				}

                		System.out.println("message = " +str);
                		dis.close();
            		}

	            		ss.close();
        	}

		catch (Exception e)
		{
            		System.out.println(e.getMessage());
        	}
        }
}
