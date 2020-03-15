package com.urise.webapp.main;

import com.urise.webapp.model.ContactSection;
import com.urise.webapp.model.Resume;
import com.urise.webapp.model.SectionType;
import com.urise.webapp.model.section.Achievement;
import com.urise.webapp.model.section.ContentText;
import com.urise.webapp.model.section.Qualification;

import java.util.Arrays;

public class ResumeTestData {

    public static void main(String[] args) {
        Resume resume = new Resume("Григорий Кислин");
        resume.setContacts(ContactSection.FULL_NAME, resume.getFullName());
        resume.setContacts(ContactSection.EMAIL_ADDRESS, "gkislin@yandex.ru");
        resume.setContacts(ContactSection.PHONE_NUMBER, "+7(921) 855-0482");
        resume.setContacts(ContactSection.SKYPE, "grigory.kislin");
        Arrays.asList(ContactSection.values()).forEach(it -> System.out.println(it.getTitle() + ": " + resume.getContacts(it)));

        resume.setSection(SectionType.PERSONAL, new ContentText("Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры."));
        resume.setSection(SectionType.OBJECTIVE, new ContentText("Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям"));

        String achievement1 = "С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\"," + " \"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\"." + " Организация онлайн стажировок и ведение проектов. Более 1000 выпускников.";
        String achievement2 = "Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk.";
        String achievement3 = "Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM. Интеграция с 1С, Bonita BPM, CMIS, LDAP. Разработка приложения управления окружением на стеке: Scala/Play/Anorm/JQuery. Разработка SSO аутентификации и авторизации различных ERP модулей, интеграция CIFS/SMB java сервера.";
        String achievement4 = "Реализация c нуля Rich Internet Application приложения на стеке технологий JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Commet, HTML5, Highstock для алгоритмического трейдинга.";
        String achievement5 = "Создание JavaEE фреймворка для отказоустойчивого взаимодействия слабо-связанных сервисов (SOA-base архитектура, JAX-WS, JMS, AS Glassfish). Сбор статистики сервисов и информации о состоянии через систему мониторинга Nagios. Реализация онлайн клиента для администрирования и мониторинга системы по JMX (Jython/ Django).";
        String achievement6 = "Реализация протоколов по приему платежей всех основных платежных системы России (Cyberplat, Eport, Chronopay, Сбербанк), Белоруcсии(Erip, Osmp) и Никарагуа.";
        Achievement achievement = new Achievement();
        String[] achievements = {achievement1, achievement2, achievement3, achievement4, achievement5, achievement6};
        for (String text : achievements) {
            achievement.setAchievement(text);
            resume.setSection(SectionType.ACHIEVEMENT, achievement);
        }

        String qualification1 = "JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2";
        String qualification2 = "Version control: Subversion, Git, Mercury, ClearCase, Perforce";
        String qualification3 = "DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle,";
        String qualification4 = "MySQL, SQLite, MS SQL, HSQLDB";
        String qualification5 = "Languages: Java, Scala, Python/Jython/PL-Python, JavaScript, Groovy,";
        String qualification6 = "XML/XSD/XSLT, SQL, C/C++, Unix shell scripts,";
        String qualification7 = "Java Frameworks: Java 8 (Time API, Streams), Guava, Java Executor, MyBatis, Spring (MVC, Security, Data, Clouds, Boot), JPA (Hibernate, EclipseLink), Guice, GWT(SmartGWT, ExtGWT/GXT), Vaadin, Jasperreports, Apache Commons, Eclipse SWT, JUnit, Selenium (htmlelements).";
        String qualification8 = "Python: Django.";
        String qualification9 = "JavaScript: jQuery, ExtJS, Bootstrap.js, underscore.js";
        String qualification10 = "Scala: SBT, Play2, Specs2, Anorm, Spray, Akka";
        String qualification11 = "Технологии: Servlet, JSP/JSTL, JAX-WS, REST, EJB, RMI, JMS, JavaMail, JAXB, StAX, SAX, DOM, XSLT, MDB, JMX, JDBC, JPA, JNDI, JAAS, SOAP, AJAX, Commet, HTML5, ESB, CMIS, BPMN2, LDAP, OAuth1, OAuth2, JWT.";
        String qualification12 = "Инструменты: Maven + plugin development, Gradle, настройка Ngnix,";
        String qualification13 = "администрирование Hudson/Jenkins, Ant + custom task, SoapUI, JPublisher, Flyway, Nagios, iReport, OpenCmis, Bonita, pgBouncer.";
        String qualification14 = "Отличное знание и опыт применения концепций ООП, SOA, шаблонов проектрирования, архитектурных шаблонов, UML, функционального программирования";
        String qualification15 = "Родной русский, английский \"upper intermediate\"";
        Qualification qualification = new Qualification();
        String[] qualifications = {qualification1, qualification2, qualification3, qualification4, qualification5, qualification6, qualification7, qualification8, qualification9, qualification10, qualification11, qualification12, qualification13, qualification14, qualification15};
        for (String text : qualifications) {
            qualification.setQualification(text);
            resume.setSection(SectionType.QUALIFICATIONS, qualification);
        }
        Arrays.asList(SectionType.values()).forEach(it -> System.out.println(it.getTitle() + ": " + resume.getSection(it)));
    }
}