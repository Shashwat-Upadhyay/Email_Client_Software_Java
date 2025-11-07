package com.emailclient.model.main_tables;

/**
 * Unit 1: A simple model class to demonstrate Class and Object creation.
 * Represents a file attached to an email.
 */
public class Attachment {

    private String fileName;
    private long fileSizeInBytes;
    private String mimeType;

    // Unit 1: Parameterized Constructor
    public Attachment(String fileName, long fileSizeInBytes, String mimeType) {
        this.fileName = fileName;
        this.fileSizeInBytes = fileSizeInBytes;
        this.mimeType = mimeType;
    }

    // Unit 1: Getters
    public String getFileName() {
        return fileName;
    }

    public long getFileSizeInBytes() {
        return fileSizeInBytes;
    }

    public String getMimeType() {
        return mimeType;
    }

    @Override
    public String toString() {
        return fileName + " (" + (fileSizeInBytes / 1024) + " KB)";
    }
}
