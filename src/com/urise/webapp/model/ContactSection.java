package com.urise.webapp.model;

public enum ContactSection {
    FULL_NAME("Фамилия Имя "),
    EMAIL_ADDRESS("Эл.почта "),
    PHONE_NUMBER("Моб.тел. "),
    SKYPE("Skype ");

    private String title;

    ContactSection(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
