package com.urise.webapp.model.section;

import java.time.LocalDate;
import java.util.Objects;

public class Organization {
    private Link homePage;
    private LocalDate startDate;
    private LocalDate endDate;
    private String position;
    private String duty;

    public Organization(LocalDate startDate, LocalDate endDate, String position, String duty) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.position = position;
        this.duty = duty;
    }

    public Organization(String nameOrganization, LocalDate startDate, LocalDate endDate, String position, String duty, String urlOrganization) {
        Objects.requireNonNull(startDate, "workedDate must not be null");
        Objects.requireNonNull(endDate, "endWorkedDate must not be null");
        Objects.requireNonNull(position, "position must not be null");
        this.homePage = new Link(nameOrganization, urlOrganization);
        this.startDate = startDate;
        this.endDate = endDate;
        this.position = position;
        this.duty = duty;
    }

    public Link getHomePage() {
        return homePage;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getPosition() {
        return position;
    }

    public String getDuty() {
        return duty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Organization that = (Organization) o;

        if (!homePage.equals(that.homePage)) return false;
        if (!startDate.equals(that.startDate)) return false;
        if (!endDate.equals(that.endDate)) return false;
        if (!position.equals(that.position)) return false;
        return duty != null ? Objects.equals(duty, that.duty) : that.duty == null;
    }

    @Override
    public int hashCode() {
        int result = homePage.hashCode();
        result = 31 * result + startDate.hashCode();
        result = 31 * result + endDate.hashCode();
        result = 31 * result + position.hashCode();
        result = 31 * result + (duty != null ? duty.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "\n" + homePage +
                "\n" + startDate.getMonthValue() + "/" + startDate.getYear() + " - " + endDate.getMonthValue() + "/" + endDate.getYear() +
                "\n" + position +
                "\n" + duty;
    }
}
