package org.uok.dscc;

import java.util.*;
import java.io.*;
import java.net.*;

public class App
{

	public static void main(String[] args)
		{
			Scanner scanner = new Scanner(System.in);
                	String message = new String();

                	try
                	{
				while(!message.equalsIgnoreCase("end"))
				{
                			System.out.print("Enter a message: ");
					message =  scanner.nextLine();

                        		Socket skt = new Socket("127.0.0.1", 60000);
                        		DataOutputStream dout = new DataOutputStream(skt.getOutputStream());
                        		dout.writeUTF(message);

					if(!message.equalsIgnoreCase("end"))
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
