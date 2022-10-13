package org.apache.maven.archetypes;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
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
        Client client = new Client("127.0.0.1", 5000);
        Server server = new Server(5000);




    }
}
