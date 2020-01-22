package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    public void update(Resume resume) {
        index = getIndex(resume.getUuid());
        if (index < 0) {
            System.out.println("\nERROR " + resume + " not found\n");
        } else {
            storage[index] = resume;
        }
    }

    @Override
    public void save(Resume resume) {
        int checkIndex = ~getIndex(resume.getUuid());
        if (size >= STORAGE_LIMIT) {
            System.out.println("\nERROR resume limit exceeded\n");
        } else {
            if (checkIndex < 0) {
                System.out.println("\nERROR this " + resume + " already exist\n");
            } else if (checkIndex >= index) {
                System.arraycopy(storage, checkIndex, storage, checkIndex + 1, size);
                index = checkIndex;
                storage[index] = resume;
                size++;
            }
        }
    }

    @Override
    public void delete(String uuid) {
        index = getIndex(uuid);
        if (index < 0) {
            System.out.println("\nERROR " + uuid + " resume not found\n");
        } else {
            if (size - 1 - index >= 0) {
                System.arraycopy(storage, index + 1, storage, index, size - 1 - index);
            }
            storage[size - 1] = null;
            size--;
        }
    }

    @Override
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
