# Simple File Manager (GUI)

## Overview

This application is a simple File Manager GUI built with Java Swing. It allows users to perform basic file management tasks such as copying, moving, deleting files, and managing directories within a specified path. Additionally, users can search for files within a directory.

## Features

- **Load Directory:** View the contents of a specified directory, including file names, sizes, and last modified dates.
- **Copy File:** Copy a file from one location to another within the directory.
- **Move File:** Move a file to a different location within the directory.
- **Delete File:** Delete a specified file from the directory.
- **Create Directory:** Create a new directory within the specified path.
- **Delete Directory:** Delete an existing directory (only if empty) from the specified path.
- **Search Files:** Search for files within the directory by name or extension.

## How to Use the Application

### 1. **Load Directory**

1. Enter the full path of the directory you want to explore in the `Directory Path` field.
2. Click the `Load Directory` button to display the contents of the directory in the `Directory Contents` area.

### 2. **Copy File**

1. In the `File Name` field, enter the name of the file you want to copy.
2. In the `Destination File Name` field, enter the name and path (relative to the current directory) where you want to copy the file.
    - For example, to copy `example.txt` to a subfolder called `NewFolder`, enter `NewFolder/example.txt`.
3. Click the `Copy` button. The file will be copied to the specified destination.

### 3. **Move File**

1. In the `File Name` field, enter the name of the file you want to move.
2. In the `Destination File Name` field, enter the name and path (relative to the current directory) where you want to move the file.
    - To move example.txt to a subfolder called NewFolder, enter NewFolder/example.txt.
    - For example, to move `example.txt` to the parent directory, enter `../example.txt`.
3. Click the `Move` button. The file will be moved to the specified destination.

### 4. **Delete File**

1. In the `File Name` field, enter the name of the file you want to delete.
2. Click the `Delete` button. The file will be deleted from the directory.

### 5. **Create Directory**

1. In the `Directory Name` field, enter the name of the new directory you want to create.
2. Click the `Create Directory` button. The directory will be created within the specified path.

### 6. **Delete Directory**

1. In the `Directory Name` field, enter the name of the directory you want to delete.
2. Click the `Delete Directory` button. The directory will be deleted if it is empty.

### 7. **Search Files**

1. In the `Search Query` field, enter the name or extension of the file you want to search for.
2. Click the `Search` button. The results will be displayed in the `Directory Contents` area.

## Error Handling

- If you attempt to delete a non-empty directory, an error message will be displayed.
- If a file or directory does not exist or the path is invalid, an error message will be shown.
- Proper feedback is provided in the `Directory Contents` area for all operations (successful or otherwise).

## Known Limitations

- The application currently handles file operations within the local file system only.
- Directories must be empty to be deleted.

## Running the Application

1. Compile the Java source code using an IDE like IntelliJ IDEA or from the command line.
2. Run the `FileManagerForm` class to launch the GUI.

---

This simple File Manager is a helpful tool for basic file operations within a specific directory. Enjoy managing your files with ease!