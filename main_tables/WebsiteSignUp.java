package com.emailclient.model.main_tables;

//package com.emailclient.model;

/**
 * Unit 1: Demonstrates Class, Object, Constructor, and relationship concepts.
 * Represents an external website registration associated with a user's email.
 */
public class WebsiteSignUp {

    // Instance variables based on the ER Diagram attributes
    private final String signUpId;
    private final String userId; // Foreign Key reference to User
    private String name;        // Website Name (e.g., "GitHub")
    private String domainName;  // Domain Name (e.g., "github.com")

    /**
     * Unit 1: Parameterized Constructor.
     * @param signUpId Unique ID for this registration record.
     * @param userId The ID of the user who owns this sign-up.
     * @param name The name of the website/service.
     * @param domainName The website's domain name.
     */
    public WebsiteSignUp(String signUpId, String userId, String name, String domainName) {
        this.signUpId = signUpId;
        this.userId = userId;
        this.name = name;
        this.domainName = domainName;
    }

    // Unit 1: Getters
    public String getSignUpId() {
        return signUpId;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getDomainName() {
        return domainName;
    }

    // Unit 1: Setter (Example for mutable field)
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Unit 2: String usage for a descriptive output.
     */
    @Override
    public String toString() {
        return "SignUp ID: " + signUpId +
                " | Website: " + name +
                " | Domain: " + domainName +
                " | User ID: " + userId;
    }
}
