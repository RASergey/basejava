package com.urise.webapp.model.section;

import java.util.List;
import java.util.Objects;

public class ListSection extends Section {
    private final List<String> items;

    public ListSection(List<String> items) {
        Objects.requireNonNull(items, "items must not be null");
        this.items = items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListSection that = (ListSection) o;

        return items.equals(that.items);
    }

    @Override
    public int hashCode() {
        return items.hashCode();
    }

    @Override
    public String toString() {
        return "\n" + items;
    }
}
