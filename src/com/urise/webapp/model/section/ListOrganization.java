package com.urise.webapp.model.section;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ListOrganization extends Organization {
    private final List<Object> organizationParagraphs = new ArrayList<>();

    public ListOrganization(LocalDate startDate, LocalDate endDate, String position, String duty) {
        super(startDate, endDate, position, duty);
        organizationParagraphs.add(getStartDate());
        organizationParagraphs.add(getEndDate());
        organizationParagraphs.add(getTitle());
        organizationParagraphs.add(getDescription());
        organizationParagraphs.removeIf(Objects::isNull);
    }

    public ListOrganization(String nameOrganization, LocalDate startDate, LocalDate endDate, String position, String duty, String urlOrganization) {
        super(nameOrganization, startDate, endDate, position, duty, urlOrganization);
        organizationParagraphs.add(getHomePage());
        organizationParagraphs.add(getStartDate());
        organizationParagraphs.add(getEndDate());
        organizationParagraphs.add(getTitle());
        organizationParagraphs.add(getDescription());
        organizationParagraphs.removeIf(Objects::isNull);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        ListOrganization that = (ListOrganization) o;

        return organizationParagraphs.equals(that.organizationParagraphs);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + organizationParagraphs.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "\n" + organizationParagraphs;
    }
}
