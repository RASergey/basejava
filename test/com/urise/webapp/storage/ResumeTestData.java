package com.urise.webapp.storage;

import com.urise.webapp.model.ContactType;
import com.urise.webapp.model.Resume;
import com.urise.webapp.model.SectionType;
import com.urise.webapp.model.section.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ResumeTestData {

    public static void main(String[] args) {
        Resume resume = new Resume("Григорий Кислин");
        resume.setContacts(ContactType.FULL_NAME, resume.getFullName());
        resume.setContacts(ContactType.EMAIL_ADDRESS, "gkislin@yandex.ru");
        resume.setContacts(ContactType.PHONE_NUMBER, "+7(921) 855-0482");
        resume.setContacts(ContactType.SKYPE, "grigory.kislin");
        Arrays.asList(ContactType.values()).forEach(it -> System.out.println(it.getTitle() + ": " + resume.getContacts(it)));

        resume.setSection(SectionType.PERSONAL, new TextSection("Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры."));
        resume.setSection(SectionType.OBJECTIVE, new TextSection("Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям"));

        List<String> listSectionAchievement = new ArrayList<>();
        listSectionAchievement.add("С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\"," + " \"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\"." + " Организация онлайн стажировок и ведение проектов. Более 1000 выпускников.");
        listSectionAchievement.add("Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk.");
        listSectionAchievement.add("Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM. Интеграция с 1С, Bonita BPM, CMIS, LDAP. Разработка приложения управления окружением на стеке: Scala/Play/Anorm/JQuery. Разработка SSO аутентификации и авторизации различных ERP модулей, интеграция CIFS/SMB java сервера.");
        listSectionAchievement.add("Реализация c нуля Rich Internet Application приложения на стеке технологий JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Commet, HTML5, Highstock для алгоритмического трейдинга.");
        listSectionAchievement.add("Создание JavaEE фреймворка для отказоустойчивого взаимодействия слабо-связанных сервисов (SOA-base архитектура, JAX-WS, JMS, AS Glassfish). Сбор статистики сервисов и информации о состоянии через систему мониторинга Nagios. Реализация онлайн клиента для администрирования и мониторинга системы по JMX (Jython/ Django).");
        listSectionAchievement.add("Реализация протоколов по приему платежей всех основных платежных системы России (Cyberplat, Eport, Chronopay, Сбербанк), Белоруcсии(Erip, Osmp) и Никарагуа.");
        resume.setSection(SectionType.ACHIEVEMENT, new ListSection(listSectionAchievement));

        List<String> listSectionQualification = new ArrayList<>();
        listSectionQualification.add("JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2");
        listSectionQualification.add("Version control: Subversion, Git, Mercury, ClearCase, Perforce");
        listSectionQualification.add("DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle,");
        listSectionQualification.add("MySQL, SQLite, MS SQL, HSQLDB");
        listSectionQualification.add("Languages: Java, Scala, Python)/Jython/PL-Python, JavaScript, Groovy,");
        listSectionQualification.add("XML/XSD/XSLT, SQL, C/C++, Unix shell scripts,");
        listSectionQualification.add("Java Frameworks: Java 8 (Time API, Streams), Guava, Java Executor, MyBatis, Spring (MVC, Security, Data, Clouds, Boot), JPA (Hibernate, EclipseLink), Guice, GWT(SmartGWT, ExtGWT)/GXT), Vaadin, Jasperreports, Apache Commons, Eclipse SWT, JUnit, Selenium (htmlelements).");
        listSectionQualification.add("Python: Django.");
        listSectionQualification.add("JavaScript: jQuery, ExtJS, Bootstrap.js, underscore.js");
        listSectionQualification.add("Scala: SBT, Play2, Specs2, Anorm, Spray, Akka");
        listSectionQualification.add("Технологии: Servlet, JSP/JSTL, JAX-WS, REST, EJB, RMI, JMS, JavaMail, JAXB, StAX, SAX, DOM, XSLT, MDB, JMX, JDBC, JPA, JNDI, JAAS, SOAP, AJAX, Commet, HTML5, ESB, CMIS, BPMN2, LDAP, OAuth1, OAuth2, JWT.)");
        listSectionQualification.add("Инструменты: Maven + plugin development, Gradle, настройка Ngnix,");
        listSectionQualification.add("администрирование Hudson/Jenkins, Ant + custom task, SoapUI, JPublisher, Flyway, Nagios, iReport, OpenCmis, Bonita, pgBouncer.");
        listSectionQualification.add("Отличное знание и опыт применения концепций ООП, SOA, шаблонов проектрирования, архитектурных шаблонов, UML, функционального программирования");
        listSectionQualification.add("Родной русский, английский \"upper intermediate\"");
        resume.setSection(SectionType.QUALIFICATIONS, new ListSection(listSectionQualification));

        List<Organization> experience = new ArrayList<>();
        ListOrganization experience_1 = new ListOrganization("Alcatel",
                LocalDate.of(1997, 9, 1),
                LocalDate.of(2005, 1, 1),
                "Инженер по аппаратному и программному тестированию",
                "Тестирование, отладка, внедрение ПО цифровой телефонной станции Alcatel 1000 S12 (CHILL, ASM).",
                "http://www.alcatel.ru/");
        experience.add(experience_1);
        resume.setSection(SectionType.EXPERIENCE, new OrganizationSection(experience));
        ListOrganization experience_2 = new ListOrganization("Siemens AG",
                LocalDate.of(2005, 1, 1),
                LocalDate.of(2007, 2, 1),
                "Разработчик ПО",
                "Разработка информационной модели, проектирование интерфейсов, реализация и отладка ПО на мобильной IN платформе Siemens @vantage (Java, Unix).",
                "https://www.siemens.com/ru/ru/home.html");
        experience.add(experience_2);
        resume.setSection(SectionType.EXPERIENCE, new OrganizationSection(experience));
        ListOrganization experience_3 = new ListOrganization("Enkata",
                LocalDate.of(2007, 3, 1),
                LocalDate.of(2008, 6, 1),
                "Разработчик ПО",
                "Реализация клиентской (Eclipse RCP) и серверной (JBoss 4.2, Hibernate 3.0, Tomcat, JMS) частей кластерного J2EE приложения (OLAP, Data mining).",
                "http://enkata.com/");
        experience.add(experience_3);
        resume.setSection(SectionType.EXPERIENCE, new OrganizationSection(experience));
        ListOrganization experience_4 = new ListOrganization("Yota",
                LocalDate.of(2008, 6, 1),
                LocalDate.of(2010, 12, 1),
                "Ведущий специалист",
                "Дизайн и имплементация Java EE фреймворка для отдела \"Платежные Системы\" (GlassFish v2.1, v3, OC4J, EJB3, JAX-WS RI 2.1, Servlet 2.4, JSP, JMX, JMS, Maven2). Реализация администрирования, статистики и мониторинга фреймворка. Разработка online JMX клиента (Python/ Jython, Django, ExtJS)",
                "https://www.yota.ru/");
        experience.add(experience_4);
        resume.setSection(SectionType.EXPERIENCE, new OrganizationSection(experience));
        ListOrganization experience_5 = new ListOrganization("Luxoft (Deutsche Bank)",
                LocalDate.of(2010, 12, 1),
                LocalDate.of(2012, 4, 1),
                "Ведущий программист",
                "Участие в проекте Deutsche Bank CRM (WebLogic, Hibernate, Spring, Spring MVC, SmartGWT, GWT, Jasper, Oracle). Реализация клиентской и серверной части CRM. Реализация RIA-приложения для администрирования, мониторинга и анализа результатов в области алгоритмического трейдинга. JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Highstock, Commet, HTML5.",
                "http://www.luxoft.ru/");
        experience.add(experience_5);
        resume.setSection(SectionType.EXPERIENCE, new OrganizationSection(experience));
        ListOrganization experience_6 = new ListOrganization("RIT Center",
                LocalDate.of(2012, 4, 1),
                LocalDate.of(2014, 10, 1),
                "Java архитектор",
                "Организация процесса разработки системы ERP для разных окружений: релизная политика, версионирование, ведение CI (Jenkins), миграция базы (кастомизация Flyway), конфигурирование системы (pgBoucer, Nginx), AAA via SSO. Архитектура БД и серверной части системы. Разработка интергационных сервисов: CMIS, BPMN2, 1C (WebServices), сервисов общего назначения (почта, экспорт в pdf, doc, html). Интеграция Alfresco JLAN для online редактирование из браузера документов MS Office. Maven + plugin development, Ant, Apache Commons, Spring security, Spring MVC, Tomcat,WSO2, xcmis, OpenCmis, Bonita, Python scripting, Unix shell remote scripting via ssh tunnels, PL/Python",
                null);
        experience.add(experience_6);
        resume.setSection(SectionType.EXPERIENCE, new OrganizationSection(experience));
        ListOrganization experience_7 = new ListOrganization("Wrike",
                LocalDate.of(2014, 10, 1),
                LocalDate.of(20016, 1, 1),
                "Старший разработчик (backend)",
                "Проектирование и разработка онлайн платформы управления проектами Wrike (Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO.",
                "https://www.wrike.com/");
        experience.add(experience_7);
        resume.setSection(SectionType.EXPERIENCE, new OrganizationSection(experience));
        ListOrganization experience_8 = new ListOrganization("Java Online Projects",
                LocalDate.of(2013, 10, 1),
                LocalDate.now(),
                "Автор проекта.",
                "Создание, организация и проведение Java онлайн проектов и стажировок.",
                "http://javaops.ru/");
        experience.add(experience_8);
        resume.setSection(SectionType.EXPERIENCE, new OrganizationSection(experience));

        List<Organization> education = new ArrayList<>();
        ListOrganization education1 = new ListOrganization("Заочная физико-техническая школа при МФТИ",
                LocalDate.of(1984, 9, 1),
                LocalDate.of(1987, 6, 1),
                "Закончил с отличием.",
                null,
                "http://www.school.mipt.ru/");
        education.add(education1);
        resume.setSection(SectionType.EDUCATION, new OrganizationSection(education));
        ListOrganization education2 = new ListOrganization("Санкт-Петербургский национальный исследовательский университет информационных технологий, механики и оптики",
                LocalDate.of(1987, 9, 1),
                LocalDate.of(1993, 7, 1),
                "Аспирантура (программист С, С++)",
                null,
                "http://www.ifmo.ru/");
        education.add(education2);
        ListOrganization education2_1 = new ListOrganization(
                LocalDate.of(1993, 9, 1),
                LocalDate.of(1996, 7, 1),
                "Инженер (программист Fortran, C)",
                null);
        education.add(education2_1);
        resume.setSection(SectionType.EDUCATION, new OrganizationSection(education));
        ListOrganization education3 = new ListOrganization("Alcatel",
                LocalDate.of(1997, 9, 1),
                LocalDate.of(1998, 3, 1),
                "6 месяцев обучения цифровым телефонным сетям (Москва)",
                null,
                "http://www.alcatel.ru/");
        education.add(education3);
        resume.setSection(SectionType.EDUCATION, new OrganizationSection(education));
        ListOrganization education4 = new ListOrganization("Siemens AG",
                LocalDate.of(2005, 1, 1),
                LocalDate.of(2005, 4, 1),
                "3 месяца обучения мобильным IN сетям (Берлин)",
                null,
                "http://www.siemens.ru/");
        education.add(education4);
        resume.setSection(SectionType.EDUCATION, new OrganizationSection(education));
        ListOrganization education5 = new ListOrganization("Luxoft",
                LocalDate.of(2011, 3, 1),
                LocalDate.of(2011, 4, 1),
                "Курс \"Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML.\"",
                null,
                "http://www.luxoft-training.ru/training/catalog/course.html?ID=22366");
        education.add(education5);
        resume.setSection(SectionType.EDUCATION, new OrganizationSection(education));
        ListOrganization education6 = new ListOrganization("Coursera",
                LocalDate.of(2013, 3, 1),
                LocalDate.of(2013, 5, 1),
                "\"Functional Programming Principles in Scala\" by Martin Odersky",
                null,
                "https://www.coursera.org/course/progfun");
        education.add(education6);
        resume.setSection(SectionType.EDUCATION, new OrganizationSection(education));
        Arrays.asList(SectionType.values()).forEach(it -> System.out.println(it.getTitle() + ": " + resume.getSection(it)));
    }
}