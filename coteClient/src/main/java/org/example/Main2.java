package org.example;

import java.io.*;
import java.net.*;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader userInputReader = new BufferedReader(new InputStreamReader(System.in));
        Socket socketClient = new Socket("localhost", 7777);
        DataOutputStream serverOutput = new DataOutputStream(socketClient.getOutputStream());
        BufferedReader serverInput = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));

        try {
            while (true) {
                // Read user input for the first number
                System.out.print("Enter the first number (or 'exit' to quit): ");
                String firstNumberInput = userInputReader.readLine();

                // Exit loop if the user enters 'exit'
                if ("exit".equalsIgnoreCase(firstNumberInput)) {
                    break;
                }

                // Read user input for the second number
                System.out.print("Enter the second number: ");
                String secondNumberInput = userInputReader.readLine();

                // Send the two numbers to the server as a single string, separated by a space
                serverOutput.writeBytes(firstNumberInput + " " + secondNumberInput + "\n");

                // Receive and print the server's response
                String serverResponse = serverInput.readLine();
                System.out.println("RESULT FROM SERVER: " + serverResponse);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            socketClient.close();
        }
    }
}

