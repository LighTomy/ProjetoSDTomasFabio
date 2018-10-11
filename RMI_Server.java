package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;


public class RMI_Server extends UnicastRemoteObject implements RMIinterface_Server{
    static CopyOnWriteArrayList<RMIinterface_Client> clientlist;

    public RMI_Server() throws RemoteException {
        super();
        RMI_Server.clientlist = new CopyOnWriteArrayList<>();
    }

    //arrays e etc
    public void print_on_server(String s) throws RemoteException {
        System.out.println("> " + s);
    }


    public void subscribe(String name, RMIinterface_Client c) throws RemoteException {
        System.out.println("Subscribing " + name);
        System.out.print("> ");
        clientlist.add(c);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        String leitura = "" ;

        //security policy
        System.getProperties().put("java.security.policy", "policy.all");
        System.setSecurityManager(new RMISecurityManager());

        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input);

        try {
            //User user = new User();

            RMI_Server rmi_server = new RMI_Server();
            Registry r = LocateRegistry.createRegistry(7002);
            r.rebind("RMI", rmi_server);


            System.out.println("RMI Server ready.");
            while (true) {
                leitura = reader.readLine();
                System.out.println("mas chega aqui?");
                rmi_server.print_on_server(leitura);
                /*ListIterator<RMIinterface_Client> iterator = clientlist.listIterator();

                while(iterator.hasNext()){
                    RMIinterface_Client client = iterator.next();
                    client.print_on_client(leitura);
                }*/

            }
        } catch (Exception re) {
            System.out.println("Exception in HelloImpl.main: " + re);
        }

        //end
    }

    @Override
    public void subscribe(String name, RMIinterface_Server client) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
