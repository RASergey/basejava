package com.urise.webapp.model;

public enum ContactType {
    FULL_NAME("Фамилия Имя"),
    EMAIL_ADDRESS("Эл.почта"),
    PHONE_NUMBER("Моб.тел"),
    SKYPE("Skype");

    private String title;

    ContactType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
