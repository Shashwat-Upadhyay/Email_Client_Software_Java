package com.emailclient.model.exception;

//package com.emailclient.exception;

/**
 * Unit 5: User-defined (Custom) Checked Exception.
 * Must extend Exception (for checked) or RuntimeException (for unchecked).
 * This is a Checked Exception, meaning the caller must handle or declare it.
 */
public class InvalidEmailException extends Exception {

    // Recommended: Add a serialVersionUID for serialization
    private static final long serialVersionUID = 1L;

    /**
     * Unit 5: Custom exception constructor with a message.
     * @param message The detail message.
     */
    public InvalidEmailException(String message) {
        super(message);
    }

    /**
     * Custom exception constructor with a message and a cause.
     * @param message The detail message.
     * @param cause The cause (e.g., another exception).
     */
    public InvalidEmailException(String message, Throwable cause) {
        super(message, cause);
    }
}

