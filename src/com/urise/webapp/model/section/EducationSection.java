package com.urise.webapp.model.section;

import java.util.ArrayList;
import java.util.List;

public class EducationSection extends Section {
    private List<Organization> education = new ArrayList<>();

    public void setExperience(Organization text) {
        education.add(text);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EducationSection that = (EducationSection) o;
        return education.equals(that.education);
    }

    @Override
    public int hashCode() {
        return education.hashCode();
    }

    @Override
    public String toString() {
        return "" + education;
    }
}
