package com.urise.webapp.main;

import java.io.File;

public class FileProject {
    public void showProjectFile(String path) {
        File file = new File(path);
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            String[] list = file.list();
            if (files != null) {
                for (int i = 0; i < files.length; i++) {
                    if (list != null) {
                        System.out.println(list[i]);
                    }
                    showProjectFile(files[i].getAbsolutePath());
                }
                System.out.println();
            }
        } else {
            System.out.println(file.getName());
        }
    }
}
