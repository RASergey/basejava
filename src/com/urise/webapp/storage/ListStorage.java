package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {
    private List<Resume> list = new ArrayList<>();

    @Override
    protected Integer getSearchKey(String uuid) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return null;
    }

    @Override
    protected boolean isExist(Object key) {
        return key != null;
    }

    @Override
    protected void doUpdate(Resume resume, Object key) {
        list.set((Integer) key, resume);
    }

    @Override
    protected void doSave(Resume resume, Object index) {
        list.add(resume);
    }

    @Override
    protected void doDelete(Object key) {
        list.remove(((Integer) key).intValue());
    }

    @Override
    protected Resume doGet(Object key) {
        return list.get((Integer) key);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public List<Resume> getAll() {
        return List.copyOf(list);
    }
}
