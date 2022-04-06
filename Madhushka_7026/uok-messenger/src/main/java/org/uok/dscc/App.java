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
		System.out.print("Enter your message: ");	

                try
                {
		while(!message.equalsIgnoreCase("end"))
		{
                        message =  scan.nextLine();                                          
                        Socket s = new Socket("127.0.0.1", 50000);
                        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
                        dout.writeUTF(message);

		if(!message.equalsIgnoreCase("end"))
		{
                        dout.flush();
                        dout.close();
                        s.close();
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
            		ServerSocket ss = new ServerSocket(50000);
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
				System.out.print("\n");
				System.out.print("Enter your message: ");
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
