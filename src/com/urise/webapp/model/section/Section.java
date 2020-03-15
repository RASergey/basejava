package com.urise.webapp.model.section;

import com.urise.webapp.model.SectionType;

public class Section {

    public void setSections(SectionType type, Object text) {
        ContentText contentText = new ContentText();
        switch (type) {
            case PERSONAL:
                contentText.setPersonal(text);
                break;
            case OBJECTIVE:
                contentText.setObjective(text);
                break;
            case ACHIEVEMENT:
                break;
            case QUALIFICATIONS:
                break;
            case EXPERIENCE:
                break;
            case EDUCATION:
                break;
        }
    }
}

