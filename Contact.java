package com;
import java.util.UUID;

public class Contact {

    // Declared variables
    private final String contactID; 
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;

    // Contstructor for creating a Contact object
    public Contact(String firstName, String lastName, String phoneNumber, String address){

        this.contactID = generateRandomContactID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
    // Method to generate ContactID autonomously upon contact creation
    private String generateRandomContactID(){
        String uuid = UUID.randomUUID().toString().replaceAll("-","");
        return uuid.substring(0, Math.min(uuid.length(),10));
    }

    // method to access contactID
    public String getContactID() {
        return contactID;
    }

    // method to access firstName
    public String getFirstName() {
        return firstName;
    }

    // method to access lastName
    public String getLastName() {
        return lastName;
    }

    // method to access phoneNumber
    public String getPhoneNumber() {
        return phoneNumber;
    }

    // method to access address
    public String getAddress() {
        return address;
    }

    // method to mutate firstName
    public void setFirstName(String firstName) {
        if (firstName != null && firstName.length() >= 1 && firstName.length() <= 10) {
            this.firstName = firstName;
        } else {
            throw new IllegalArgumentException("First name must not be null and should be between 1 and 10 characters.");
        }
    }

    // method to mutate lastName
    public void setLastName(String lastName) {
        if (lastName != null && lastName.length() >= 1 && lastName.length() <= 10) {
            this.lastName = lastName;
        } else {
            throw new IllegalArgumentException("Last name must not be null and should be between 1 and 10 characters.");
        }
    }

    // method to mutate phoneNumber
    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber != null && phoneNumber.length() == 10) {
            this.phoneNumber = phoneNumber;
        } else {
            throw new IllegalArgumentException("Phone number must not be null and should be 10 characters.");
        }
    }

    // method to mutate address
    public void setAddress(String address) {
        if (address != null && address.length() >= 1 && address.length() <= 30) {
            this.address = address;
        } else {
            throw new IllegalArgumentException("Address must not be null and should be between 1 and 30 characters.");
        }
    }
}
