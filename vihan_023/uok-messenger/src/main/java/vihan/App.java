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

		Scanner sc= new Scanner(System.in);
		System.out.print("Enter a message: ");
		String msg= sc.nextLine();

		try
		{
 			Socket s = new Socket("127.0.0.1", 60000);
 			DataOutputStream dout = new
			DataOutputStream(s.getOutputStream());
 			dout.writeUTF(msg);
 			dout.flush();
 			dout.close();
 			s.close();
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
                        ServerSocket ss = new ServerSocket(60000);
                        Socket s = ss.accept();
                        DataInputStream dis = new DataInputStream(s.getInputStream());
                        String str = dis.readUTF();
                        System.out.println("message= " + str);
                        ss.close();
                }

                catch (Exception e)
                {
                        System.out.println(e);
                }
        }
}
