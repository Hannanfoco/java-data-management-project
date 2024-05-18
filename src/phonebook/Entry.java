package phonebook;

public class Entry implements Comparable<Entry> {
    private String surnameName;
    private String streetAddress;
    private String city;
    private String postcode;
    private String country;
    private String phoneNumber;

    public Entry(String surnameName, String streetAddress, String city, String postcode, String country, String phoneNumber) {
        this.surnameName = surnameName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.postcode = postcode;
        this.country = country;
        this.phoneNumber = phoneNumber;
    }

    public String getSurnameName() {
        return surnameName;
    }

    @Override
    public int compareTo(Entry other) {
        return this.surnameName.compareTo(other.surnameName);
    }

    @Override
    public String toString() {
        return surnameName + ";" + streetAddress + ";" + city + ";" + postcode + ";" + country + ";" + phoneNumber;
    }
    public String getStreetAddress() {
        return streetAddress;
    }

    public String getCity() {
        return city;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getCountry() {
        return country;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

}




