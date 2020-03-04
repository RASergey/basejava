package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MapResumeStorageTest extends AbstractStorageTest {

    public MapResumeStorageTest() {
        super(new MapResumeStorage());
    }

    @Test
    public void getAll() {
        List<Resume> list = Arrays.asList(RESUME_1, RESUME_2, RESUME_3);
        list.sort(Comparator.comparing(Resume::getFullName));
        assertEquals(list, storage.getAllSorted());
        assertEquals(storage.size(), list.size());
    }
}