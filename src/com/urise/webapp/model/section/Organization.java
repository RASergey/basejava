package com.urise.webapp.model.section;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Organization {
    private List<Object> listItems = new ArrayList<>();

    public Organization(Object object) {
        Objects.requireNonNull(listItems, "listItems must not be null");
        listItems.add(object);
    }

    public List<Object> getListItems() {
        return listItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Organization that = (Organization) o;

        return listItems.equals(that.listItems);
    }

    @Override
    public int hashCode() {
        return listItems.hashCode();
    }

    @Override
    public String toString() {
        return "\n" + listItems + "\n";
    }
}
