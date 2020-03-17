package com.urise.webapp.model.section;

import java.util.ArrayList;
import java.util.List;

public class ExperienceSection extends Section {
    protected List<Organization> organization = new ArrayList<>();

    public void setOrganization(Organization text) {
        organization.add(text);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExperienceSection that = (ExperienceSection) o;
        return organization.equals(that.organization);
    }

    @Override
    public int hashCode() {
        return organization.hashCode();
    }

    @Override
    public String toString() {
        return "" + organization;
    }
}
