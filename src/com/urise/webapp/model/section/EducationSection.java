package com.urise.webapp.model.section;

import java.net.URL;
import java.time.LocalDate;

public class EducationSection {
    private String nameOrganization;
    private LocalDate trainedDate;
    private LocalDate endTrainedDate;
    private String academicDirection;
    private URL urlOrganization;

    public EducationSection(String nameOrganization, LocalDate trainedDate, LocalDate endTrainedDate, String academicDirection, URL urlOrganization) {
        this.nameOrganization = nameOrganization;
        this.trainedDate = trainedDate;
        this.endTrainedDate = endTrainedDate;
        this.academicDirection = academicDirection;
        this.urlOrganization = urlOrganization;
    }

    public LocalDate getEndTrainedDate() {
        return endTrainedDate;
    }

    @Override
    public String toString() {
        return "\n" + nameOrganization +
                "\n" + trainedDate.getMonthValue() + "/" + trainedDate.getYear() + " - " + endTrainedDate.getMonthValue() + "/" + endTrainedDate.getYear() +
                "\n" + academicDirection +
                "\n" + urlOrganization + "";
    }
}
