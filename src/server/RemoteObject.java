package server;

import shared.RemoteInterface;

import java.rmi.RemoteException;

public class RemoteObject implements RemoteInterface {

    @Override
    public String echo(String text) throws RemoteException {
        System.out.println("Message received: " + text);
        return text;
    }
}
