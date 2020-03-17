package com.urise.webapp.model.section;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Education extends Section {
    private List<EducationSection> education = new ArrayList<>();

    public void setExperience(EducationSection text) {
        education.add(text);
        education.sort(Comparator.comparing(EducationSection::getEndTrainedDate));
        Collections.reverse(education);
    }

    @Override
    public String toString() {
        return "" + education;
    }
}
