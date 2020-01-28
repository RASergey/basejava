package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10_000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public int size() {
        return size;
    }

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

    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public void save(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (resume.getUuid() == null) {
            System.out.println("\nERROR incorrect uuid input\n");
        } else if (size >= STORAGE_LIMIT) {
            System.out.println("\nERROR resume limit exceeded\n");
        } else if (index >= 0) {
            System.out.println("\nERROR this " + resume + " uuid already exist\n");
        } else {
            insertElement(index, resume);
            size++;
        }
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            System.out.println("\nERROR " + uuid + " resume not found\n");
        } else {
            if (size - 1 > index) {
                fillDeletedElement(index);
            }
            storage[size - 1] = null;
            size--;
        }
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            System.out.println("\nERROR " + uuid + " resume not found");
            return null;
        }
        return storage[index];
    }

    protected abstract void fillDeletedElement(int index);

    protected abstract void insertElement(int index, Resume resume);

    protected abstract int getIndex(String uuid);
}
