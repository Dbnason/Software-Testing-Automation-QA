package com.tests;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import com.Contact;
import com.ContactService;

public class ContactServiceTest {
    private ContactService contactService;

    @Before
    public void setUp() {
        contactService = new ContactService();
    }

    // Test method to ensure adding a contact is successful
    @Test
    public void testAddContact() {
        Contact contact = new Contact("John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);

        assertEquals(contact, contactService.getContact(contact.getContactID()));
    }

    // Test updateContact method to make sure user can successfully update a contact
    @Test
    public void testUpdateContact() {
        Contact originalContact = new Contact("John", "Doe", "1234567890", "123 Main St");
        Contact updatedContact = new Contact("Jane", "Smith", "9876543210", "456 Elm St");
        contactService.addContact(originalContact);
        contactService.updateContact(originalContact.getContactID(), updatedContact);

        assertEquals(updatedContact, contactService.getContact(originalContact.getContactID()));
    }

    // Test deleteContact method to make sure user can successfully delete a contact
    @Test
    public void testDeleteContact() {
        Contact contact = new Contact("John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);
        contactService.deleteContact(contact.getContactID());

        assertNull(contactService.getContact(contact.getContactID()));
    }

    // Test to attempt to retrieve a contact 
    @Test
    public void testGetContact() {
        Contact contact = new Contact("John", "Doe", "1234567890", "123 Main St");
        contactService.addContact(contact);

        assertEquals(contact, contactService.getContact(contact.getContactID()));
    }

    // Test to retrieve all contacts
    @Test
    public void testGetAllContacts() {
        Contact contact1 = new Contact("John", "Doe", "1234567890", "123 Main St");
        Contact contact2 = new Contact("Jane", "Smith", "9876543210", "456 Elm St");
        contactService.addContact(contact1);
        contactService.addContact(contact2);

        assertEquals(2, contactService.getAllContacts().size());
        assertTrue(contactService.getAllContacts().containsValue(contact1));
        assertTrue(contactService.getAllContacts().containsValue(contact2));
    }

    // Test to attempt to retrieve a contact that doesn't exist, expecting IllegalArgumentException
    @Test(expected = IllegalArgumentException.class)
    public void testUpdateNonExistentContact() {
        Contact updatedContact = new Contact("Jane", "Smith", "9876543210", "456 Elm St");
        contactService.updateContact("nonexistentID", updatedContact);
    }

    // Test to delete a contact that doesn't exist, expecting IllegalArgumentException
    @Test(expected = IllegalArgumentException.class)
    public void testDeleteNonExistentContact() {
        contactService.deleteContact("nonexistentID");
    }
}