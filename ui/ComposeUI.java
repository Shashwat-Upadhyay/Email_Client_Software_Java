package com.emailclient.model.ui;

//package com.emailclient.ui;

import javax.swing.*;
import java.awt.*;

/**
 * Unit 6: Basic Java GUI (Swing) demonstrating various components and a Layout Manager (GridBagLayout).
 * Represents the window for composing and sending a new email.
 */
public class ComposeUI extends JFrame {

    // Unit 6: Components
    private final JTextField toField;
    private final JTextField subjectField;
    private final JTextArea bodyArea;
    private final JButton sendButton;
    private final JButton attachButton;

    public ComposeUI() {
        super("Compose New Email");

        // Use a more advanced layout for a clean form look
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Padding
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // --- To Field ---
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        mainPanel.add(new JLabel("To:"), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1.0; // Allow the field to stretch
        toField = new JTextField(30);
        mainPanel.add(toField, gbc);

        // --- Subject Field ---
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0;
        mainPanel.add(new JLabel("Subject:"), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1.0;
        subjectField = new JTextField(30);
        mainPanel.add(subjectField, gbc);

        // --- Body Area ---
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2; // Span across both columns
        gbc.weighty = 1.0; // Allow the body area to take vertical space
        gbc.fill = GridBagConstraints.BOTH;
        bodyArea = new JTextArea(10, 40);
        bodyArea.setBorder(BorderFactory.createTitledBorder("Body"));
        mainPanel.add(new JScrollPane(bodyArea), gbc); // JScrollPane for scrolling text

        // --- Buttons Panel ---
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT)); // Flow Layout
        attachButton = new JButton("Attach File");
        sendButton = new JButton("Send");

        // Example of simple event handling setup (logic omitted for simplicity)
        sendButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "Simulating email send...", "Compose", JOptionPane.INFORMATION_MESSAGE));

        buttonPanel.add(attachButton);
        buttonPanel.add(sendButton);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.EAST;
        mainPanel.add(buttonPanel, gbc);

        this.add(mainPanel, BorderLayout.CENTER);

        this.setSize(600, 500);
        this.setLocationRelativeTo(null); // Center on screen
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close this window, but not the whole app
    }
}
