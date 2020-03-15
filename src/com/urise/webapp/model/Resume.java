package com.urise.webapp.model;

import com.urise.webapp.model.section.Section;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

/**
 * Initial resume class
 */
public class Resume {
    private final String uuid;
    private final String fullName;
    private Map<ContactSection, String> contacts = new HashMap<>();
    protected Map<SectionType, Section> sectionMap = new HashMap<>();

    public Resume(String fullName) {
        this(UUID.randomUUID().toString(), fullName);
    }

    public Resume(String uuid, String fullName) {
        Objects.requireNonNull(uuid, "uuid must be null");
        Objects.requireNonNull(fullName, "fullName must be null");
        this.uuid = uuid;
        this.fullName = fullName;
    }

    public String getUuid() {
        return uuid;
    }

    public String getFullName() {
        return fullName;
    }

    public String getContacts(ContactSection type) {
        return contacts.get(type);
    }

    public void setContacts(ContactSection type, String contact) {
        contacts.put(type, contact);
    }

    public Object getSection(SectionType type) {
        return sectionMap.get(type);
    }

    public void setSection(SectionType type, Section text) {
        sectionMap.put(type, text);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Resume resume = (Resume) o;

        if (!uuid.equals(resume.uuid)) return false;
        return fullName.equals(resume.fullName);
    }

    @Override
    public int hashCode() {
        int result = uuid.hashCode();
        result = 31 * result + fullName.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "" + fullName;
    }
}
