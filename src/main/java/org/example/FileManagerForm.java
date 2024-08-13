package org.example;
import javax.swing.*;

public class FileManagerForm {
    private JPanel mainPanel;  // The main panel that holds all GUI components
    private JTextField directoryPathField;  // TextField for entering the directory path
    private JButton loadDirectoryButton;  // Button to load the directory contents
    private JTextArea textArea1;  // TextArea to display directory contents and messages
    private JTextField sourceFileNameField;  // TextField for entering the source file name
    private JTextField destinationFileNameField;  // TextField for entering the destination file name
    private JButton copyButton;  // Button to copy the file
    private JButton moveButton;  // Button to move the file
    private JButton deleteButton;  // Button to delete the file
    private JTextField newDirectoryField;  // TextField for entering the new directory name
    private JButton createDirectoryButton;  // Button to create a new directory
    private JTextField deleteDirectoryField;  // TextField for entering the directory name to be deleted
    private JButton deleteDirectoryButton;  // Button to delete the directory
    private JTextField searchTextField;  // TextField for entering the search query
    private JButton searchButton;  // Button to search for files

    // Constructor for FileManagerForm, responsible for setting up the GUI and attaching event listeners
    public FileManagerForm() {
        // Initialize FileOperations and DirectoryOperations with the necessary fields
        FileOperations fileOps = new FileOperations(directoryPathField, sourceFileNameField, destinationFileNameField, textArea1, searchTextField);
        DirectoryOperations dirOps = new DirectoryOperations(directoryPathField, newDirectoryField, deleteDirectoryField, textArea1, searchTextField);

        // Attach the appropriate action listeners to the buttons
        copyButton.addActionListener(fileOps::copyFile);  // Attach copy file action
        moveButton.addActionListener(fileOps::moveFile);  // Attach move file action
        deleteButton.addActionListener(fileOps::deleteFile);  // Attach delete file action
        createDirectoryButton.addActionListener(dirOps::createDirectory);  // Attach create directory action
        deleteDirectoryButton.addActionListener(dirOps::deleteDirectory);  // Attach delete directory action
        loadDirectoryButton.addActionListener(dirOps::loadDirectory);  // Attach load directory action
        searchButton.addActionListener(dirOps::searchFiles);  // Attach search files action
    }

    // Getter method for the mainPanel, used in the Main class to set the content pane
    public JPanel getMainPanel() {
        return mainPanel;
    }


}