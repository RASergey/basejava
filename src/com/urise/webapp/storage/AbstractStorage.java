package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

import java.util.Comparator;
import java.util.List;

public abstract class AbstractStorage<SK> implements Storage {

    protected abstract SK getSearchKey(String uuid);

    protected abstract void doUpdate(Resume resume, SK key);

    protected abstract boolean isExist(SK key);

    protected abstract void doSave(Resume resume, SK key);

    protected abstract Resume doGet(SK key);

    protected abstract void doDelete(SK key);

    protected abstract List<Resume> doCopyAll();

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
        List<Resume> list = doCopyAll();
        list.sort(Comparator.comparing(Resume::getFullName).thenComparing(Resume::getUuid));
        return list;
    }

    private SK checkNotExist(String uuid) {
        SK key = getSearchKey(uuid);
        if (!isExist(key)) {
            throw new NotExistStorageException(uuid);
        } else {
            return key;
        }
    }

    private SK checkExist(String uuid) {
        SK key = getSearchKey(uuid);
        if (isExist(key)) {
            throw new ExistStorageException(uuid);
        } else {
            return key;
        }
    }
}
