package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.*;

public class MapResumeStorage extends AbstractStorage {
    private Map<String, Resume> map = new HashMap<>();

    @Override
    protected Resume getSearchKey(String uuid) {
        return new Resume(uuid);
    }

    @Override
    protected boolean isExist(Object key) {
        Resume resume = (Resume) key;
        return map.containsKey(resume.getUuid());
    }

    @Override
    protected void doUpdate(Resume resume, Object key) {
        Resume resume2 = (Resume) key;
        map.replace(resume.getUuid(), resume);
    }

    @Override
    protected void doSave(Resume resume, Object key) {
        Resume resume2 = (Resume) key;
        map.put(resume.getUuid(), resume);
    }

    @Override
    protected void doDelete(Object key) {
        Resume resume = (Resume) key;
        map.remove(resume.getUuid());
    }

    @Override
    protected Resume doGet(Object key) {
        Resume resume = (Resume) key;
        return map.get(resume.getUuid());
    }

    @Override
    public List<Resume> getAll() {
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
