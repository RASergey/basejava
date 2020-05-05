package com.urise.webapp.main;

import java.io.File;

public class MainFile {

    public static void main(String[] args) {
        File file = new File("./src");
        showProjectFile(file, "");
    }

    public static void showProjectFile(File dir, String offset) {
        if (dir.isDirectory()) {
            File[] files = dir.listFiles();
            if (files != null) {
                for (File file: files) {
                    if (file.isFile()) {
                        System.out.println(offset + "F: " + file.getName());
                    } else if (file.isDirectory()) {
                        System.out.println(offset + "D: " + file.getName());
                        showProjectFile(file, offset + "  ");
                    }
                }
            }
        }
    }
}
