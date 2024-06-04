package homework3;

import java.util.ArrayList;
import java.util.Scanner;

public class PhonebookV2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String filePath = "/Users/macbook/Desktop/yourfile.csv"; // Set your CSV file path here
        RedBlackTree phonebook = FileUtils.readFile(filePath);

        int[] edges = phonebook.countRedAndBlackEdges();
        System.out.println("Total black edges: " + edges[0]);
        System.out.println("Total red edges: " + edges[1]);

        while (true) {
            System.out.println("Enter a name (Surname, Name) to search for or -1 to exit:");
            String input = scanner.nextLine();

            if (input.equals("-1")) break;

            ArrayList<Entry> results = phonebook.get(input);
            if (results != null) {
                System.out.println("Found " + results.size() + " entries:");
                for (Entry entry : results) {
                    System.out.println(entry);
                }
            } else {
                System.out.println("Entry not found.");
            }
        }
        scanner.close();
    }
}

