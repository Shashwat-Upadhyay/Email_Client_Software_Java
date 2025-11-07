package com.emailclient.model.main_tables;

/**
 * Unit 1: Demonstrates Class, Object, Instance Variables, and Constructors.
 * Represents a user account in the email client.
 */
public class User {

    // Instance variables (fields) - Unit 1
    private String userId;
    private String emailAddress;
    private String firstName;
    private String lastName;
    private String password;

    // Unit 1: Parameterized Constructor
    public User(String userId, String emailAddress, String firstName, String lastName, String passwordHash) {
        // Unit 1: 'this' reference to distinguish instance variable from parameter
        this.userId = userId;
        this.emailAddress = emailAddress;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

    // In UserService.java
    public User authenticate(String email, String password) {
        // Simple authentication against the mock list
        for (User user : registeredUsers) {
            // Check both email and password for a match
            if (user..equalsIgnoreCase(email) && user.getPassword().equals(password)) {
                return user; // Authentication successful
            }
        }
        return null; // Authentication failed
    }
    // Unit 1: Getter methods (Accessors)
    public String getUserId() {
        return userId;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPasswordHash() {
        return password;
    }

    // Unit 2: String manipulation example (utility method)
    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public String toString() {
        return "User ID: " + userId + " | Email: " + emailAddress + " | Name: " + getFullName();
    }
}
