package com.urise.webapp.model.section;

public class ContentList extends Section {
    private StringBuilder contentList = new StringBuilder();

    public void setContentList(String text) {
        contentList.append("\n* ").append(text);
    }

    @Override
    public String toString() {
        return "" + contentList;
    }
}
