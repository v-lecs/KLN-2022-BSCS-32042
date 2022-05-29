package org.uok.dscc;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;


public class App
{

        public static void main (String[]args ) throws NotBoundException, RemoteException {
            //Create a server and client classes and start server
            Thread server = new Thread(new Server());
            server.start();
            Client client = new Client();
            try {
                //get client inputs to send to the server
                Scanner in = new Scanner(System.in);
                String message = new String();
                while (!message.equalsIgnoreCase("over")) {
                    message = in.nextLine();
                    if (message.isEmpty())
                        continue;
                    client.clientcon(message);
                }


                System.out.println("Session End");

            } catch (Exception e) {
                System.out.println(e.getMessage());

            }
        }

}


