package com.emailclient.model.ui;

import com.emailclient.model.main_tables.User;
import com.emailclient.model.service.UserService;

import javax.swing.*;
import java.awt.*;

public class WebsiteSignUpUI extends JFrame {
    private UserService userService;
    private LoginUI loginUI;
    private JTextField nameField;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private JButton signUpButton;
    private JButton cancelButton;

    public WebsiteSignUpUI(UserService userService, LoginUI loginUI) {
        this.userService = userService;
        this.loginUI = loginUI;

        setTitle("Sign Up - Create Account");
        setSize(450, 350);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(loginUI);
        setResizable(false);

        // Main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        // Title
        JLabel titleLabel = new JLabel("Create New Account");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(titleLabel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        // Name field
        JPanel namePanel = new JPanel(new BorderLayout(10, 0));
        namePanel.setMaximumSize(new Dimension(400, 30));
        JLabel nameLabel = new JLabel("Full Name:");
        nameLabel.setPreferredSize(new Dimension(120, 25));
        nameField = new JTextField();
        namePanel.add(nameLabel, BorderLayout.WEST);
        namePanel.add(nameField, BorderLayout.CENTER);
        mainPanel.add(namePanel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        // Email field
        JPanel emailPanel = new JPanel(new BorderLayout(10, 0));
        emailPanel.setMaximumSize(new Dimension(400, 30));
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setPreferredSize(new Dimension(120, 25));
        emailField = new JTextField();
        emailPanel.add(emailLabel, BorderLayout.WEST);
        emailPanel.add(emailField, BorderLayout.CENTER);
        mainPanel.add(emailPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        // Password field
        JPanel passwordPanel = new JPanel(new BorderLayout(10, 0));
        passwordPanel.setMaximumSize(new Dimension(400, 30));
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setPreferredSize(new Dimension(120, 25));
        passwordField = new JPasswordField();
        passwordPanel.add(passwordLabel, BorderLayout.WEST);
        passwordPanel.add(passwordField, BorderLayout.CENTER);
        mainPanel.add(passwordPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        // Confirm password field
        JPanel confirmPanel = new JPanel(new BorderLayout(10, 0));
        confirmPanel.setMaximumSize(new Dimension(400, 30));
        JLabel confirmLabel = new JLabel("Confirm Password:");
        confirmLabel.setPreferredSize(new Dimension(120, 25));
        confirmPasswordField = new JPasswordField();
        confirmPanel.add(confirmLabel, BorderLayout.WEST);
        confirmPanel.add(confirmPasswordField, BorderLayout.CENTER);
        mainPanel.add(confirmPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        // Button panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));

        signUpButton = new JButton("Sign Up");
        signUpButton.setBackground(new Color(0, 120, 215));
        signUpButton.setForeground(Color.WHITE);
        signUpButton.setFocusPainted(false);
        signUpButton.addActionListener(e -> handleSignUp());

        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(e -> dispose());

        buttonPanel.add(signUpButton);
        buttonPanel.add(cancelButton);
        mainPanel.add(buttonPanel);

        add(mainPanel);
    }

    private void handleSignUp() {
        String name = nameField.getText().trim();
        String email = emailField.getText().trim();
        String password = new String(passwordField.getPassword());
        String confirmPassword = new String(confirmPasswordField.getPassword());

        // Validation
        if (name.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Please fill in all fields",
                    "Validation Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            JOptionPane.showMessageDialog(this,
                    "Please enter a valid email address",
                    "Validation Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (password.length() < 6) {
            JOptionPane.showMessageDialog(this,
                    "Password must be at least 6 characters long",
                    "Validation Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(this,
                    "Passwords do not match",
                    "Validation Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            // Create user
            User user = new User();
            user.setName(name);
            user.setEmail(email);
            user.setPassword(password);

            boolean registered = userService.registerUser(user);

            if (registered) {
                JOptionPane.showMessageDialog(this,
                        "Account created successfully! You can now login.",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this,
                        "Email already exists. Please use a different email.",
                        "Registration Failed",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Error creating account: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}
