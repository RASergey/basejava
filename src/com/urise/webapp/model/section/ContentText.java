package com.urise.webapp.model.section;

public class ContentText extends Section {
    private String text;

    public ContentText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "\n" + text;
    }
}
