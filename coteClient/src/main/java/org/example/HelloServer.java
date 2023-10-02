package org.example;


import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class HelloServer {
    public static void main(String[] args) {
        try {
            // Create an instance of the server implementation
            Hello hello = new HelloImpl();

            // Create an RMI registry on port 1099 (default RMI registry port)
            Registry registry = LocateRegistry.createRegistry(1099);

            // Bind the Hello service to the registry with a name "HelloService"
            registry.rebind("HelloService", hello);

            System.out.println("Server is ready.");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}

