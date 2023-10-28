package com.project.ecommerceapp;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LoginSystem {
   
	private static Map<String, User> users = new HashMap<>();
    public boolean registerUser(Scanner scanner) {
        System.out.print("Enter a username: ");
        String username = scanner.nextLine();
        System.out.print("Enter a password: ");
        String password = scanner.nextLine();

        if (users.containsKey(username)) {
            System.out.println("Username already exists. Please choose a different one.");
            return false;
        } else {
            users.put(username, new User(username, password));
            System.out.println("Registration successful!");
            return true;
        }
    }

    public boolean loginUser(Scanner scanner) {
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        if (users.containsKey(username) && users.get(username).getPassword().equals(password)) {
            System.out.println("Login successful! Welcome, " + username + "!");
            return true;
        } else {
            System.out.println("Login failed. Please check your username and password.");
            return false;
        }
    }
}

