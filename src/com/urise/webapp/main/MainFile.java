package com.urise.webapp.main;

public class MainFile {

    public static void main(String[] args) {
        FileProject findFile = new FileProject();
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
        String projectPath = "./src/com/urise/webapp";
        findFile.showProjectFile(projectPath);
    }
}
