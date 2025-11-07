package com.emailclient.model.main_tables;

import java.util.ArrayList;
import java.util.List;

/**
 * Unit 1 & 2: Demonstrates Constructors and the underlying concept of a collection (List).
 * Represents an email folder (e.g., Inbox, Sent, Drafts).
 */
public class Folder {

    private String name;
    // Using List here to conceptually replace a raw array for better functionality (Unit 5 concept)
    private List<Email> emails;

    // Unit 1: Parameterized Constructor
    public Folder(String name) {
        this.name = name;
        // Unit 2/5: Initialization of the collection
        this.emails = new ArrayList<>();
    }

    // Unit 1: Getters and Setters
    public String getName() {
        return name;
    }

    public List<Email> getEmails() {
        return emails;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Helper method to add an email to the folder (conceptually part of Unit 2 methods).
     * @param email The email to add.
     */
    public void addEmail(Email email) {
        if (email != null) {
            emails.add(email);
        }
    }

    // Unit 2: Method demonstrating length/size
    public int getEmailCount() {
        return emails.size();
    }
}

