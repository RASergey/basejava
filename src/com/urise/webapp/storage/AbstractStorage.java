package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

import java.util.ArrayList;

public abstract class AbstractStorage implements Storage {
    protected ArrayList<Resume> storage = new ArrayList<>();

    public int size() {
        return sizeResumes();
    }

    public void clear() {
        clearAll();
    }

    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index < 0) {
            throw new NotExistStorageException(resume.getUuid());
        } else {
            updateResume(resume);
        }
    }

    public Resume[] getAll() {
        return getAllResume();
    }

    public void save(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (resume.getUuid() == null) {
            throw new NullPointerException("NullPointerException");
        } else if (index >= 0) {
            throw new ExistStorageException(resume.getUuid());
        } else {
            saveResume(resume);
        }
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        } else {
            deleteResume(uuid);
        }
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        }
        return getResume(uuid);
    }

    protected abstract int sizeResumes();
    protected abstract void clearAll();
    protected abstract void updateResume(Resume resume);
    protected abstract Resume[] getAllResume();
    protected abstract void saveResume(Resume resume);
    protected abstract void deleteResume(String uuid);
    protected abstract Resume getResume(String uuid);
    protected abstract int getIndex(String uuid);
}
