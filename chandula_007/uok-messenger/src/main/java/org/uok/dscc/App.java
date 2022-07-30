package org.uok.dscc;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;


public class App
{

        public static void main (String[]args ) throws NotBoundException, IOException {
            //Initialize firbase admin sdk
            FileInputStream serviceaccount = new FileInputStream("./src/main/resources/firebase_credentials.json");
            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceaccount))
                    .setDatabaseUrl("https://uok-messenger-cs007-default-rtdb.firebaseio.com/")
                    .build();
            FirebaseApp.initializeApp(options);

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


