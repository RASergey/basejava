package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    public void update(Resume resume) {
        updateResume(resume, checkNotExist(resume.getUuid()));
    }

    public void save(Resume resume) {
        saveResume(resume, checkExist(resume.getUuid()));
    }

    public void delete(String uuid) {
        deleteResume(checkNotExist(uuid));
    }

    public Resume get(String uuid) {
        return getResume(checkNotExist(uuid));
    }

    private int checkNotExist(String uuid) {
        Integer index = getIndex(uuid);
        if (index == null || index < 0) {
            throw new NotExistStorageException(uuid);
        } else {
            return index;
        }
    }

    private int checkExist(String uuid) {
        Integer index = getIndex(uuid);
        if (index == null) {
            return size();
        } else if (index >= 0) {
            throw new ExistStorageException(uuid);
        } else {
            return index;
        }
    }

    protected abstract void updateResume(Resume resume, int index);

    protected abstract void saveResume(Resume resume, int index);

    protected abstract void deleteResume(int index);

    protected abstract Resume getResume(int index);

    protected abstract Integer getIndex(String uuid);
}
