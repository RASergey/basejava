package com.urise.webapp.model.section;

import java.net.URL;
import java.time.LocalDate;
import java.util.Objects;

public class Organization {
    private final String nameOrganization;
    private final LocalDate workedDate;
    private final LocalDate endWorkedDate;
    private final String position;
    private final String duty;
    private final String urlOrganization;

    public Organization(String nameOrganization, LocalDate workedDate, LocalDate endWorkedDate, String position, String duty, URL urlOrganization) {
        Objects.requireNonNull(nameOrganization, "nameOrganization must not be null");
        Objects.requireNonNull(workedDate, "workedDate must not be null");
        Objects.requireNonNull(endWorkedDate, "endWorkedDate must not be null");
        Objects.requireNonNull(position, "position must not be null");
        this.nameOrganization = nameOrganization;
        this.workedDate = workedDate;
        this.endWorkedDate = endWorkedDate;
        this.position = position;
        this.duty = duty;
        this.urlOrganization = "" + urlOrganization;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Organization that = (Organization) o;

        if (!nameOrganization.equals(that.nameOrganization)) return false;
        if (!workedDate.equals(that.workedDate)) return false;
        if (!endWorkedDate.equals(that.endWorkedDate)) return false;
        if (!position.equals(that.position)) return false;
        if (duty != null ? !duty.equals(that.duty) : that.duty != null) return false;
        return urlOrganization != null ? urlOrganization.equals(that.urlOrganization) : that.urlOrganization == null;
    }

    @Override
    public int hashCode() {
        int result = nameOrganization.hashCode();
        result = 31 * result + workedDate.hashCode();
        result = 31 * result + endWorkedDate.hashCode();
        result = 31 * result + position.hashCode();
        result = 31 * result + (duty != null ? duty.hashCode() : 0);
        result = 31 * result + (urlOrganization != null ? urlOrganization.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "\n" + nameOrganization +
                "\n" + workedDate.getMonthValue() + "/" + workedDate.getYear() + " - " + endWorkedDate.getMonthValue() + "/" + endWorkedDate.getYear() +
                "\n" + position +
                "\n" + duty +
                "\n" + urlOrganization + "";
    }
}
