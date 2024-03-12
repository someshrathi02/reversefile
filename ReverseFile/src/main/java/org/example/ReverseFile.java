package org.example;

import java.io.FileOutputStream;
import java.io.InputStream;

public class ReverseFile {
    public static void main(String[] args) {
        InputStream inputStream = ReverseFile.class.getResourceAsStream("/input.txt");
        if (inputStream != null) {
            try {
                String content = FileHandler.readFile(inputStream);
                String reversedContent = StringReverser.reverse(content);
                System.out.println(reversedContent);
                String currentDirectory = System.getProperty("user.dir");
                String outputPath = currentDirectory + "/output.txt";
                FileHandler.writeFile(new FileOutputStream(outputPath), reversedContent);
            } catch (Exception e) {
                System.err.println("An error occurred: " + e.getMessage());
            }
        } else {
            System.err.println("File not found.");
        }
    }

}