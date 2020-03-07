package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.*;

public class MapUuidStorage extends AbstractStorage<String> {
    private Map<String, Resume> map = new HashMap<>();

    @Override
    protected String getSearchKey(String uuid) {
        return uuid;
    }

    @Override
    protected boolean isExist(String key) {
        return map.containsKey(key);
    }

    @Override
        protected void doUpdate(Resume resume, String key) {
        map.put(key, resume);
    }

    @Override
    protected void doSave(Resume resume, String key) {
        map.put(key, resume);
    }

    @Override
    protected void doDelete(String key) {
        map.remove(key);
    }

    @Override
    protected Resume doGet(String key) {
        return map.get(key);
    }

    @Override
    public List<Resume> doCopyAll() {
        return new ArrayList<>(map.values());
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public int size() {
        return map.size();
    }
}
