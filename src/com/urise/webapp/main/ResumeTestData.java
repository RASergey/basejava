package com.urise.webapp.main;

import com.urise.webapp.model.ContactSection;
import com.urise.webapp.model.Resume;
import com.urise.webapp.model.SectionType;

import java.util.Arrays;

public class ResumeTestData {

    public static void main(String[] args) {
        Resume resume = new Resume("Григорий Кислин");
//        Section section = new Section();
        resume.setContacts(ContactSection.valueOf("FULL_NAME"), resume.getFullName());
        resume.setContacts(ContactSection.valueOf("EMAIL_ADDRESS"), "gkislin@yandex.ru");
        resume.setContacts(ContactSection.valueOf("PHONE_NUMBER"), "+7(921) 855-0482");
        resume.setContacts(ContactSection.valueOf("SKYPE"), "grigory.kislin");
        Arrays.asList(ContactSection.values()).forEach(it -> System.out.println(it.getTitle()+ ": " + resume.getContacts(it)));
        resume.setSection(SectionType.valueOf("PERSONAL"),"Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры.");
//        resume.setSection(SectionType.valueOf("OBJECTIVE"),"Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям");
        Arrays.asList(SectionType.values()).forEach(it -> System.out.println(it.getTitle()+ ": " + resume.getSectionMap(it)));
    }
}