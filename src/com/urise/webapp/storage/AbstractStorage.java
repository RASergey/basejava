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
        Object index = getIndex(uuid);
        if (!checkGetIndex(index)) {
            throw new NotExistStorageException(uuid);
        } else {
            return index;
        }
    }

    private Object checkExist(String uuid) {
        Object index = getIndex(uuid);
        if (index == null) {
            return size();
        } else if (checkGetIndex(index)) {
            throw new ExistStorageException(uuid);
        } else {
            return index;
        }
    }

    protected abstract void updateResume(Resume resume, Object index);

    protected abstract void saveResume(Resume resume, Object index);

    protected abstract void deleteResume(Object index);

    protected abstract Resume getResume(Object index);

    protected abstract Object getIndex(String uuid);

    protected abstract boolean checkGetIndex(Object index);
}
