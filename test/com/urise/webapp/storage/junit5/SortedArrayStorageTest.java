package com.urise.webapp.storage.junit5;

import com.urise.webapp.storage.SortedArrayStorage;

class SortedArrayStorageTest extends AbstractArrayStorageTest {

    public SortedArrayStorageTest() {
        super(new SortedArrayStorage());
    }
}