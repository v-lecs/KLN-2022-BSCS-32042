package org.uok.dscc;

import java.rmi.Remote;
import java.rmi.RemoteException;

//RMI client interface to get the server name
public interface RMIClient extends Remote{
        String printservername() throws RemoteException;
}

