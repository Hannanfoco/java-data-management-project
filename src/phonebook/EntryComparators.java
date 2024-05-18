package phonebook;

import java.util.Comparator;

public class EntryComparators {
    public static Comparator<Entry> byStreetAddress() {
        return Comparator.comparing(Entry::getStreetAddress);
    }

    public static Comparator<Entry> byCity() {
        return Comparator.comparing(Entry::getCity);
    }

    public static Comparator<Entry> byPostcode() {
        return Comparator.comparing(Entry::getPostcode);
    }

    public static Comparator<Entry> byCountry() {
        return Comparator.comparing(Entry::getCountry);
    }

    public static Comparator<Entry> byPhoneNumber() {
        return Comparator.comparing(Entry::getPhoneNumber);
    }
}
