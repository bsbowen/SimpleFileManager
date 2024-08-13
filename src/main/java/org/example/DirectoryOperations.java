package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;

public class DirectoryOperations {
    private JTextField directoryPathField;  // TextField for the base directory path
    private JTextField newDirectoryField;  // TextField for the name of the new directory to be created
    private JTextField deleteDirectoryField;  // TextField for the name of the directory to be deleted
    private JTextField searchTextField;  // TextField for the search
    private JTextArea outputArea;  // TextArea to display results and messages to the user

    // Constructor for DirectoryOperations, initializing the required fields
    public DirectoryOperations(JTextField directoryPathField, JTextField newDirectoryField, JTextField deleteDirectoryField, JTextArea outputArea, JTextField searchTextField) {
        this.directoryPathField = directoryPathField;
        this.newDirectoryField = newDirectoryField;
        this.deleteDirectoryField = deleteDirectoryField;
        this.outputArea = outputArea;
        this.searchTextField = searchTextField;
    }

    // Method to create a new directory
    public void createDirectory(ActionEvent e) {
        String newDirectoryName = newDirectoryField.getText();  // Get the name for the new directory from the text field
        String newDirectoryPath = directoryPathField.getText() + "/" + newDirectoryName;  // Construct the full path for the new directory
        File newDirectory = new File(newDirectoryPath);  // Create a File object for the new directory

        if (!newDirectory.exists()) {  // Check if the directory does not already exist
            if (newDirectory.mkdir()) {  // Attempt to create the directory
                outputArea.setText("Directory created successfully.");  // Notify the user of success
            } else {
                outputArea.setText("Failed to create directory.");  // Notify the user of failure
            }
        } else {
            outputArea.setText("Directory already exists.");  // Notify the user that the directory already exists
        }
    }

    // Method to delete a directory
    public void deleteDirectory(ActionEvent e) {
        String directoryNameToDelete = deleteDirectoryField.getText();  // Get the name of the directory to delete from the text field
        String directoryPathToDelete = directoryPathField.getText() + "/" + directoryNameToDelete;  // Construct the full path for the directory to delete
        File directoryToDelete = new File(directoryPathToDelete);  // Create a File object for the directory to be deleted

        if (directoryToDelete.exists() && directoryToDelete.isDirectory()) {  // Check if the directory exists and is indeed a directory
            if (directoryToDelete.delete()) {  // Attempt to delete the directory
                outputArea.setText("Directory deleted successfully.");  // Notify the user of success
            } else {
                outputArea.setText("Failed to delete directory. Make sure it is empty.");  // Notify the user of failure, likely due to non-empty directory
            }
        } else {
            outputArea.setText("Directory does not exist or is not a directory.");  // Notify the user that the directory is invalid
        }
    }

    // Method to load and display the contents of a directory
    public void loadDirectory(ActionEvent e) {
        String directoryPath = directoryPathField.getText();  // Get the directory path from the text field
        File directory = new File(directoryPath);  // Create a File object for the directory

        if (directory.exists() && directory.isDirectory()) {  // Check if the directory exists and is a directory
            StringBuilder contents = new StringBuilder();  // Prepare a StringBuilder to accumulate the directory contents
            File[] files = directory.listFiles();  // Get a list of all files and directories within the directory

            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        contents.append("[DIR] ");  // Mark directories with a [DIR] tag
                    } else if (file.isFile()) {
                        contents.append("[FILE] ");  // Mark files with a [FILE] tag
                    }
                    contents.append("Name: ").append(file.getName()).append("\n");  // Append the file or directory name
                    contents.append("Size: ").append(file.length()).append(" bytes\n");  // Append the size
                    contents.append("Last modified: ").append(file.lastModified()).append("\n");  // Append the last modified timestamp
                    contents.append("-------------\n");  // Append a separator for clarity
                }
            } else {
                contents.append("Directory is empty or cannot be read.");  // Handle the case where the directory is empty or inaccessible
            }
            outputArea.setText(contents.toString());  // Display the directory contents in the text area
        } else {
            outputArea.setText("Invalid directory path.");  // Notify the user that the directory path is invalid
        }
    }

    // Method to search for files and directories within the specified directory based on a query
    public void searchFiles(ActionEvent e) {
        String searchQuery = searchTextField.getText().toLowerCase();  // Get the search query and convert it to lowercase
        String directoryPath = directoryPathField.getText();  // Get the directory path from the text field
        File directory = new File(directoryPath);  // Create a File object for the directory

        if (directory.exists() && directory.isDirectory()) {  // Check if the directory exists and is a directory
            StringBuilder searchResults = new StringBuilder();  // Prepare a StringBuilder to accumulate the search results
            File[] files = directory.listFiles();  // Get a list of all files and directories within the directory

            if (files != null) {
                for (File file : files) {
                    if (file.getName().toLowerCase().contains(searchQuery)) {  // Check if the file or directory name contains the search query
                        if (file.isDirectory()) {
                            searchResults.append("[DIR] ");  // Mark directories with a [DIR] tag
                        } else if (file.isFile()) {
                            searchResults.append("[FILE] ");  // Mark files with a [FILE] tag
                        }
                        searchResults.append("Name: ").append(file.getName()).append("\n");  // Append the file or directory name
                        searchResults.append("Size: ").append(file.length()).append(" bytes\n");  // Append the size
                        searchResults.append("Last modified: ").append(file.lastModified()).append("\n");  // Append the last modified timestamp
                        searchResults.append("-------------\n");  // Append a separator for clarity
                    }
                }
                if (searchResults.length() == 0) {
                    searchResults.append("No files or directories matched the query.");  // Notify the user if no matches were found
                }
            } else {
                searchResults.append("Directory is empty or cannot be read.");  // Handle the case where the directory is empty or inaccessible
            }
            outputArea.setText(searchResults.toString());  // Display the search results in the text area
        } else {
            outputArea.setText("Invalid directory path.");  // Notify the user that the directory path is invalid
        }
    }
}