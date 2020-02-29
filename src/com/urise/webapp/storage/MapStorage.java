package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {
    private Map<String, Resume> storage = new HashMap<>();

    public int size() {
        return storage.size();
    }

    public void clear() {
        storage.clear();
    }

    public Resume[] getAll() {
        return storage.values().toArray(Resume[]::new);
    }

    @Override
    protected void updateResume(Resume resume, Object key) {
        storage.put((String) key, resume);
    }

    @Override
    protected void saveResume(Resume resume, Object key) {
        storage.put((String) key, resume);
    }

    @Override
    protected void deleteResume(Object key) {
        storage.remove((String) key);
    }

    @Override
    protected Resume getResume(Object key) {
        return storage.get((String) key);
    }

    protected String getIndex(String uuid) {
        return uuid;
    }

    @Override
    protected boolean checkGetKey(Object key) {
        return storage.containsKey((String) key);
    }
}
