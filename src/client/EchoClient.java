package client;

import shared.RemoteInterface;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class EchoClient {
    static final String HOST_ADDR = "localhost";
    static final int HOST_PORT = 9876;

    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry(HOST_ADDR, HOST_PORT); // Locate server's registry
        RemoteInterface stub =
                (RemoteInterface) registry.lookup("Remote Object"); // Obtain a reference to the remote object

        System.out.println("Echo client started");

        // Invoke methods on the remote object
        Scanner scanner = new Scanner(System.in);
        String line;
        while (true) {
            // Prompt user for input
            System.out.print("> ");
            line = scanner.nextLine();
            if (line.equals("quit")) break;

            // Display message
            System.out.println("> " + stub.echo(line));
        }

        System.out.println("Goodbye!");
    }
}
