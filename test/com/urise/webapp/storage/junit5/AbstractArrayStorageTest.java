package com.urise.webapp.storage.junit5;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;
import com.urise.webapp.storage.Storage;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

abstract class AbstractArrayStorageTest {
    private Storage storage;
    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String DUMMY = "dummy";
    private static final Resume RESUME_1 = new Resume(UUID_1);
    private static final Resume RESUME_2 = new Resume(UUID_2);
    private static final Resume RESUME_3 = new Resume(UUID_3);
    private static final Resume RESUME_4 = new Resume(UUID_3);
    private static final Resume RESUME_DUMMY = new Resume(DUMMY);
    private static final int STORAGE_LIMIT = 10_000;

    public AbstractArrayStorageTest(Storage storage) {
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
            assertThrows(NotExistStorageException.class, () -> storage.update(RESUME_DUMMY));
        }

        @Test
        public void deleteNotExist() {
            assertThrows(NotExistStorageException.class, () -> storage.delete(DUMMY));
        }

        @Test
        public void getNotExist() {
            assertThrows(NotExistStorageException.class, () -> storage.get(DUMMY));
        }
    }

    @Nested
    class saveExceptionTest {
        @Test
        public void saveExist() {
            assertThrows(ExistStorageException.class, () -> storage.save(new Resume(UUID_2)));
        }

        @Test
        public void saveNull() {
            assertThrows(NullPointerException.class, () -> storage.save(new Resume(null)));
        }

        @Test
        public void saveOverflow() {
            storage.clear();
            for (int i = 0; i < STORAGE_LIMIT; i++) {
                storage.save(new Resume());
            }
            assertThrows(StorageException.class, () -> storage.save(new Resume()));
        }
    }
}