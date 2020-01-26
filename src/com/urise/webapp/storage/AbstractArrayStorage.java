package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10_000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index < 0) {
            System.out.println("\nERROR " + resume + " not found\n");
        } else {
            storage[index] = resume;
        }
    }

    public void templateSave(Resume resume) {
        if (resume.getUuid() == null) {
            System.out.println("\nERROR incorrect uuid input\n");
        } else if (size > STORAGE_LIMIT - 1) {
            System.out.println("\nERROR resume limit exceeded\n");
        } else if (getIndex(resume.getUuid()) >= 0) {
            System.out.println("\nERROR this " + resume + " uuid already exist\n");
        } else {
            save(resume);
        }
    }

    public abstract void save(Resume resume);

    public int size() {
        return size;
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            System.out.println("\nERROR " + uuid + " resume not found");
            return null;
        }
        return storage[index];
    }

    public void templateDelete(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            System.out.println("\nERROR " + uuid + " resume not found\n");
        } else {
            delete(uuid);
        }
    }

    public abstract void delete(String uuid);

    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    protected abstract int getIndex(String uuid);
}
