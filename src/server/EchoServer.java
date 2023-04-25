package server;

import shared.RemoteInterface;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class EchoServer {
    static final int PORT = 9876;

    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        LocateRegistry.createRegistry(PORT);                // Create RMI Registry
        RemoteInterface remoteObject = new RemoteObject();  // Instantiate remote object
        RemoteInterface stub =
                (RemoteInterface) UnicastRemoteObject.exportObject(remoteObject, 0);  // Export object
        LocateRegistry.getRegistry(PORT).bind("Remote Object", stub);                // Bind stub
        System.out.println("Echo server setup is successful");
    }
}
