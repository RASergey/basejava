package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index == -1) {
            System.out.println("\nERROR " + resume + " uuid not found\n");
        } else {
            storage[index] = resume;
        }
    }

    public void save(Resume resume) {
        if (resume == null) {
            System.out.println("\nERROR incorrect uuid input\n");
        } else {
            if (size >= STORAGE_LIMIT) {
                System.out.println("\nERROR resume limit exceeded\n");
            } else {
                if (getIndex(resume.getUuid()) != -1) {
                    System.out.println("\nERROR this " + resume + " uuid already exist\n");
                } else {
                    storage[size] = resume;
                    size++;
                }
            }
        }
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            System.out.println("\nERROR " + uuid + " resume not found\n");
        } else {
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    protected int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return i;
            }
        }
        return -1;
    }
}
