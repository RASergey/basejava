package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size = 0;

    public void clear() {
        size = 0;
        Arrays.fill(storage, 0, size, null);
    }

    public void update(String uuid) {
        isNotContains(uuid);
    }

    public void save(Resume r) {
        if (isContains(r) && r.toString() != null) {
            storage[size] = r;
            size++;
        } else {
            System.out.println("ERROR");
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
        if (isNotContains(uuid)) {
            for (int i = 0; i < size; i++) {
                if (storage[i].getUuid().equals(uuid)) {
                    System.arraycopy(storage, i + 1, storage, i, size - 1 - i);
                    storage[size - 1] = null;
                    size--;
                }
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

    private boolean isContains(Resume r) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(r.toString())) {
                System.out.println("ERROR");
                return false;
            }
        }
        return true;
    }

    private boolean isNotContains(String uuid) {
        for (int i = 0; i < size; i++) {
            for (int j = i; j < size; j++) {
                if (storage[i].getUuid().equals(uuid)) {
                    return true;
                }
            }
        }
        System.out.println("ERROR");
        return false;
    }
}
