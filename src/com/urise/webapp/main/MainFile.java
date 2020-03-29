package com.urise.webapp.main;

import java.io.File;

public class MainFile {

    public static void main(String[] args) {
//        String filePath = "./.gitignore";
//
//        File file = new File(filePath);
//        try {
//            System.out.println(file.getCanonicalPath());
//        } catch (IOException e) {
//            throw new RuntimeException("Error", e);
//        }
//
//        try(FileInputStream fis = new FileInputStream(filePath);) {
//            System.out.println(fis.read());
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        String projectPath = "./src";
        showProjectFile(projectPath);
    }

    public static void showProjectFile(String path) {
        File dir = new File(path);
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file: files) {
                if (file.isFile()) {
                    System.out.println("File: " + file.getName());
                } else if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getName());
                    showProjectFile(file.getAbsolutePath());
                }
            }
        }
    }
}