package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public abstract class AbstractStorageTest {
    protected static final File STORAGE_DIR = new File("./storage");
    protected Storage storage;
    protected static Resume RESUME_1 = ResumeTestData.RESUME_1;
    protected static final Resume RESUME_2 = ResumeTestData.RESUME_2;
    protected static final Resume RESUME_3 = ResumeTestData.RESUME_3;
    protected static final Resume RESUME_4 = ResumeTestData.RESUME_4;
    protected static final Resume RESUME_5 = ResumeTestData.RESUME_5;
    protected static final Resume RESUME_DUMMY = ResumeTestData.RESUME_DUMMY;

    public AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() {
        storage.clear();
        storage.save(RESUME_1);
        storage.save(RESUME_2);
        storage.save(RESUME_3);
        storage.save(RESUME_4);
    }

    @Test
    public void size() {
        assertSize(4);
    }

    @Test
    public void clear() {
        storage.clear();
        assertSize(0);
    }

    @Test
    public void update() {
        storage.update(RESUME_5);
        assertEquals(RESUME_5, storage.get(RESUME_3.getUuid()));
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() {
        storage.update(RESUME_DUMMY);
    }

    @Test
    public void getAllSorted() {
        List<Resume> list = Arrays.asList(RESUME_2, RESUME_1, RESUME_3, RESUME_4);
        assertEquals(list, storage.getAllSorted());
        assertEquals(list.size(), storage.getAllSorted().size());
    }

    @Test
    public void save() {
        storage.save(RESUME_DUMMY);
        assertSize(5);
        assertGet(RESUME_DUMMY);
    }

    @Test(expected = ExistStorageException.class)
    public void saveExist() {
        storage.save(RESUME_2);
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() {
        storage.delete(RESUME_3.getUuid());
        assertSize(3);
        storage.get(RESUME_3.getUuid());
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() {
        storage.delete(RESUME_DUMMY.getUuid());
    }

    @Test
    public void get() {
        assertGet(RESUME_1);
        assertGet(RESUME_2);
        assertGet(RESUME_3);
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() {
        storage.get(RESUME_DUMMY.getUuid());
    }

    private void assertGet(Resume resume) {
        assertEquals(resume, storage.get(resume.getUuid()));
    }

    private void assertSize(int size) {
        assertEquals(size, storage.size());
    }
}