package com.urise.webapp.storage;

import com.urise.webapp.strategies.ObjectStreamStrategy;

public class PathStorageTest extends AbstractStorageTest {
    public PathStorageTest() {
        super(new PathStorage(STORAGE_DIR, new ObjectStreamStrategy()));
    }
}
