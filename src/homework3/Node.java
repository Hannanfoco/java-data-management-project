package homework3;

import java.util.ArrayList;

public class Node {
    public String key;
    public ArrayList<Entry> values;
    public Node left, right;
    public boolean color; // True for red, false for black

    public Node(String key, Entry entry, boolean color) {
        this.key = key;
        this.values = new ArrayList<>();
        this.values.add(entry);
        this.color = color;
    }
}

