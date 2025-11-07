
package com.emailclient.model.ui;

import com.emailclient.model.main_tables.User;
import com.emailclient.model.service.UserService;

import javax.swing.*;
        import java.awt.*;
        import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginUI extends JFrame {
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton signUpButton;
    private UserService userService;

    public LoginUI(UserService userService) {
        this.userService = userService;

        setTitle("Email Client Login");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        // Title
        JLabel titleLabel = new JLabel("Email Client Login");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(titleLabel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        // Email panel
        JPanel emailPanel = new JPanel(new BorderLayout(10, 0));
        emailPanel.setMaximumSize(new Dimension(400, 30));
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setPreferredSize(new Dimension(80, 25));
        emailField = new JTextField();
        emailPanel.add(emailLabel, BorderLayout.WEST);
        emailPanel.add(emailField, BorderLayout.CENTER);
        mainPanel.add(emailPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        // Password panel
        JPanel passwordPanel = new JPanel(new BorderLayout(10, 0));
        passwordPanel.setMaximumSize(new Dimension(400, 30));
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setPreferredSize(new Dimension(80, 25));
        passwordField = new JPasswordField();
        passwordPanel.add(passwordLabel, BorderLayout.WEST);
        passwordPanel.add(passwordField, BorderLayout.CENTER);
        mainPanel.add(passwordPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        // Button panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        loginButton = new JButton("Login");
        signUpButton = new JButton("Sign Up");
        buttonPanel.add(loginButton);
        buttonPanel.add(signUpButton);
        mainPanel.add(buttonPanel);

        add(mainPanel);

        // Action listeners
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleLogin();
            }
        });

        // Allow Enter key to trigger login
        passwordField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleLogin();
            }
        });

        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openSignUpWindow();
            }
        });
    }

    private void handleLogin() {
        String email = emailField.getText().trim();
        String password = new String(passwordField.getPassword());

        if (email.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Please enter both email and password",
                    "Login Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Authenticate user
        User user = userService.authenticate(email, password);

        if (user != null) {
            JOptionPane.showMessageDialog(this,
                    "Login successful! Welcome " + user.getFullName(),
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE);

            // Close login window
            this.dispose();

            // Open Inbox window
            SwingUtilities.invokeLater(() -> {
                InboxUI inboxUI = new InboxUI(user);
                inboxUI.setVisible(true);
            });
        } else {
            JOptionPane.showMessageDialog(this,
                    "Invalid email or password",
                    "Login Failed",
                    JOptionPane.ERROR_MESSAGE);
            passwordField.setText(""); // Clear password field
        }
    }

    private void openSignUpWindow() {
        SwingUtilities.invokeLater(() -> {
            WebsiteSignUpUI signUpUI = new WebsiteSignUpUI(userService, this);
            signUpUI.setVisible(true);
        });
    }
}
