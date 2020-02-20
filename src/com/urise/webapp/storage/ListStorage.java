package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

public class ListStorage extends AbstractStorage {

    @Override
    protected int sizeResumes() {
        return storage.size();
    }

    @Override
    public void clearAll() {
       storage.clear();
    }

    @Override
    protected void updateResume(Resume resume) {
        storage.set(getIndex(resume.getUuid()), resume);
    }

    @Override
    protected Resume[] getAllResume() {
        return storage.toArray(Resume[]::new);
    }

    @Override
    protected void saveResume(Resume resume) {
        storage.add(resume);
    }

    @Override
    protected void deleteResume(String uuid) {
        storage.remove(getIndex(uuid));
    }

    @Override
    protected Resume getResume(String uuid) {
        return storage.get(getIndex(uuid));
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume(uuid);
        if (storage.contains(searchKey)) {
            return storage.indexOf(searchKey);
        }
        return -1;
    }
}
