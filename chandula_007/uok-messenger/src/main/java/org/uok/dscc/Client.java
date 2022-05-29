package org.uok.dscc;

import java.io.DataOutputStream;
import java.net.Socket;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {

    public Client() throws RemoteException, NotBoundException {

        //RMI client for get the server name from server
        Registry registry = LocateRegistry.getRegistry(null);
        RMIClient server=null;
        server = (RMIClient) registry.lookup("Server");
        if (server!=null){
            System.out.println(server.printservername());
        }else{
            System.out.println("No server address bound");
        }
    }

    public void clientcon(String message){
        AppProperties appProperties = AppProperties.getInstance();
        try{
            //create client socket
            Socket s = new Socket((appProperties.getProperty("Server_name")), Integer.parseInt(appProperties.getProperty("Client_port")));
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            //send messages to the server
            dout.writeUTF(message);
            if (message.equalsIgnoreCase("over")) {
                dout.flush();
                dout.close();
                s.close();
                return;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
