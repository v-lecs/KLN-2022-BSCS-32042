package org.uok.dscc;

import java.util.*;
import java.io.*;
import java.net.*;

public class App
{

	public static void main( String[] args )
	{
       		try
		{
			Scanner sc1 = new Scanner(System.in);
			String msg1 = new String();

			while (!msg1.equalsIgnoreCase("exit"))
			{
                		System.out.println("Enter a message: ");
                		msg1 = sc1.nextLine();

				try
				{
            				Socket soc1= new Socket("127.0.0.1", 60000);
            				DataOutputStream dout = new DataOutputStream(soc1.getOutputStream());
            				dout.writeUTF(msg1);
            				if (msg1.equalsIgnoreCase("exit"))
					{
                				dout.flush();
                				dout.close();
                				soc1.close();
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
