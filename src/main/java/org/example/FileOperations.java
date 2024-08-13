package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileOperations {
    private JTextField directoryPathField;  // TextField for the directory path
    private JTextField sourceFileField;  // TextField for the source file name
    private JTextField destinationFileField;  // TextField for the destination file name
    private JTextArea textArea1;  // TextArea to display operation results and messages

    // Constructor for FileOperations, initializing the required fields
    public FileOperations(JTextField directoryPathField, JTextField sourceFileField, JTextField destinationFileField, JTextArea outputArea, JTextField textArea1) {
        this.directoryPathField = directoryPathField;
        this.sourceFileField = sourceFileField;
        this.destinationFileField = destinationFileField;
        this.textArea1 = outputArea;
    }

    // Method to handle copying a file from source to destination
    public void copyFile(ActionEvent e) {
        String sourceFileName = sourceFileField.getText();  // Get the source file name from the text field
        String destinationFileName = destinationFileField.getText();  // Get the destination file name from the text field
        String sourceFilePath = directoryPathField.getText() + "/" + sourceFileName;  // Construct the full source file path
        File sourceFile = new File(sourceFilePath);  // Create a File object for the source file

        if (sourceFile.exists() && sourceFile.isFile()) {  // Check if the source file exists and is a file
            String destinationFilePath = directoryPathField.getText() + "/" + destinationFileName;  // Construct the full destination file path
            File destinationFile = new File(destinationFilePath);  // Create a File object for the destination file

            if (!destinationFile.exists()) {  // Ensure the destination file does not already exist
                try {
                    Files.copy(sourceFile.toPath(), destinationFile.toPath());  // Perform the file copy operation
                    textArea1.setText("File copied successfully.");  // Notify the user of success
                } catch (IOException ex) {
                    textArea1.setText("Failed to copy file: " + ex.getMessage());  // Notify the user of failure
                }
            } else {
                textArea1.setText("Destination file already exists.");  // Notify the user that the destination file exists
            }
        } else {
            textArea1.setText("Source file does not exist or is not a file.");  // Notify the user that the source file is invalid
        }
    }

    // Method to handle moving a file from source to destination
    public void moveFile(ActionEvent e) {
        String sourceFileName = sourceFileField.getText();  // Get the source file name from the text field
        String destinationFileName = destinationFileField.getText();  // Get the destination file name from the text field
        String sourceFilePath = directoryPathField.getText() + "/" + sourceFileName;  // Construct the full source file path
        File sourceFile = new File(sourceFilePath);  // Create a File object for the source file

        if (sourceFile.exists() && sourceFile.isFile()) {  // Check if the source file exists and is a file
            String destinationFilePath = directoryPathField.getText() + "/" + destinationFileName;  // Construct the full destination file path
            File destinationFile = new File(destinationFilePath);  // Create a File object for the destination file

            if (!destinationFile.exists()) {  // Ensure the destination file does not already exist
                try {
                    Files.move(sourceFile.toPath(), destinationFile.toPath());  // Perform the file move operation
                    textArea1.setText("File moved successfully.");  // Notify the user of success
                } catch (IOException ex) {
                    textArea1.setText("Failed to move file: " + ex.getMessage());  // Notify the user of failure
                }
            } else {
                textArea1.setText("Destination file already exists.");  // Notify the user that the destination file exists
            }
        } else {
            textArea1.setText("Source file does not exist or is not a file.");  // Notify the user that the source file is invalid
        }
    }

    // Method to handle deleting a file
    public void deleteFile(ActionEvent e) {
        String fileName = sourceFileField.getText();  // Get the file name from the text field
        String filePath = directoryPathField.getText() + "/" + fileName;  // Construct the full file path
        File fileToDelete = new File(filePath);  // Create a File object for the file to be deleted

        if (fileToDelete.exists() && fileToDelete.isFile()) {  // Check if the file exists and is a file
            if (fileToDelete.delete()) {  // Attempt to delete the file
                textArea1.setText("File deleted successfully.");  // Notify the user of success
            } else {
                textArea1.setText("Failed to delete file.");  // Notify the user of failure
            }
        } else {
            textArea1.setText("File does not exist or is not a file.");  // Notify the user that the file is invalid
        }
    }
}