package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10_000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;
    protected int index = 0;

    public abstract void clear();

    public abstract void update(Resume resume);

    public abstract void save(Resume resume);

    public int size() {
        return size;
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            System.out.println("\nERROR " + uuid + " resume not found");
            return null;
        }
        return storage[index];
    }

    public abstract void delete(String uuid);

    public abstract Resume[] getAll();

    protected abstract int getIndex(String uuid);
}
