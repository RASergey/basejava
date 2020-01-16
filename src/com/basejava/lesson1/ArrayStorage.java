package com.basejava.lesson1;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int countResume = 0;

    void clear() {
        countResume = 0;
        Arrays.fill(storage, null);
    }

    void save(Resume r) {
        storage[countResume] = r;
        countResume++;
    }

    Resume get(String uuid) {
        for (int i = 0; i < size(); i++) {
            if (storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < size() - 1; i++) {
            if (storage[i].uuid.equals(uuid)) {
                Resume buff = storage[i];
                storage[i] = storage[i + 1];
                storage[i + 1] = buff;
            }
        }
        storage[size() - 1] = null;
        countResume--;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, size());
    }

    int size() {
        return countResume;
    }
}
