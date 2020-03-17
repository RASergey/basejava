package com.urise.webapp.model.section;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Experience extends Section {
    protected List<ExperienceSection> experience = new ArrayList<>();

    public void setExperience(ExperienceSection text) {
        experience.add(text);
        experience.sort(Comparator.comparing(ExperienceSection::getEndWorkedDate));
        Collections.reverse(experience);
    }

    @Override
    public String toString() {
        return "" + experience;
    }
}
