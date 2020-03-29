package com.urise.webapp.model.section;

import java.util.List;
import java.util.Objects;

public class Organization {
    private final Link link;
    private final List<Period> periods;

    public Organization(String name, String url, List<Period> periods) {
        Objects.requireNonNull(periods, "listItems must not be null");
        this.link = new Link(name, url);
        this.periods = periods;
    }

    public Link getLink() {
        return link;
    }

    public List<Period> getPeriods() {
        return periods;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Organization that = (Organization) o;

        if (!link.equals(that.link)) return false;
        return periods.equals(that.periods);
    }

    @Override
    public int hashCode() {
        int result = link.hashCode();
        result = 31 * result + periods.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "\n" + link + "" + periods;
    }
}
