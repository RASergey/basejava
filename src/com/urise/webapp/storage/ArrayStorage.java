package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10_000];
    private int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume index) {
        if (checkIndex(index.toString()) < 0) {
            System.out.println("\nERROR " + index + " uuid doesn't exist\n");
        } else {
            storage[checkIndex(index.toString())] = index;
        }
    }

    public void save(Resume index) {
        if (index == null) {
            System.out.println("\nERROR incorrect uuid input\n");
        } else {
            if (checkIndex(index.toString()) > 0 || size > storage.length - 1) {
                System.out.println("\nERROR this " + index + " uuid already exist or the uuid limit is too high\n");
            } else {
                storage[size] = index;
                size++;
            }
        }
    }

    public Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    public void delete(String uuid) {
        if (checkIndex(uuid) < 0) {
            System.out.println("\nERROR " + uuid + " uuid doesn't exist\n");
        } else {
            if (storage[checkIndex(uuid)].getUuid().equals(uuid)) {
                System.arraycopy(storage, size - 1, storage, checkIndex(uuid), 1);
                storage[size - 1] = null;
                size--;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }

    private int checkIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}
