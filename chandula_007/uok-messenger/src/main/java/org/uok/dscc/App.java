package org.uok.dscc;

import java.io.DataOutput;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;


public class App
{
    public static void main( String[] args )
    {
        Client client = new Client();
        try{
            Thread server = new Thread(new Server());
            server.start();
            Scanner in = new Scanner(System.in);
            String message = new String();
            while (!message.equalsIgnoreCase("over")) {
                message = in.nextLine();
                if (message.isEmpty())
                    continue;
                client.clientcon(message);
            }


            System.out.println("Session End");

        }catch (Exception e){
            System.out.println(e.getMessage());

        }
    }
}


