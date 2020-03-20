package com.urise.webapp.model.section;

import java.util.ArrayList;
import java.util.List;

public class OrganizationSection extends Section {
    private final List<Organization> organizations = new ArrayList<>();

    public void setOrganizations(Organization content) {
        organizations.add(content);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrganizationSection that = (OrganizationSection) o;
        return organizations.equals(that.organizations);
    }

    @Override
    public int hashCode() {
        return organizations.hashCode();
    }

    @Override
    public String toString() {
        return "" + organizations;
    }
}
