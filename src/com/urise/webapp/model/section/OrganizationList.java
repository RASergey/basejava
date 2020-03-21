package com.urise.webapp.model.section;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OrganizationList extends Organization {
    private final List<Object> organizations = new ArrayList<>();

    public OrganizationList(LocalDate startDate, LocalDate endDate, String position, String duty) {
        super(startDate, endDate, position, duty);
        organizations.add(getStartDate());
        organizations.add(getEndDate());
        organizations.add(getPosition());
        organizations.add(getDuty());
        organizations.removeIf(Objects::isNull);
    }

    public OrganizationList(String nameOrganization, LocalDate startDate, LocalDate endDate, String position, String duty, String urlOrganization) {
        super(nameOrganization, startDate, endDate, position, duty, urlOrganization);
        organizations.add(getHomePage());
        organizations.add(getStartDate());
        organizations.add(getEndDate());
        organizations.add(getPosition());
        organizations.add(getDuty());
        organizations.removeIf(Objects::isNull);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        OrganizationList that = (OrganizationList) o;

        return organizations.equals(that.organizations);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + organizations.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "\n" + organizations;
    }
}
