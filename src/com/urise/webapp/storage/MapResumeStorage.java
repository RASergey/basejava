package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.*;

public class MapResumeStorage extends AbstractStorage {
    private Map<String, Resume> map = new HashMap<>();

    private class FullName {
        private int count = 0;

        private void giveFullName(Resume resume) {
            String[] names = {"Nicholas Booth", "Harry Grant", "James Fox", "Harry Grant"};
            resume.setFullName(names[count++]);
        }

        private List<Resume> sortResume() {
            List<Resume> list = new ArrayList<>(map.values());
            list.sort(Comparator.comparing(Resume::getFullName));
            return list;
        }

        private Resume updateResume(Resume resume) {
            resume.setFullName("Peter Parker");
            return resume;
        }
    }

    FullName fullName = new FullName();

    @Override
    protected Object getSearchKey(String uuid) {
        return uuid;
    }

    @Override
    protected boolean isExist(Object key) {
        return map.containsKey((String) key);
    }

    @Override
    protected void doUpdate(Resume resume, Object key) {
        map.replace((String) key, fullName.updateResume(resume));
    }

    @Override
    protected void doSave(Resume resume, Object key) {
        map.put((String) key, resume);
        fullName.giveFullName(resume);
    }

    @Override
    protected void doDelete(Object key) {
        map.remove((String) key);
    }

    @Override
    protected Resume doGet(Object key) {
        return map.get((String) key);
    }

    @Override
    public List<Resume> getAllSorted() {
        return fullName.sortResume();
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
