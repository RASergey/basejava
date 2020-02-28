package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapStorage extends AbstractStorage {
    private Map<Object, Resume> storage = new HashMap<>();

    public int size() {
        return storage.size();
    }

    public void clear() {
        storage.clear();
    }

    public Resume[] getAll() {
        Map<Object, Resume> sortedStorage = new TreeMap<>(storage);
        return sortedStorage.values().toArray(Resume[]::new);
    }

    @Override
    protected void updateResume(Resume resume, Object index) {
        storage.put(index, resume);
    }

    @Override
    protected void saveResume(Resume resume, Object index) {
        storage.put(index, resume);
    }

    @Override
    protected void deleteResume(Object index) {
        storage.remove(index);
    }

    @Override
    protected Resume getResume(Object index) {
        return storage.get(index);
    }

    protected String getIndex(String uuid) {
        return uuid;
    }

    @Override
    protected boolean checkGetIndex(Object uuid) {
        return storage.containsKey(uuid);
    }
}
