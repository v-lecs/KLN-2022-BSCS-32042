package org.uok.dscc;

import java.io.DataInput;
import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server implements Runnable {

    public  Server() {
        try {
            //create and export remort objects
            RMIClientImpl rmiClient = new RMIClientImpl();
            RMIClient rmiClientStub = (RMIClient) UnicastRemoteObject.exportObject(rmiClient, 0);
            //Register the java object to RMI registry
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("Server", rmiClientStub);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        } catch (AlreadyBoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {

        try{
            //create server socket
            AppProperties appProperties = AppProperties.getInstance();
            String str;
            ServerSocket ss = new ServerSocket(Integer.parseInt(appProperties.getProperty("Server_port")));
            while (true) {
                //accept the data and print
                Socket s = ss.accept();
                DataInputStream dis = new DataInputStream(s.getInputStream());
                str = dis.readUTF();
                if (str.equalsIgnoreCase("over"))
                    break;
                System.out.println(str);
                dis.close();
            }
            ss.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
