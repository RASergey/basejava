package com.urise.webapp.model.section;

import java.net.URL;
import java.time.LocalDate;

public class EducationSection extends Education {
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

    public String getNameOrganization() {
        return nameOrganization;
    }

    public void setNameOrganization(String nameOrganization) {
        this.nameOrganization = nameOrganization;
    }

    public LocalDate getTrainedDate() {
        return trainedDate;
    }

    public void setTrainedDate(LocalDate trainedDate) {
        this.trainedDate = trainedDate;
    }

    public LocalDate getEndTrainedDate() {
        return endTrainedDate;
    }

    public void setEndTrainedDate(LocalDate endTrainedDate) {
        this.endTrainedDate = endTrainedDate;
    }

    public String getAcademicDirection() {
        return academicDirection;
    }

    public void setAcademicDirection(String academicDirection) {
        this.academicDirection = academicDirection;
    }

    public URL getUrlOrganization() {
        return urlOrganization;
    }

    public void setUrlOrganization(URL urlOrganization) {
        this.urlOrganization = urlOrganization;
    }
}
