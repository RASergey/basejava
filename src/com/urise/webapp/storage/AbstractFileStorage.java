package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class AbstractFileStorage extends AbstractStorage<File> {
    private File dir;

    protected AbstractFileStorage(String directory) {
        File checkDir = new File(directory);
        Objects.requireNonNull(checkDir, "directory must not be null");
        if (!checkDir.isDirectory()) {
            throw new IllegalArgumentException(checkDir.getAbsolutePath() + " is not directory");
        }
        if (!checkDir.canRead() || !checkDir.canWrite()) {
            throw new IllegalArgumentException(checkDir.getAbsolutePath() + " is not readable/writable");
        }
        this.dir = checkDir;
    }

    protected abstract void doWrite(Resume resume, OutputStream os) throws IOException;

    protected abstract Resume doRead(InputStream is) throws IOException;

    @Override
    protected File getSearchKey(String uuid) {
        return new File(dir, uuid);
    }

    @Override
    protected boolean isExist(File file) {
        return file.exists();
    }

    @Override
    protected void doSave(Resume resume, File file) {
        try {
            if (!file.createNewFile()) {
                throw new StorageException(" already exist", file.getName());
            }
        } catch (IOException e) {
            throw new StorageException("not created file ", file.getName(), e);
        }
        doUpdate(resume, file);
    }

    @Override
    protected void doUpdate(Resume resume, File file) {
        try {
            doWrite(resume, new BufferedOutputStream(new FileOutputStream(file)));
        } catch (IOException e) {
            throw new StorageException("IO error ", file.getName() + " not exist", e);
        }
    }

    @Override
    protected Resume doGet(File file) {
        try {
            return doRead(new BufferedInputStream(new FileInputStream(file)));
        } catch (IOException e) {
            throw new StorageException("IO error ", file.getName() + " not exist", e);
        }
    }

    @Override
    protected void doDelete(File file) {
        if (!file.delete()) {
            throw new StorageException("error!", file.getName() + " not exist");
        }
    }

    @Override
    protected List<Resume> doCopyAll() {
        List<Resume> list = new ArrayList<>();
        for (File resume : checkNonNull()) {
            list.add(doGet(resume));
        }
        return list;
    }

    @Override
    public void clear() {
        for (File file : checkNonNull()) {
            doDelete(file);
        }
    }

    @Override
    public int size() {
        String[] list = dir.list();
        if (list == null) {
            throw new StorageException("directory is empty", dir.getName());
        } else {
            return list.length;
        }
    }

    private File[] checkNonNull() {
        File[] listFiles = dir.listFiles();
        if (listFiles == null) {
            throw new StorageException("directory must not be null", dir.getName());
        } else {
            return listFiles;
        }
    }
}
