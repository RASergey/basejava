package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public abstract class AbstractStorageTest {
    protected Storage storage;
    protected static final String UUID_1 = "uuid1";
    protected static final String UUID_2 = "uuid2";
    protected static final String UUID_3 = "uuid3";
    protected static final String DUMMY = "dummy";
    protected static final Resume RESUME_1 = new Resume(UUID_1);
    protected static final Resume RESUME_2 = new Resume(UUID_2);
    protected static final Resume RESUME_3 = new Resume(UUID_3);
    protected static final Resume RESUME_4 = new Resume(UUID_3);
    protected static final Resume RESUME_DUMMY = new Resume(DUMMY);

    public AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    @BeforeEach
    void setUp() {
        storage.clear();
        storage.save(RESUME_1);
        storage.save(RESUME_2);
        storage.save(RESUME_3);
    }

    @Nested
    class DefaultOperationsMethodsTest {
        @Test
        void size() {
            assertEquals(3, storage.size());
        }

        @Test
        void clear() {
            storage.clear();
            assertEquals(0, storage.size());
        }

        @Test
        void update() {
            storage.update(RESUME_4);
            assertSame(storage.get(UUID_3), RESUME_4);
        }

        @Test
        void getAll() {
            Resume[] resumes = new Resume[]{RESUME_1, RESUME_2, RESUME_3};
            assertArrayEquals(resumes, storage.getAll());
            assertEquals(storage.size(), resumes.length);
        }

        @Test
        void save() {
            storage.save(RESUME_DUMMY);
            assertEquals(4, storage.size());
            storage.get(DUMMY);
        }

        @Test
        void delete() {
            storage.delete(UUID_3);
            assertEquals(2, storage.size());
            assertThrows(NotExistStorageException.class, () -> storage.get(UUID_3));
        }

        @Test
        void get() {
            assertEquals(RESUME_3, storage.get(UUID_3));
        }
    }

    @Nested
    class NotExistTest {

        @Test
        void updateNotExist() {
            doNotExist(() -> storage.update(RESUME_DUMMY));
        }

        @Test
        public void deleteNotExist() {
            doNotExist(() -> storage.delete(DUMMY));
        }

        @Test
        public void getNotExist() {
            doNotExist(() -> storage.get(DUMMY));
        }

        private void doNotExist(Executable executable) {
            NotExistStorageException exception = assertThrows(NotExistStorageException.class, executable);
            assertEquals(exception.getMessage(), "Resume dummy not exist");
        }
    }

    @Nested
    class saveExceptionTest {
        @Test
        public void saveExist() {
            assertThrows(ExistStorageException.class, () -> storage.save(new Resume(UUID_2)));
        }
    }
}