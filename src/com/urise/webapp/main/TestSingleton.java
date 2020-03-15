package com.urise.webapp.main;

import com.urise.webapp.model.ContactSection;
import com.urise.webapp.model.SectionType;

import java.util.Arrays;

public class TestSingleton {

    public static void main(String[] args) {
        for (SectionType type: SectionType.values()) {
            System.out.println(type.getTitle());
        }

        Arrays.asList(ContactSection.values()).forEach(it -> System.out.println(it.getTitle()));
        Arrays.asList(ContactSection.values()).forEach(System.out::println);
    }
}
