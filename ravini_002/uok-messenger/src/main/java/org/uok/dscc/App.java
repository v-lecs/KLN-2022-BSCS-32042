package org.uok.dscc;

import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
            Scanner in = new Scanner(System.in);
            System.out.println("Enter message");
            String txt = in.nextLine();
            Socket s = new Socket("127.0.0.1", 60000);
            DataOutputStream dout = new
                    DataOutputStream(s.getOutputStream());
            dout.writeUTF(txt);
            dout.flush();
            dout.close();
            s.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
