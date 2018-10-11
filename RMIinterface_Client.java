package com.company;
import java.rmi.*;
/**
 *
 * @author fabio
 */
public interface RMIinterface_Client extends Remote{
    public void print_on_client(String s) throws java.rmi.RemoteException;
}
