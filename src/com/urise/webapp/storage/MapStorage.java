package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.LinkedHashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {
    private Map<String, Resume> storage = new LinkedHashMap<>();

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
    protected void updateResume(Resume resume, int index) {
        storage.put(resume.getUuid(), resume);
    }

    @Override
    protected void saveResume(Resume resume, int index) {
        storage.put(resume.getUuid(), resume);
    }

    @Override
    protected void deleteResume(String uuid, int index) {
        storage.remove(uuid);
    }

    @Override
    protected Resume getResume(String uuid, int index) {
        return storage.get(uuid);
    }

    @Override
    protected Integer getIndex(String uuid) {
        for (Map.Entry<String, Resume> resume : storage.entrySet()) {
            if (resume.getKey().equals(uuid)) {
                return storage.get(uuid).hashCode();
            }
        }
        return null;
    }
}
