package org.uok.dscc;

import java.io.DataOutputStream;
import java.net.Socket;

public class Client {

    public Client(){}

    public void clientcon(String message){
        AppProperties appProperties = AppProperties.getInstance();
        try{
            Socket s = new Socket("127.0.0.1", Integer.parseInt(appProperties.getProperty("Client_port")));
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
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
