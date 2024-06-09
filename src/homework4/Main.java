package homework4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {

            String filePath = "/Users/macbook/Desktop/social_network.csv";
            Scanner fileScanner = new Scanner(new File(filePath));
            SocialNetwork network = new SocialNetwork(fileScanner);
            fileScanner.close();

            System.out.println("Total users: " + network.getNumberOfUsers());
            System.out.println("Total friendships: " + network.getNumberOfFriendships());

            Scanner inputScanner = new Scanner(System.in);
            while (true) {
                System.out.println("Enter a name to recommend friends to (or -1 to exit): ");
                String name = inputScanner.nextLine();

                if (name.equals("-1")) {
                    break;
                }

                if (!network.getFriends(name).isEmpty()) {
                    ArrayList<FriendshipRecommendation> recommendations = network.recommendFriends(name);
                    System.out.println("Total recommendations: " + recommendations.size());
                    for (int i = 0; i < Math.min(10, recommendations.size()); i++) {
                        System.out.println(recommendations.get(i));
                    }
                } else {
                    System.out.println("User not found in the network.");
                }
            }
            inputScanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
    }
}



