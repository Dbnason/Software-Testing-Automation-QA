package com.tests;

import static org.junit.Assert.*;
import org.junit.Test;

import com.Contact;

public class ContactTest {

    // Test creating a contact and checking its initial values
    @Test
    public void testCreateContact() {
        Contact contact = new Contact("John", "Doe", "1234567890", "123 Main St");

        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhoneNumber());
        assertEquals("123 Main St", contact.getAddress());
        assertNotNull(contact.getContactID());
    }

     // Test to check method for a succesful change of the firstName field
    @Test
    public void testChangeFirstName() {
        Contact contact = new Contact("John", "Doe", "1234567890", "123 Main St");
        contact.setFirstName("Jane");
        assertEquals("Jane", contact.getFirstName());
    }

    // Test setting a null first name, expecting an IllegalArgumentException
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidFirstName() {
        // Test null first name
        Contact contact = new Contact("John", "Doe", "1234567890", "123 Main St");
        contact.setFirstName(null);
    }
    
    // Test setting a first name longer than 10 characters, expecting an IllegalArgumentException
    @Test(expected = IllegalArgumentException.class)
    public void testToLongFirstName() {
        // Test first name longer than 10 characters
        Contact contact = new Contact("John", "Doe", "1234567890", "123 Main St");
        contact.setFirstName("Barthallamue");
    }

    // Test to check method for a succesful change of the lastName field
    @Test
    public void testChangeLastName() {
        Contact contact = new Contact("John", "Doe", "1234567890", "123 Main St");
        contact.setLastName("Smith");
        assertEquals("Smith", contact.getLastName());
    }

    // Test setting a null last name, expecting an IllegalArgumentException
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidLastName() {
        Contact contact = new Contact("John", "Doe", "1234567890", "123 Main St");
        contact.setLastName(null);
    }

    // Test setting a last name longer than 20 characters, expecting an IllegalArgumentException
    @Test(expected = IllegalArgumentException.class)
    public void testToLongLastName() {
        Contact contact = new Contact("John", "Doe", "1234567890", "123 Main St");
        contact.setLastName("Wolfeschlegelsteinhausenbergerdorff");
    }

    // Test to check method for a successful change of the phoneNumber field
    @Test
    public void testChangePhoneNumber() {
        Contact contact = new Contact("John", "Doe", "1234567890", "123 Main St");
        contact.setPhoneNumber("9876543210");
        assertEquals("9876543210", contact.getPhoneNumber());
    }

    // Test setting a null phone number, expecting an IllegalArgumentException
    @Test(expected = IllegalArgumentException.class) 
    public void testInvalidPhoneNumber() {
        Contact contact = new Contact("John", "Doe", "1234567890", "123 Main St");
        contact.setPhoneNumber(null);
    }

    // Test setting a short phone number, expecting an IllegalArgumentException
    @Test(expected = IllegalArgumentException.class)
    public void testShortPhoneNumber() {
        Contact contact = new Contact("John", "Doe", "1234567890", "123 Main St");
        contact.setPhoneNumber("910");
    }

    // Test setting a long phone number, expecting an IllegalArgumentException
    @Test(expected = IllegalArgumentException.class)
    public void testLongPhoneNumber() {
        Contact contact = new Contact("John", "Doe", "1234567890", "123 Main St");
        contact.setPhoneNumber("91055580001");
    }

    // Test to check method for a successful change of the address field
    @Test
    public void testChangeAddress() {
        Contact contact = new Contact("John", "Doe", "1234567890", "123 Main St");
        contact.setAddress("456 Oak St");
        assertEquals("456 Oak St", contact.getAddress());
    }

    // Test setting a null address, expecting an IllegalArgumentException
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidAddress() {
        Contact contact = new Contact("John", "Doe", "1234567890", "123 Main St");
        contact.setAddress(null);
    }

    // Test setting a long address, expecting an IllegalArgumentException
    @Test(expected = IllegalArgumentException.class)
    public void testLongAddress() {
        Contact contact = new Contact("John", "Doe", "1234567890", "123 Main St");
        contact.setAddress("115 pembroke pointe ocean island way");
    }
}