package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public abstract class AbstractStorage implements Storage {

    protected abstract Object getSearchKey(String uuid);

    protected abstract void doUpdate(Resume resume, Object key);

    protected abstract boolean isExist(Object key);

    protected abstract void doSave(Resume resume, Object key);

    protected abstract Resume doGet(Object key);

    protected abstract void doDelete(Object key);

    protected abstract List<Resume> getAll();

    public void update(Resume resume) {
        doUpdate(resume, checkNotExist(resume.getUuid()));
    }

    public void save(Resume resume) {
        doSave(resume, checkExist(resume.getUuid()));
    }

    public void delete(String uuid) {
        doDelete(checkNotExist(uuid));
    }

    public Resume get(String uuid) {
        return doGet(checkNotExist(uuid));
    }

    public List<Resume> getAllSorted() {
        List<Resume> list = new ArrayList<>(getAll());
        list.sort(Comparator.comparing(Resume::getFullName).thenComparing(Resume::getUuid));
        return list;
    }

    private Object checkNotExist(String uuid) {
        Object key = getSearchKey(uuid);
        if (!isExist(key)) {
            throw new NotExistStorageException(uuid);
        } else {
            return key;
        }
    }

    private Object checkExist(String uuid) {
        Object key = getSearchKey(uuid);
        if (isExist(key)) {
            throw new ExistStorageException(uuid);
        } else {
            return key;
        }
    }
}
