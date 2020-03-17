package com.urise.webapp.model.section;

import java.net.URL;
import java.time.LocalDate;
import java.util.Objects;

public class Organization {
    private String nameOrganization;
    private LocalDate workedDate;
    private LocalDate endWorkedDate;
    private String position;
    private String duty;
    private URL urlOrganization;

    public Organization(String nameOrganization, LocalDate workedDate, LocalDate endWorkedDate, String position, String duty, URL urlOrganization) {
        Objects.requireNonNull(nameOrganization, "nameOrganization must be null");
        Objects.requireNonNull(workedDate, "workedDate must be null");
        Objects.requireNonNull(endWorkedDate, "endWorkedDate must be null");
        Objects.requireNonNull(position, "position must be null");
        this.nameOrganization = nameOrganization;
        this.workedDate = workedDate;
        this.endWorkedDate = endWorkedDate;
        this.position = position;
        this.duty = duty;
        this.urlOrganization = urlOrganization;
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
        if (!duty.equals(that.duty)) return false;
        return urlOrganization.equals(that.urlOrganization);
    }

    @Override
    public int hashCode() {
        int result = nameOrganization.hashCode();
        result = 31 * result + workedDate.hashCode();
        result = 31 * result + endWorkedDate.hashCode();
        result = 31 * result + position.hashCode();
        result = 31 * result + duty.hashCode();
        result = 31 * result + urlOrganization.hashCode();
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
