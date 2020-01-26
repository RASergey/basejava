package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public interface Storage {

    void clear();

    void update(Resume resume);

    void templateSave(Resume resume);

    Resume get(String uuid);

    void templateDelete(String uuid);

    Resume[] getAll();

    int size();
}