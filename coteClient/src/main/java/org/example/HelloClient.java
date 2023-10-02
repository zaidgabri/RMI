package org.example;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class HelloClient {
    public static void main(String[] args) {
        try {
            // Locate the RMI registry on the server's host and port
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

            // Look up the remote object by its name
            Hello hello = (Hello) registry.lookup("HelloService");

            // Use the remote object to say hello
            String message = hello.sayHello();
            System.out.println(message);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}

