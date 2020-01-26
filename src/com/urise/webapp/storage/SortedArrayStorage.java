package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {
    protected int index = 0;

    @Override
    public void save(Resume resume) {
        index = ~getIndex(resume.getUuid());
        size++;
        if (index != size - 1) {
            for (int i = 0; i < size - index; i++) {
                storage[size - i] = storage[size - i - 1];
            }
        }
        storage[index] = resume;
    }

    @Override
    public void delete(String uuid) {
        index = getIndex(uuid);
        if (size - 1 - index >= 0) {
            System.arraycopy(storage, index + 1, storage, index, size - 1 - index);
        }
        storage[size - 1] = null;
        size--;
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
