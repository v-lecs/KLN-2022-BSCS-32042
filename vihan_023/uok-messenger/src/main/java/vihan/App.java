import java.util.*;
import java.io.*;
import java.net.*;

public class App
{

	public static void main( String[] args )
	{
       		try
		{
			Scanner sc = new Scanner(System.in);
			String msg = new String();

			while (!msg.equalsIgnoreCase("exit"))
			{
                		System.out.println("Enter a message: ");
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
