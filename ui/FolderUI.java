package com.emailclient.model.ui;

//package com.emailclient.ui;

import javax.swing.*;
import java.awt.*;

/**
 * Unit 6: Basic Java GUI (Swing) demonstrating JList, JScrollPane, and Layouts.
 * Represents a view for managing and viewing custom folders.
 */
public class FolderUI extends JFrame {

    private final JList<String> folderList;
    private final JTextField newFolderField;

    public FolderUI() {
        super("Manage Folders");

        // Unit 6: Border Layout Manager for the main frame
        this.setLayout(new BorderLayout(10, 10));

        // --- Center: Folder List ---
        // Unit 6: JList component and dummy data
        String[] folderNames = {"Inbox", "Sent Items", "Drafts", "Archive", "Work Projects", "Personal"};
        folderList = new JList<>(folderNames);
        folderList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        folderList.setFont(new Font("SansSerif", Font.PLAIN, 14));

        JScrollPane scrollPane = new JScrollPane(folderList); // JScrollPane is essential for JList
        scrollPane.setBorder(BorderFactory.createTitledBorder("Existing Folders"));
        this.add(scrollPane, BorderLayout.CENTER);

        // --- South: New Folder Creation ---
        JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10)); // Flow Layout

        southPanel.add(new JLabel("New Folder Name:"));
        newFolderField = new JTextField(15);
        southPanel.add(newFolderField);

        JButton createButton = new JButton("Create Folder");
        // Simple event handling demonstration
        createButton.addActionListener(e -> {
            String folderName = newFolderField.getText().trim();
            if (!folderName.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Simulating creation of folder: " + folderName, "Folder Management", JOptionPane.INFORMATION_MESSAGE);
                newFolderField.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Please enter a name.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        southPanel.add(createButton);
        this.add(southPanel, BorderLayout.SOUTH);

        this.setSize(450, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
