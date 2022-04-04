package org.uok.dscc;

import java.io.DataOutput;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;



public class App 
{

    public static void clientcon(String message){
        try{
            Socket s= new Socket("127.0.0.1", 60000);
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            dout.writeUTF(message);
            dout.flush();
            dout.close();
            s.close();
            System.out.println("message sent");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void main( String[] args )
    {
        try{
            Thread server = new Thread(new Server());
            server.start();
            Scanner in = new Scanner(System.in);
            String message = new String();
            System.out.println("Type something to send");
            message = in.nextLine();
            clientcon(message);
        }catch (Exception e){
            System.out.println(e.getMessage());

        }
    }
}


