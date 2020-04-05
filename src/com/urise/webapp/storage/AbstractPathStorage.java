package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class AbstractPathStorage extends AbstractStorage<Path> {
    private Path directory;

    protected AbstractPathStorage(String dir) {
        directory = Paths.get(dir);
        Objects.requireNonNull(directory, "directory must not be null");
        if (!Files.isDirectory(directory) || !Files.isWritable(this.directory)) {
            throw new IllegalArgumentException(dir + " is not directory or is not writable");
        }
    }

    protected abstract void doWrite(Resume resume, OutputStream os) throws IOException;

    protected abstract Resume doRead(InputStream is) throws IOException;

    @Override
    protected Path getSearchKey(String uuid) {
        return Paths.get(directory.toAbsolutePath().toString(), uuid);
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
        try {
            Files.list(directory.toAbsolutePath()).forEach(this::doDelete);
        } catch (IOException e) {
            throw new StorageException("Path delete error", null);
        }
    }

    @Override
    public int size() {
        try {
            return (int) Files.list(directory.toAbsolutePath()).count();
        } catch (IOException e) {
            throw new StorageException("directory is empty", directory.getFileName().toString(), e);
        }
    }

    @Override
    protected void doUpdate(Resume resume, Path path) {
        try {
            doWrite(resume, Files.newOutputStream(path));
        } catch (IOException e) {
            throw new StorageException("IO error ", path.getFileName() + " not exist", e);
        }
    }

    @Override
    protected Resume doGet(Path path) {
        try {
            return doRead(Files.newInputStream(path));
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
        List<Resume> list = new ArrayList<>();
        try {
            Files.list(directory.toAbsolutePath()).forEach(path -> list.add(doGet(path)));
        } catch (IOException e) {
            throw new StorageException("directory must not be null", directory.getFileName().toString());
        }
        return list;
    }
}
