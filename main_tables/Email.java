package com.emailclient.model.main_tables;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.UUID;

/**
 * Unit 1 & 2: Represents an Email object.
 * Demonstrates: Classes, Objects, Multiple Constructors, Strings, and Arrays.
 */
public class Email{

    // Unit 1: Data members/Attributes
    private String emailId; // Unique identifier
    private String sender;
    private String recipient;
    private String subject;
    private String body;
    private final LocalDateTime timestamp;
    private String folderName; // Inbox, Sent, Drafts, etc.

    // Unit 2: Array of objects (Attachment)
    private Attachment[] attachments;

    /**
     * Unit 1: Parameterized Constructor (Full set of required fields)
     * This is the original, detailed constructor.
     */
    public Email(String sender, String recipient, String subject, String body, String folderName, Attachment[] attachments){
        this.emailId = UUID.randomUUID().toString(); // Unit 2: Use of String utility
        this.sender = sender;
        this.recipient = recipient;
        this.subject = subject;
        this.body = body;
        this.timestamp = LocalDateTime.now();
        this.folderName = folderName;
        this.attachments = attachments;
    }

    /**
     * Unit 1: Overloaded Constructor (Simplified, used for generating sample data)
     * This constructor sets default values for folderName and attachments (which fixed your error).
     */
    public Email(String sender, String recipient, String subject, String body){
        // Calls the primary constructor with default/empty values
        this(sender, recipient, subject, body, "Inbox", new Attachment[0]);
    }

    // --- Unit 1 & 2: Getters and Setters ---
    public String getEmailID(){
        return emailId;
    }

    public void setEmailID(String emailID){
        this.emailId = emailId;
    }

    public String getSender(){
        return sender;
    }

    // Setter for sender allows changing the 'from' address (e.g., if replying from a different account)
    public void setSender(String sender){
        this.sender = sender;
    }

    public String getRecipient(){
        return recipient;
    }

    public void setRecipient(String recipient){
        this.recipient = recipient;
    }

    public String getSubject(){
        return subject;
    }

    public void setSubject(String subject){
        this.subject = subject;
    }

    public String getBody(){
        return body;
    }

    public void setBody(String body){
        this.body = body;
    }

    public LocalDateTime getTimestamp(){
        return timestamp;
    }

    public String getFolderName(){
        return folderName;
    }

    public void setFolderName(String folderName){
        this.folderName = folderName;
    }

    public Attachment[] getAttachments(){
        return attachments;
    }

    public void setAttachments(Attachment[] attachments){
        this.attachments = attachments;
    }

    /**
     * Unit 2: Demonstrates String and Array utility methods
     */
    @Override
    public String toString(){
        // Unit 2: String concatenation and java.util.Arrays utility
        return "Email [ID=" + emailId.substring(0, 8) +
                ", From=" + sender +
                ", Subject='" + subject + '\'' +
                ", Attachments=" + attachments.length +
                ", Folder=" + folderName +
                ']';
    }
}
