package com.contacts;

import java.util.HashMap;
import java.util.Map;

public class ContactService {
    // Map to store contacts with contactID as the key
    private final Map<String, Contact> contacts = new HashMap<>();

    // Adds a new contact if the contact ID is unique; returns true if successful, false if contact ID already exists
    public boolean addContact(Contact contact) {
        if (contact == null || contacts.containsKey(contact.getContactID())) {
            return false;
        }
        contacts.put(contact.getContactID(), contact);
        return true;
    }

    // Deletes a contact by ID; returns true if contact was found and removed, false otherwise
    public boolean deleteContact(String contactID) {
        return contacts.remove(contactID) != null;
    }

    // Updates specific fields of an existing contact identified by contactID
    public boolean updateContact(String contactID, String firstName, String lastName, String phone, String address) {
        Contact contact = contacts.get(contactID);
        
        // Check if the contact exists
        if (contact == null) {
            return false;
        }
        
        // Update fields only if provided and meet length constraints
        if (firstName != null && firstName.length() <= 10) {
            contact.setFirstName(firstName);
        }
        if (lastName != null && lastName.length() <= 10) {
            contact.setLastName(lastName);
        }
        if (phone != null && phone.length() == 10) {
            contact.setPhone(phone);
        }
        if (address != null && address.length() <= 30) {
            contact.setAddress(address);
        }
        
        return true;
    }
}
