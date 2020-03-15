package com.urise.webapp.model.section;

public class Qualification extends Section {
    private StringBuilder qualification = new StringBuilder();

    public void setQualification(String text) {
        qualification.append("\n* ").append(text);
    }

    @Override
    public String toString() {
        return "" + qualification;
    }
}
