package com.urise.webapp.model.section;

import java.net.URL;
import java.time.LocalDate;

public class ExperienceSection {
    private String nameOrganization;
    private LocalDate workedDate;
    private LocalDate endWorkedDate;
    private String position;
    private String duty;
    private URL urlOrganization;

    public ExperienceSection(String nameOrganization, LocalDate workedDate, LocalDate endWorkedDate, String position, String duty, URL urlOrganization) {
        this.nameOrganization = nameOrganization;
        this.workedDate = workedDate;
        this.endWorkedDate = endWorkedDate;
        this.position = position;
        this.duty = duty;
        this.urlOrganization = urlOrganization;
    }

    public LocalDate getEndWorkedDate() {
        return endWorkedDate;
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
