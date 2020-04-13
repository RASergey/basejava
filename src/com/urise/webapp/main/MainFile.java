package com.urise.webapp.main;

import com.urise.webapp.exception.StorageException;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class MainFile {

    public static void main(String[] args) {

        Path path = Paths.get("./src");
        try {
            Files.walkFileTree(path, new SimpleFileVisitor<>() {

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                    int count = file.getNameCount() - path.getNameCount() + 1;
                    count += file.getFileName().toString().length();

                    String text = String.format("%" + count + "s", file.getFileName());
                    text = text.replaceAll("[\\s]", "  ");
                    System.out.println(text);
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
                    int count = dir.getNameCount() - path.getNameCount() + 1;
                    count += dir.getFileName().toString().length();

                    String text = String.format("%" + count + "s", dir.getFileName());
                    text = text.replaceAll("[\\s]", "  ");
                    System.out.println(text);
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            throw new StorageException("there was a problem reading the file ", path.getFileName().toString(), e);
        }
    }
}
