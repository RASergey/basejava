package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;
import com.urise.webapp.strategies.ContextStrategy;
import com.urise.webapp.strategies.ObjectStreamStrategy;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PathStorage extends AbstractStorage<Path> {
    private Path directory;

    ContextStrategy strategy = new ContextStrategy(new ObjectStreamStrategy());

    public PathStorage(String dir) {
        directory = Paths.get(dir);
        Objects.requireNonNull(directory, "directory must not be null");
        if (!Files.isDirectory(directory) || !Files.isWritable(this.directory)) {
            throw new IllegalArgumentException(dir + " is not directory or is not writable");
        }
    }

    @Override
    protected Path getSearchKey(String uuid) {
        return directory.resolve(uuid);
    }

    @Override
    protected boolean isExist(Path path) {
        return Files.exists(path);
    }

    @Override
    protected void doSave(Resume resume, Path path) {
        try {
            Files.createFile(path);
        } catch (IOException e) {
            throw new StorageException("not created Path ", path.getFileName().toString(), e);
        }
        doUpdate(resume, path);
    }

    @Override
    public void clear() {
        checkNonNull().forEach(this::doDelete);
    }

    @Override
    public int size() {
        return (int) checkNonNull().count();
    }

    @Override
    public void doUpdate(Resume resume, Path path) {
        try {
            strategy.doWrite(resume, new BufferedOutputStream(Files.newOutputStream(path)));
        } catch (IOException e) {
            throw new StorageException("IO error ", path.getFileName() + " not exist", e);
        }
    }

    @Override
    public Resume doGet(Path path) {
        try {
            return strategy.doRead(new BufferedInputStream(Files.newInputStream(path)));
        } catch (IOException e) {
            throw new StorageException("IO error ", path.getFileName() + " not exist", e);
        }
    }

    @Override
    protected void doDelete(Path path) {
        try {
            Files.delete(path.toAbsolutePath());
        } catch (IOException e) {
            throw new StorageException("error!", path.getFileName() + " not exist");
        }
    }

    @Override
    protected List<Resume> doCopyAll() {
        return checkNonNull().map(this::doGet).collect(Collectors.toList());
    }

    private Stream<Path> checkNonNull() {
        try {
            return Files.list(directory);
        } catch (IOException e) {
            throw new StorageException("directory must not be null", directory.getFileName().toString(), e);
        }
    }
}
