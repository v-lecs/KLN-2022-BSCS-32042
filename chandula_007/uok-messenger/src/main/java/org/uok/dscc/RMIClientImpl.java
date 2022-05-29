package org.uok.dscc;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RMIClientImpl implements RMIClient {
    public RMIClientImpl() throws RemoteException {
    }

    //implementing client interface using app property file
    @Override
    public String printservername() throws RemoteException {
        AppProperties appProperties= AppProperties.getInstance();
        return appProperties.getProperty("Server_name");
    }



}





