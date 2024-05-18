package phonebook;

import java.util.Scanner;

public class PhonebookV1 {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please provide the path to the input CSV file as an argument.");
            System.out.println("Usage: java phonebook.PhonebookV1 <inputFilePath>");
            return;
        }

        String inputFilePath = args[0];
        Entry[] entries = FileUtils.readFile(inputFilePath);

        MergeSort.sort(entries);

        String outputFilePath = "sorted_phonebook.csv";
        FileUtils.writeToFile(entries, outputFilePath);
        System.out.println("Sorting completed and written to file: " + outputFilePath);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("\nEnter a name (Surname, Name) to search or -1 to exit: ");
            String searchTerm = scanner.nextLine();
            if (searchTerm.equals("-1")) {
                System.out.println("Exiting the program...");
                break;
            }

            int[] searchResult = BinarySearch.search(entries, searchTerm);
            if (searchResult.length == 0) {
                System.out.println("Entry not found for: " + searchTerm);
            } else {
                int startIndex = searchResult[0];
                int endIndex = searchResult[1];
                int count = endIndex - startIndex + 1;
                System.out.println(count + " entries found for: " + searchTerm);
                System.out.println("Details of the entries:");
                for (int i = startIndex; i <= endIndex; i++) {
                    System.out.println(entries[i]);
                }
            }
        }
        scanner.close();
    }
}

