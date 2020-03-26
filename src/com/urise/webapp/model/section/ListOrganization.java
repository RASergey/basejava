package com.urise.webapp.model.section;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ListOrganization extends Organization {
    private List<Object> listOrganization = new ArrayList<>();

    public ListOrganization(String nameOrganization, LocalDate startDate, LocalDate endDate, String title, String description, String urlOrganization) {
        super(nameOrganization, startDate, endDate, title, description, urlOrganization);
        listOrganization.add(getHomePage());
        listOrganization.add(getStartDate());
        listOrganization.add(getEndDate());
        listOrganization.add(getTitle());
        listOrganization.add(getDescription());
        listOrganization.removeIf(Objects::isNull);
    }

    public List<Object> getListOrganization() {
        return listOrganization;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        ListOrganization that = (ListOrganization) o;

        return listOrganization.equals(that.listOrganization);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + listOrganization.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "\n" + listOrganization;
    }
}
