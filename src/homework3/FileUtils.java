package homework3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileUtils {

    public static RedBlackTree readFile(String filePath) {
        RedBlackTree rbt = new RedBlackTree();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(";");
                if (fields.length == 7) {
                    Entry entry = new Entry(fields[0].trim(), fields[1].trim(), fields[2].trim(), fields[3].trim(), fields[4].trim(), fields[5].trim(), fields[6].trim());
                    rbt.put(entry.getSearchableName(), entry);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return rbt;
    }
}


