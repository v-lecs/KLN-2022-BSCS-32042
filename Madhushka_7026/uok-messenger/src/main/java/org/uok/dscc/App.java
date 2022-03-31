package org.uok.dscc;
import java.util.*;
import java.io.*;
import java.net.*;


 

public class App
{

    	public static void main(String[] args)
	{
		Scanner scan= new Scanner(System.in);
                String message = new String();

                try
                {
		while(!message.equalsIgnoreCase("end"))
		{	           
                	System.out.print("Enter your message: ");
			message =  scan.nextLine();                
                        Socket s = new Socket("127.0.0.1", 60000);
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
