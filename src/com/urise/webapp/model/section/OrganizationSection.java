package com.urise.webapp.model.section;

import java.util.ArrayList;
import java.util.List;

public class OrganizationSection extends Section {
    private final List<Organization> organization = new ArrayList<>();

    public void setOrganization(Organization content) {
        organization.add(content);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrganizationSection that = (OrganizationSection) o;
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
