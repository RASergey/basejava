package com.urise.webapp.main;

import com.urise.webapp.model.Resume;
import com.urise.webapp.storage.SortedArrayStorage;
import com.urise.webapp.storage.Storage;

/**
 * Test for your ArrayStorage implementation
 */
public class MainTestArrayStorage {
    private static final Storage ARRAY_STORAGE = new SortedArrayStorage();

    public static void main(String[] args) {
        final Resume r1 = new Resume("uuid1");
        final Resume r2 = new Resume("uuid2");
        final Resume r3 = new Resume("uuid7");
        final Resume r4 = new Resume("uuid4");
        final Resume r5 = new Resume("uuid5");
        final Resume r6 = new Resume("uuid9");
        final Resume r7 = new Resume("uuid3");
        final Resume r8 = new Resume("uuid6");
        final Resume r9 = new Resume("uuid8");

        ARRAY_STORAGE.templateSave(r1);
        ARRAY_STORAGE.templateSave(r2);
        ARRAY_STORAGE.templateSave(r3);
        ARRAY_STORAGE.templateSave(r4);
        ARRAY_STORAGE.templateSave(r5);
        ARRAY_STORAGE.templateSave(r6);
        ARRAY_STORAGE.templateSave(r7);
        ARRAY_STORAGE.templateSave(r8);
        ARRAY_STORAGE.templateSave(r9);

        System.out.println("Get r1: " + ARRAY_STORAGE.get(r1.getUuid()));
        System.out.println("Size: " + ARRAY_STORAGE.size());
        System.out.println("Get dummy: " + ARRAY_STORAGE.get("dummy"));
        printAll();
        ARRAY_STORAGE.templateDelete(r1.getUuid());
        printAll();
        ARRAY_STORAGE.templateDelete(r5.getUuid());
        printAll();
        ARRAY_STORAGE.update(r4);
        ARRAY_STORAGE.clear();
        printAll();
        System.out.println("Size: " + ARRAY_STORAGE.size());
    }

    static void printAll() {
        System.out.println("\nGet All");
        for (Resume r : ARRAY_STORAGE.getAll()) {
            System.out.println(r);
        }
    }
}
