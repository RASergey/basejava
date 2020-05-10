package com.urise.webapp.model;

public enum ContactType {
    EMAIL_ADDRESS("Эл.почта"),
    PHONE_NUMBER("Мобильный тел."),
    HOME_PHONE("Домашний тел."),
    PHONE("Рабочий тел."),
    SKYPE("Skype"),
    LINKEDIN("Профиль LinkedIn"),
    GITHUB("Профиль GitHub"),
    STATCKOVERFLOW("Профиль Stackoverflow"),
    HOME_PAGE("Домашняя страница");

    private final String title;

    ContactType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
