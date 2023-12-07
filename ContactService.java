package com;
import java.util.HashMap;
import java.util.Map;

public class ContactService {
    // local storage setup through a Map
    private Map<String, Contact> contactsMap = new HashMap<>();

    // method to add contacts
    public void addContact(Contact contact) {
        // append contacts to the map
        contactsMap.put(contact.getContactID(), contact);
    }

    // method to update contacts
    public void updateContact(String contactID, Contact updatedContact) {
        if (contactsMap.containsKey(contactID)) {
            contactsMap.put(contactID, updatedContact);
        } else {
            throw new IllegalArgumentException("Contact with ID " + contactID + " not found.");
        }
    }

    // method to delete contact
    public void deleteContact(String contactID) {
        if (contactsMap.containsKey(contactID)) {
            contactsMap.remove(contactID);
        } else {
            throw new IllegalArgumentException("Contact with ID " + contactID + " not found.");
        }
    }

    // method to access contact
    public Contact getContact(String contactID) {
        return contactsMap.get(contactID);
    }

    // method to access all contacts
    public Map<String, Contact> getAllContacts() {
        return contactsMap;
    }
}