package com.urise.webapp.model.section;

import java.util.List;
import java.util.Objects;

public class ContentListSection extends Section {
    private List<String> contentList;

    public ContentListSection(List<String> contentList) {
        Objects.requireNonNull(contentList, "List must be null");
        this.contentList = contentList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContentListSection that = (ContentListSection) o;
        return contentList.equals(that.contentList);
    }

    @Override
    public int hashCode() {
        return contentList.hashCode();
    }

    @Override
    public String toString() {
        return "" + contentList;
    }
}
