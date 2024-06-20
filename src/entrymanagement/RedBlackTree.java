package entrymanagement;

import java.util.ArrayList;

public class RedBlackTree {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;

    public ArrayList<Entry> get(String searchableName) {
        Node x = root;
        int redEdges = 0;
        int blackEdges = 0;

        while (x != null) {
            int cmp = searchableName.compareTo(x.key);
            if (cmp < 0) {
                x = x.left;
                if (x != null && x.color == RED) redEdges++;
                else blackEdges++;
            } else if (cmp > 0) {
                x = x.right;
                if (x != null && x.color == RED) redEdges++;
                else blackEdges++;
            } else {
                System.out.println("Red edges: " + redEdges);
                System.out.println("Black edges: " + blackEdges);
                return x.values;
            }
        }
        return null;
    }

    public void put(String searchableName, Entry entry) {
        root = put(root, searchableName, entry);
        root.color = BLACK;
    }

    private Node put(Node h, String searchableName, Entry entry) {
        if (h == null) return new Node(searchableName, entry, RED);

        int cmp = searchableName.compareTo(h.key);
        if (cmp < 0) {
            h.left = put(h.left, searchableName, entry);
        } else if (cmp > 0) {
            h.right = put(h.right, searchableName, entry);
        } else {
            h.values.add(entry);
        }

        if (isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right)) flipColors(h);

        return h;
    }

    private boolean isRed(Node x) {
        if (x == null) return false;
        return x.color == RED;
    }

    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    private void flipColors(Node h) {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    public int[] countRedAndBlackEdges() {
        int[] counts = new int[2]; // [black, red]
        countEdges(root, counts);
        return counts;
    }

    private void countEdges(Node node, int[] counts) {
        if (node == null) return;
        if (node.left != null) {
            if (node.left.color == RED) counts[1]++;
            else counts[0]++;
            countEdges(node.left, counts);
        }
        if (node.right != null) {
            if (node.right.color == RED) counts[1]++;
            else counts[0]++;
            countEdges(node.right, counts);
        }
    }
}
