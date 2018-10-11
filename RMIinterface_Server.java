/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company;
import java.rmi.*;
/**
 *
 * @author fabio
 */
public interface RMIinterface_Server extends Remote{
    public void print_on_server(String s) throws java.rmi.RemoteException;
    public void subscribe(String name, RMIinterface_Server client) throws RemoteException;

    //boolean checkClientCredintials(RMIinterface ci,String name, String pass) throws RemoteException;
    //void broadcastMessage(String name,String message) throws RemoteException;
    //void sendMessageToClient(String message) throws RemoteException;
}
