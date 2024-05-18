package phonebook;

public class BinarySearch {

    public static int[] search(Entry[] entries, String searchableName) {
        int startIndex = findStartIndex(entries, searchableName);
        if (startIndex == -1) {
            return new int[] {};
        }
        int endIndex = findEndIndex(entries, searchableName, startIndex);
        return new int[] {startIndex, endIndex};
    }

    private static int findStartIndex(Entry[] entries, String searchableName) {
        int low = 0;
        int high = entries.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = entries[mid].getSurnameName().compareTo(searchableName);
            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                if (mid == 0 || !entries[mid - 1].getSurnameName().equals(searchableName)) {
                    return mid;
                }
                high = mid - 1;
            }
        }
        return -1;
    }

    private static int findEndIndex(Entry[] entries, String searchableName, int startIndex) {
        int low = startIndex;
        int high = entries.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = entries[mid].getSurnameName().compareTo(searchableName);
            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                if (mid == entries.length - 1 || !entries[mid + 1].getSurnameName().equals(searchableName)) {
                    return mid;
                }
                low = mid + 1;
            }
        }
        return startIndex;
    }
}


