package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RMI_Client extends UnicastRemoteObject implements RMIinterface_Client {

    RMI_Client() throws RemoteException {
        super();
    }

    public void print_on_client(String s) throws RemoteException {
        System.out.println("> " + s);
    }

    public static void main(String args[]) {
        String a;
        // usage: java HelloClient username
        System.getProperties().put("java.security.policy", "policy.all");
        System.setSecurityManager(new RMISecurityManager());

        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input);
        try {
            //User user = new User();


            //RMI_Server rmi_server = new RMI_Server();
            System.out.println("Gello");
            RMIinterface_Server rmi_server = (RMIinterface_Server) LocateRegistry.getRegistry(7002).lookup("RMI");
            System.out.println("Can i get here?");
            RMI_Client client = new RMI_Client();
            System.out.println("suuuu");

            //rmi_server.subscribe("one2018", (RMIinterface_Server) client);

            System.out.println("Client sent subscription to server");
            while (true) {
                System.out.print("> ");
                a = reader.readLine();
                rmi_server.print_on_server(a);
            }

        } catch (Exception e) {
            System.out.println("Exception in main: " + e);
        }

    }
}
