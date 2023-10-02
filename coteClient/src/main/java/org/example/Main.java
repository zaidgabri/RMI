//package org.example;
//
//
//import java.io.BufferedReader;
//import java.io.DataOutputStream;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.net.Socket;
//import java.net.SocketException;
//import java.net.UnknownHostException;
//
//public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader entreeDepuisUtilisateur = new BufferedReader(new
//                InputStreamReader(System.in));
//        Socket socketClient = new Socket("localhost", 7777);
//        DataOutputStream sortieVersServeur = new
//                DataOutputStream(socketClient.getOutputStream());
//        BufferedReader entreeDepuisServeur = new BufferedReader(new
//                InputStreamReader(socketClient.getInputStream()));
//        String phrase = entreeDepuisUtilisateur.readLine();
//        sortieVersServeur.writeBytes(phrase + "n");
//        String phraseModifiee = entreeDepuisServeur.readLine();
//        System.out.println("RECU DU SERVEUR: " + phraseModifiee);
//        socketClient.close();
//
//    }
//}
package org.example;

import java.io.*;
import java.net.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader userInputReader = new BufferedReader(new InputStreamReader(System.in));
        Socket socketClient = new Socket("localhost", 7777);
        DataOutputStream serverOutput = new DataOutputStream(socketClient.getOutputStream());
        BufferedReader serverInput = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));

        try {
            while (true) {
                // Read user input
                System.out.print("Enter a message (or 'exit' to quit): ");
                String userInput = userInputReader.readLine();

                // Send the user input to the server
                serverOutput.writeBytes(userInput + "\n");

                // Exit loop if the user enters 'exit'
                if ("exit".equalsIgnoreCase(userInput)) {
                    break;
                }

                // Receive and print the server's response
                String serverResponse = serverInput.readLine();
                System.out.println("RECEIVED FROM SERVER: " + serverResponse);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            socketClient.close();
        }
    }
}
