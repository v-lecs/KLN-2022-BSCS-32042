import java.util.*;
import java.io.*;
import java.net.*;


public class App
{
    	public static void main(String[] args)
	{
                try
                {

                	Scanner sc= new Scanner(System.in);
                	System.out.print("Enter a message: ");
                	String msg= sc.nextLine();

                        Socket s = new Socket("127.0.0.1", 60000);
                        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
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
