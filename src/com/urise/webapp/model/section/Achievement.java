package com.urise.webapp.model.section;

public class Achievement extends Section {
    private StringBuilder achievement = new StringBuilder();

    public void setAchievement(String text) {
        achievement.append("\n* ").append(text);
    }

    @Override
    public String toString() {
        return "" + achievement;
    }
}
