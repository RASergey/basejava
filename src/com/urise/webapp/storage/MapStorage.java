package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {
    private Map<Integer, String> storage = new HashMap<>();

    public int size() {
        return storage.size();
    }

    public void clear() {
        storage.clear();
    }

    public Resume[] getAll() {
        String[] array = storage.values().toArray(String[]::new);
        Resume[] resume = new Resume[array.length];
        for (int i = 0; i < resume.length; i++) {
            resume[i] = new Resume(array[i]);
        }
        return resume;
    }

    @Override
    protected void updateResume(Resume resume, int index) {
        storage.put(index, resume.getUuid());
        System.out.println(storage.get(index));
    }

    @Override
    protected void saveResume(Resume resume, int index) {
        storage.put(index, resume.getUuid());
    }

    @Override
    protected void deleteResume(int index) {
        storage.remove(index);
    }

    @Override
    protected Resume getResume(int index) {
        return new Resume(storage.get(index));
    }

    @Override
    protected Integer getIndex(String uuid) {
        for (int i = 0; i < storage.size(); i++) {
            if (storage.get(i).equals(uuid)) {
                return i;
            }
        }
        return null;
    }
}
