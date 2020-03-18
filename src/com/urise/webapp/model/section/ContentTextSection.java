package com.urise.webapp.model.section;

import java.util.Objects;

public class ContentTextSection extends Section {
    private final String text;

    public ContentTextSection(String text) {
        Objects.requireNonNull(text, "text must not be null");
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContentTextSection that = (ContentTextSection) o;
        return text.equals(that.text);
    }

    @Override
    public int hashCode() {
        return text.hashCode();
    }

    @Override
    public String toString() {
        return "\n" + text;
    }
}
