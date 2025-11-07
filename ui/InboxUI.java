package com.emailclient.model.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Unit 6: Another basic Java GUI to represent the main application window.
 * Uses Border and Grid Layout Managers.
 */
public class InboxUI extends JFrame {

    public InboxUI(String userName) {
        super("Email Client - Inbox");

        // Unit 6: Border Layout Manager for the main frame
        this.setLayout(new BorderLayout());

        // North Panel (FlowLayout default)
        JPanel headerPanel = new JPanel();
        headerPanel.add(new JLabel("Welcome, " + userName + " | "));
        headerPanel.add(new JButton("Compose"));
        this.add(headerPanel, BorderLayout.NORTH);

        // West Panel (Grid Layout Manager)
        JPanel folderPanel = new JPanel(new GridLayout(4, 1));
        folderPanel.setBorder(BorderFactory.createTitledBorder("Folders"));
        // Unit 6: List / Choice concept
        folderPanel.add(new JButton("Inbox (5)"));
        folderPanel.add(new JButton("Sent Items"));
        folderPanel.add(new JButton("Drafts"));
        folderPanel.add(new JButton("Spam"));
        this.add(folderPanel, BorderLayout.WEST);

        // Center Panel (Main content area)
        JTextArea emailListArea = new JTextArea("1. Subject: Project Update | From: co-worker@comp.com\n2. Subject: Meeting Reminder | From: calendar@app.com");
        emailListArea.setEditable(false);
        this.add(new JScrollPane(emailListArea), BorderLayout.CENTER);

        // Frame setup
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        // Example of Window Event Handling (using anonymous inner class) - Unit 4
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("Application is closing...");
            }
        });
    }
}

