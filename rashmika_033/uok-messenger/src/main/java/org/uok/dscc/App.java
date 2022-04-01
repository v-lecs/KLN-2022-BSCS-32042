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
