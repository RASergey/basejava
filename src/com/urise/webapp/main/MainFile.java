package com.urise.webapp.main;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MainFile {

    public static void main(String[] args) {
        String projectPath = "./src";
        showProjectFile(projectPath);
    }

    public static void showProjectFile(String path) {
        File file = new File(path);
        StringBuilder count = new StringBuilder();
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            String[] list = file.list();
            Path dir = file.toPath();
            int dirNameCount = dir.getNameCount();
            while (Paths.get("./src").toAbsolutePath().getNameCount() < dirNameCount) {
                count.append("  ");
                dirNameCount--;
            }
            if (files != null) {
                for (int i = 0; i < files.length; i++) {
                    if (list != null) {
                        System.out.println(count + list[i]);
                    }
                    showProjectFile(files[i].getAbsolutePath());
                }
            }
        }
    }
}
