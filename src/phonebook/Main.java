package phonebook;

public class Main {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Please provide input and output file paths as arguments");
            System.out.println("Usage: java phonebook.Main <inputFilePath> <outputFilePath>");
            return;
        }

        String inputFilePath = args[0];
        String outputFilePath = args[1];

        Entry[] entries = FileUtils.readFile(inputFilePath);
        MergeSort.sort(entries);
        FileUtils.writeToFile(entries, outputFilePath);
        System.out.println("Sorting completed and written to output file.");

        String searchableName = "Clerc, Agnès";
        int[] searchResult = BinarySearch.search(entries, searchableName);

        if (searchResult.length > 0) {
            int startIndex = searchResult[0];
            int endIndex = searchResult[1];
            int numEntriesFound = endIndex - startIndex + 1;
            System.out.println(numEntriesFound + " entries found for: " + searchableName);
            System.out.println("Start index: " + startIndex);
            System.out.println("End index: " + endIndex);
        } else {
            System.out.println("No entries found for: " + searchableName);
        }
    }
}

