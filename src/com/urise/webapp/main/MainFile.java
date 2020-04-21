package com.urise.webapp.main;

import java.io.File;

public class MainFile {

    public static void main(String[] args) {
        File file = new File("./src");
        showProjectFile(file);
    }

    public static void showProjectFile(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            assert files != null;
            for (File value : files) {
                System.out.printf("%" + (value.getName().length() + file.toPath().getNameCount()) + "s\n", value.getName());
                showProjectFile(value);
            }
        }
    }
}
