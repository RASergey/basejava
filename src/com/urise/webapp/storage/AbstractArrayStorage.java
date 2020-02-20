package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage extends AbstractStorage {
    protected static final int STORAGE_LIMIT = 10_000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    @Override
    protected int sizeResumes() {
        return size;
    }

    @Override
    protected void clearAll() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    protected void updateResume(Resume resume) {
        storage[getIndex(resume.getUuid())] = resume;
    }

    @Override
    protected Resume[] getAllResume() {
        return Arrays.copyOf(storage, size);
    }

    @Override
    protected void saveResume(Resume resume) {
        if (size >= STORAGE_LIMIT) {
            throw new StorageException("Storage overflow", resume.getUuid());
        } else {
            insertElement(getIndex(resume.getUuid()), resume);
            size++;
        }
    }

    @Override
    protected void deleteResume(String uuid) {
        int index = getIndex(uuid);
        if (size - 1 > index) {
            fillDeletedElement(index);
        }
        storage[size - 1] = null;
        size--;
    }

    @Override
    protected Resume getResume(String uuid) {
        return storage[getIndex(uuid)];
    }

    protected abstract void fillDeletedElement(int index);

    protected abstract void insertElement(int index, Resume resume);

    protected abstract int getIndex(String uuid);
}
