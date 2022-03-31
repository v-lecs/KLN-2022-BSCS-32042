package org.uok.dscc;

import java.util.*;
import java.io.*;
import java.net.*;
 

public class App
{
    	public static void main(String[] args)
	{
                try
                {

                	Scanner sc1= new Scanner(System.in);
                	System.out.print("Enter your message: ");
                	String msg1= sc1.nextLine();

                        Socket soc1 = new Socket("127.0.0.1", 60000);
                        DataOutputStream dout = new DataOutputStream(soc1.getOutputStream());
                        dout.writeUTF(msg1);
                        dout.flush();
                        dout.close();
                        soc1.close();
                }

                catch (Exception e)
                {
                        System.out.println(e);
                }

    	}
}
