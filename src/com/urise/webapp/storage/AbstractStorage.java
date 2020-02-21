package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        checkNotExist(resume.getUuid(), index);
        updateResume(resume, index);
    }

    public void save(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (resume.getUuid() == null) {
            throw new NullPointerException("NullPointerException");
        } else if (index >= 0) {
            throw new ExistStorageException(resume.getUuid());
        } else {
            saveResume(resume, index);
        }
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        checkNotExist(uuid, index);
        deleteResume(index);
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        checkNotExist(uuid, index);
        return getResume(index);
    }

    private void checkNotExist(String uuid, int index) {
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        }
    }

    protected abstract void updateResume(Resume resume, int index);

    protected abstract void saveResume(Resume resume, int index);

    protected abstract void deleteResume(int index);

    protected abstract Resume getResume(int index);

    protected abstract int getIndex(String uuid);
}
