package com.urise.webapp.model.section;

public class ContentText extends Section {
    private String personal;
    private String objective;

    public Object getPersonal() {
        return personal;
    }

    public void setPersonal(Object personal) {
        this.personal = (String) personal;
    }

    public Object getObjective() {
        return objective;
    }

    public void setObjective(Object objective) {
        this.objective = (String) objective;
    }

    @Override
    public String toString() {
        return "Personal: " + personal +
                "\nObjective='" + objective;
    }
}
