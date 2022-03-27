import java.io.*;
import java.net.*;


public class Server {
    public static void main( String[] args )
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
