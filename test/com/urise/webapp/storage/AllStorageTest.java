package com.urise.webapp.storage;

import com.urise.webapp.storage.arraystorage.ArrayStorageTest;
import com.urise.webapp.storage.arraystorage.SortedArrayStorageTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ArrayStorageTest.class,
        SortedArrayStorageTest.class,
        ListStorageTest.class,
        MapUuidStorageTest.class,
        MapResumeStorageTest.class,
        ObjectFileStorageTest.class,
        ObjectPathStorageTest.class
})
public class AllStorageTest {
}
