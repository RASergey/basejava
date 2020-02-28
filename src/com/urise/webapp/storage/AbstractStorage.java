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

    private Object checkNotExist(String uuid) {
        Object key = getIndex(uuid);
        if (!checkGetKey(key)) {
            throw new NotExistStorageException(uuid);
        } else {
            return key;
        }
    }

    private Object checkExist(String uuid) {
        Object key = getIndex(uuid);
        if (checkGetKey(key)) {
            throw new ExistStorageException(uuid);
        } else {
            return key;
        }
    }

    protected abstract void updateResume(Resume resume, Object key);

    protected abstract void saveResume(Resume resume, Object key);

    protected abstract void deleteResume(Object key);

    protected abstract Resume getResume(Object key);

    protected abstract Object getIndex(String uuid);

    protected abstract boolean checkGetKey(Object key);
}
