package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

public abstract class AbstractStorage<SK> implements Storage {

    private static final Logger LOG = Logger.getLogger(AbstractStorage.class.getName());

    protected abstract SK getSearchKey(String uuid);

    protected abstract void doUpdate(Resume resume, SK key);

    protected abstract boolean isExist(SK key);

    protected abstract void doSave(Resume resume, SK key);

    protected abstract Resume doGet(SK key);

    protected abstract void doDelete(SK key);

    protected abstract List<Resume> doCopyAll();

    public void update(Resume resume) {
        LOG.info("update" + resume);
        doUpdate(resume, checkNotExist(resume.getUuid()));
    }

    public void save(Resume resume) {
        LOG.info("save" + resume);
        doSave(resume, checkExist(resume.getUuid()));
    }

    public void delete(String uuid) {
        LOG.info("delete" + uuid);
        doDelete(checkNotExist(uuid));
    }

    public Resume get(String uuid) {
        LOG.info("get" + uuid);
        return doGet(checkNotExist(uuid));
    }

    public List<Resume> getAllSorted() {
        LOG.info("getAllSorted");
        List<Resume> list = doCopyAll();
        list.sort(Comparator.comparing(Resume::getFullName).thenComparing(Resume::getUuid));
        return list;
    }

    private SK checkNotExist(String uuid) {
        SK key = getSearchKey(uuid);
        if (!isExist(key)) {
            LOG.warning("Resume " + uuid + " not exist");
            throw new NotExistStorageException(uuid);
        } else {
            return key;
        }
    }

    private SK checkExist(String uuid) {
        SK key = getSearchKey(uuid);
        if (isExist(key)) {
            LOG.warning("Resume " + uuid + " already exist");
            throw new ExistStorageException(uuid);
        } else {
            return key;
        }
    }
}
