package org.example;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

    // Create the main application window (JFrame)
    JFrame frame = new JFrame("File Manager");
        // Set the content pane to the main panel from FileManagerForm
        frame.setContentPane(new FileManagerForm(). getMainPanel());
        // Ensure the application exits when the window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Size the window to fit the preferred size and layouts of its components
        frame.pack();
        // Make the window visible
        frame.setVisible(true);
        // Allow the window to be resized by the user
        frame.setResizable(true);

    }
}