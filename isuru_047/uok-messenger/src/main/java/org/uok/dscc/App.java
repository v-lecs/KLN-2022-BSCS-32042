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
		Scanner scan= new Scanner(System.in);
                String message = new String();
		System.out.print("Enter the message: ");

                try
                {
		while(!message.equalsIgnoreCase("end"))
		{
                        message =  scan.nextLine();
                        Socket soc = new Socket("127.0.0.1", 50000);
                        DataOutputStream dout = new DataOutputStream(soc.getOutputStream());
                        dout.writeUTF(message);

		if(!message.equalsIgnoreCase("end"))
		{
                        dout.flush();
                        dout.close();
                        soc.close();
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
            		ServerSocket ssoc = new ServerSocket(50000);
			String str = new String();
            		while (!str.equalsIgnoreCase("end"))
			{
                		Socket soc = ssoc.accept();
                		DataInputStream din = new DataInputStream(soc.getInputStream());
                		str = din.readUTF();

				if (str.equalsIgnoreCase("end"))
				{
                   	 		break;
				}

                		System.out.println("message= " +str);
				System.out.print("\n");
				System.out.print("Enter the message: ");
                		din.close();
            		}

	            	ssoc.close();
        	}


		catch (Exception e)
		{
            		System.out.println(e);
        	}
    	}
}
