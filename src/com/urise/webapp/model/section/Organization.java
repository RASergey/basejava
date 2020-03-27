package com.urise.webapp.model.section;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Organization {
    private Link homePage;
    private Periods period;
    private List<Object> listItems = new ArrayList<>();

    public Organization(String nameOrganization, LocalDate startDate, LocalDate endDate, String title, String description, String urlOrganization) {
        homePage = new Link(nameOrganization, urlOrganization);
        period = new Periods(startDate, endDate, title, description);
        listItems.add(homePage);
        listItems.add(period);
    }

    public Link getHomePage() {
        return homePage;
    }

    public Periods getPeriod() {
        return period;
    }

    public List<Object> getListItems() {
        return listItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Organization that = (Organization) o;

        if (!homePage.equals(that.homePage)) return false;
        if (!period.equals(that.period)) return false;
        return listItems.equals(that.listItems);
    }

    @Override
    public int hashCode() {
        int result = homePage.hashCode();
        result = 31 * result + period.hashCode();
        result = 31 * result + listItems.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "\n\n" + listItems;
    }
}
