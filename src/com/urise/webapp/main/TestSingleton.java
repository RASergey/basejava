package com.urise.webapp.main;

import com.urise.webapp.model.ContactType;
import com.urise.webapp.model.SectionType;

import java.util.Arrays;

public class TestSingleton {

    public static void main(String[] args) {
        for (SectionType type: SectionType.values()) {
            System.out.println(type.getTitle());
        }

//        Arrays.asList(ContactType.values()).forEach(it -> System.out.println(it.getTitle() + ": " + resume.getContacts(it)));
//        Arrays.asList(SectionType.values()).forEach(it -> System.out.println(it.getTitle() + ": " + resume.getSection(it)));
        Arrays.asList(ContactType.values()).forEach(it -> System.out.println(it.getTitle()));
        Arrays.asList(ContactType.values()).forEach(System.out::println);
    }
}
