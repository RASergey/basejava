package com.urise.webapp.storage;

import com.urise.webapp.model.ContactType;
import com.urise.webapp.model.Resume;
import com.urise.webapp.model.SectionType;
import com.urise.webapp.model.section.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ResumeTestData {
    public static final Resume RESUME_1 = new Resume("Григорий Кислин");
    public static final Resume RESUME_2 = new Resume("Горбунок Конёк");
    public static final Resume RESUME_3 = new Resume("Карлсон Чердачный");
    public static final Resume RESUME_4 = new Resume("Леопольд Кот");
    public static final Resume RESUME_5 = new Resume(RESUME_3.getUuid(), "Колобок Бегун");
    public static final Resume RESUME_DUMMY = new Resume("Розенбум Деревянный");

    static {
        RESUME_1.setContacts(ContactType.FULL_NAME, RESUME_1.getFullName());
        RESUME_1.setContacts(ContactType.EMAIL_ADDRESS, "gkislin@yandex.ru");
        RESUME_1.setContacts(ContactType.PHONE_NUMBER, "+7(921) 855-0482");
        RESUME_1.setContacts(ContactType.SKYPE, "grigory.kislin");
        RESUME_1.setSection(SectionType.PERSONAL, new TextSection("Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры."));
        RESUME_1.setSection(SectionType.OBJECTIVE, new TextSection("Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям"));

        List<String> listSectionAchievement = new ArrayList<>();
        listSectionAchievement.add("С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\"," + " \"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\"." + " Организация онлайн стажировок и ведение проектов. Более 1000 выпускников.");
        listSectionAchievement.add("Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk.");
        listSectionAchievement.add("Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM. Интеграция с 1С, Bonita BPM, CMIS, LDAP. Разработка приложения управления окружением на стеке: Scala/Play/Anorm/JQuery. Разработка SSO аутентификации и авторизации различных ERP модулей, интеграция CIFS/SMB java сервера.");
        listSectionAchievement.add("Реализация c нуля Rich Internet Application приложения на стеке технологий JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Commet, HTML5, Highstock для алгоритмического трейдинга.");
        listSectionAchievement.add("Создание JavaEE фреймворка для отказоустойчивого взаимодействия слабо-связанных сервисов (SOA-base архитектура, JAX-WS, JMS, AS Glassfish). Сбор статистики сервисов и информации о состоянии через систему мониторинга Nagios. Реализация онлайн клиента для администрирования и мониторинга системы по JMX (Jython/ Django).");
        listSectionAchievement.add("Реализация протоколов по приему платежей всех основных платежных системы России (Cyberplat, Eport, Chronopay, Сбербанк), Белоруcсии(Erip, Osmp) и Никарагуа.");
        RESUME_1.setSection(SectionType.ACHIEVEMENT, new ListSection(listSectionAchievement));

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
        RESUME_1.setSection(SectionType.QUALIFICATIONS, new ListSection(listSectionQualification));


        List<Organization> experience = new ArrayList<>();
        Organization experience_1 = new Organization(new Link("Alcatel", "http://www.alcatel.ru/"));
        experience_1.getListItems().add(new Period(
                LocalDate.of(1997, 9, 1),
                LocalDate.of(2005, 1, 1),
                "Инженер по аппаратному и программному тестированию",
                "Тестирование, отладка, внедрение ПО цифровой телефонной станции Alcatel 1000 S12 (CHILL, ASM)."));
        experience.add(experience_1);
        RESUME_1.setSection(SectionType.EXPERIENCE, new OrganizationSection(experience));
        Organization experience_2 = new Organization(new Link("Siemens AG", "https://www.siemens.com/ru/ru/home.html"));
        experience_2.getListItems().add(new Period(
                LocalDate.of(2005, 1, 1),
                LocalDate.of(2007, 2, 1),
                "Разработчик ПО",
                "Разработка информационной модели, проектирование интерфейсов, реализация и отладка ПО на мобильной IN платформе Siemens @vantage (Java, Unix)."));
        experience.add(experience_2);
        RESUME_1.setSection(SectionType.EXPERIENCE, new OrganizationSection(experience));
        Organization experience_3 = new Organization(new Link("Enkata", "http://enkata.com/"));
        experience_3.getListItems().add(new Period(
                LocalDate.of(2007, 3, 1),
                LocalDate.of(2008, 6, 1),
                "Разработчик ПО",
                "Реализация клиентской (Eclipse RCP) и серверной (JBoss 4.2, Hibernate 3.0, Tomcat, JMS) частей кластерного J2EE приложения (OLAP, Data mining)."));
        experience.add(experience_3);
        RESUME_1.setSection(SectionType.EXPERIENCE, new OrganizationSection(experience));
        Organization experience_4 = new Organization(new Link("Yota", "https://www.yota.ru/"));
        experience_4.getListItems().add(new Period(
                LocalDate.of(2008, 6, 1),
                LocalDate.of(2010, 12, 1),
                "Ведущий специалист",
                "Дизайн и имплементация Java EE фреймворка для отдела \"Платежные Системы\" (GlassFish v2.1, v3, OC4J, EJB3, JAX-WS RI 2.1, Servlet 2.4, JSP, JMX, JMS, Maven2). Реализация администрирования, статистики и мониторинга фреймворка. Разработка online JMX клиента (Python/ Jython, Django, ExtJS)"));
        experience.add(experience_4);
        RESUME_1.setSection(SectionType.EXPERIENCE, new OrganizationSection(experience));
        Organization experience_5 = new Organization(new Link("Luxoft (Deutsche Bank)", "http://www.luxoft.ru/"));
        experience_5.getListItems().add(new Period(
                LocalDate.of(2010, 12, 1),
                LocalDate.of(2012, 4, 1),
                "Ведущий программист",
                "Участие в проекте Deutsche Bank CRM (WebLogic, Hibernate, Spring, Spring MVC, SmartGWT, GWT, Jasper, Oracle). Реализация клиентской и серверной части CRM. Реализация RIA-приложения для администрирования, мониторинга и анализа результатов в области алгоритмического трейдинга. JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Highstock, Commet, HTML5."));
        experience.add(experience_5);
        RESUME_1.setSection(SectionType.EXPERIENCE, new OrganizationSection(experience));
        Organization experience_6 = new Organization(new Link("RIT Center", null));
        experience_6.getListItems().add(new Period(
                LocalDate.of(2012, 4, 1),
                LocalDate.of(2014, 10, 1),
                "Java архитектор",
                "Организация процесса разработки системы ERP для разных окружений: релизная политика, версионирование, ведение CI (Jenkins), миграция базы (кастомизация Flyway), конфигурирование системы (pgBoucer, Nginx), AAA via SSO. Архитектура БД и серверной части системы. Разработка интергационных сервисов: CMIS, BPMN2, 1C (WebServices), сервисов общего назначения (почта, экспорт в pdf, doc, html). Интеграция Alfresco JLAN для online редактирование из браузера документов MS Office. Maven + plugin development, Ant, Apache Commons, Spring security, Spring MVC, Tomcat,WSO2, xcmis, OpenCmis, Bonita, Python scripting, Unix shell remote scripting via ssh tunnels, PL/Python"));
        experience.add(experience_6);
        RESUME_1.setSection(SectionType.EXPERIENCE, new OrganizationSection(experience));
        Organization experience_7 = new Organization(new Link("Wrike", "https://www.wrike.com/"));
        experience_7.getListItems().add(new Period(
                LocalDate.of(2014, 10, 1),
                LocalDate.of(20016, 1, 1),
                "Старший разработчик (backend)",
                "Проектирование и разработка онлайн платформы управления проектами Wrike (Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO."));
        experience.add(experience_7);
        RESUME_1.setSection(SectionType.EXPERIENCE, new OrganizationSection(experience));
        Organization experience_8 = new Organization(new Link("Java Online Projects", "http://javaops.ru/"));
        experience_8.getListItems().add(new Period(
                LocalDate.of(2013, 10, 1),
                LocalDate.now(),
                "Автор проекта.",
                "Создание, организация и проведение Java онлайн проектов и стажировок."));
        RESUME_1.setSection(SectionType.EXPERIENCE, new OrganizationSection(experience));
        experience.add(experience_8);


        List<Organization> education = new ArrayList<>();

        Organization education_1 = new Organization(new Link("Заочная физико-техническая школа при МФТИ", "http://www.school.mipt.ru/"));
        education_1.getListItems().add(new Period(
                LocalDate.of(1984, 9, 1),
                LocalDate.of(1987, 6, 1),
                "Закончил с отличием.",
                null));
        education.add(education_1);
        RESUME_1.setSection(SectionType.EDUCATION, new OrganizationSection(education));
        Organization education_2 = new Organization(new Link("Санкт-Петербургский национальный исследовательский университет информационных технологий, механики и оптики"
                , "http://www.ifmo.ru/"));
        education_2.getListItems().add(new Period(
                LocalDate.of(1987, 9, 1),
                LocalDate.of(1993, 7, 1),
                "Аспирантура (программист С, С++)",
                null));
        education_2.getListItems().add(new Period(
                LocalDate.of(1993, 9, 1),
                LocalDate.of(1996, 7, 1),
                "Инженер (программист Fortran, C)",
                null));
        education.add(education_2);
        RESUME_1.setSection(SectionType.EDUCATION, new OrganizationSection(education));
        Organization education_3 = new Organization(new Link("Alcatel", "http://www.alcatel.ru/"));
        education_3.getListItems().add(new Period(
                LocalDate.of(1997, 9, 1),
                LocalDate.of(1998, 3, 1),
                "6 месяцев обучения цифровым телефонным сетям (Москва)",
                null));
        education.add(education_3);
        RESUME_1.setSection(SectionType.EDUCATION, new OrganizationSection(education));
        Organization education_4 = new Organization(new Link("Siemens AG", "http://www.siemens.ru/"));
        education_4.getListItems().add(new Period(
                LocalDate.of(2005, 1, 1),
                LocalDate.of(2005, 4, 1),
                "3 месяца обучения мобильным IN сетям (Берлин)",
                null));
        education.add(education_4);
        RESUME_1.setSection(SectionType.EDUCATION, new OrganizationSection(education));
        Organization education_5 = new Organization(new Link("Luxoft", "http://www.luxoft-training.ru/training/catalog/course.html?ID=22366"));
        education_5.getListItems().add(new Period(
                LocalDate.of(2011, 3, 1),
                LocalDate.of(2011, 4, 1),
                "Курс \"Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML.\"",
                null));
        education.add(education_5);
        RESUME_1.setSection(SectionType.EDUCATION, new OrganizationSection(education));
        Organization education_6 = new Organization(new Link("Coursera", "https://www.coursera.org/course/progfun"));
        education_6.getListItems().add(new Period(
                LocalDate.of(2013, 3, 1),
                LocalDate.of(2013, 5, 1),
                "\"Functional Programming Principles in Scala\" by Martin Odersky",
                null));
        education.add(education_6);
        RESUME_1.setSection(SectionType.EDUCATION, new OrganizationSection(education));
    } // Resume 1

    static {
        RESUME_2.setContacts(ContactType.FULL_NAME, RESUME_2.getFullName());
        RESUME_2.setContacts(ContactType.EMAIL_ADDRESS, "HumpbackedHorse@Fairytale.dom");
        RESUME_2.setContacts(ContactType.PHONE_NUMBER, "+7(222) 222-2222");
        RESUME_2.setContacts(ContactType.SKYPE, "Horse");
        RESUME_2.setSection(SectionType.PERSONAL, new TextSection("Выполняет желания"));
        RESUME_2.setSection(SectionType.OBJECTIVE, new TextSection("Друг Ивана"));

        List<String> listSectionAchievement = new ArrayList<>();
        listSectionAchievement.add("ACHIEVEMENT");
        RESUME_2.setSection(SectionType.ACHIEVEMENT, new ListSection(listSectionAchievement));

        List<String> listSectionQualification = new ArrayList<>();
        listSectionQualification.add("QUALIFICATIONS");
        RESUME_2.setSection(SectionType.QUALIFICATIONS, new ListSection(listSectionQualification));

        List<Organization> experience = new ArrayList<>();
        Organization experience_1 = new Organization(new Link("\"experience 2\"", "http://www.\"experience 2\".ru/"));
        experience_1.getListItems().add(new Period(
                LocalDate.of(1997, 9, 1),
                LocalDate.of(2005, 1, 1),
                "\"experience 2\"",
                "\"experience 2\""));
        experience.add(experience_1);
        RESUME_2.setSection(SectionType.EXPERIENCE, new OrganizationSection(experience));

        List<Organization> education = new ArrayList<>();
        Organization education_1 = new Organization(new Link("\"education 2\"", "http://www.\"education 2\".ru/"));
        education_1.getListItems().add(new Period(
                LocalDate.of(1994, 9, 1),
                LocalDate.of(1999, 6, 1),
                "\"education 2.2\"",
                null));
        education_1.getListItems().add(new Period(
                LocalDate.of(1984, 9, 1),
                LocalDate.of(1987, 6, 1),
                "\"education 2\"",
                null));
        education.add(education_1);
        RESUME_2.setSection(SectionType.EDUCATION, new OrganizationSection(education));
    } // Resume 2

    static {
        RESUME_3.setContacts(ContactType.FULL_NAME, RESUME_3.getFullName());
        RESUME_3.setContacts(ContactType.EMAIL_ADDRESS, "KarlsonAttic@Fairytale.dom");
        RESUME_3.setContacts(ContactType.PHONE_NUMBER, "+7(333) 333-3333");
        RESUME_3.setContacts(ContactType.SKYPE, "Karlson");
        RESUME_3.setSection(SectionType.PERSONAL, new TextSection("Способен летать"));
        RESUME_3.setSection(SectionType.OBJECTIVE, new TextSection("Живёт на крыше"));

        List<String> listSectionAchievement = new ArrayList<>();
        listSectionAchievement.add("ACHIEVEMENT");
        RESUME_3.setSection(SectionType.ACHIEVEMENT, new ListSection(listSectionAchievement));

        List<String> listSectionQualification = new ArrayList<>();
        listSectionQualification.add("QUALIFICATIONS");
        RESUME_3.setSection(SectionType.QUALIFICATIONS, new ListSection(listSectionQualification));

        List<Organization> experience = new ArrayList<>();
        Organization experience_1 = new Organization(new Link("\"experience 3\"", "http://www.\"experience 3\".ru/"));
        experience_1.getListItems().add(new Period(
                LocalDate.of(1997, 9, 1),
                LocalDate.of(2005, 1, 1),
                "\"experience 3\"",
                "\"experience 3\""));
        experience.add(experience_1);
        RESUME_3.setSection(SectionType.EXPERIENCE, new OrganizationSection(experience));

        List<Organization> education = new ArrayList<>();
        Organization education_1 = new Organization(new Link("\"education 3\"", "http://www.\"education 3\".ru/"));
        education_1.getListItems().add(new Period(
                LocalDate.of(1984, 9, 1),
                LocalDate.of(1987, 6, 1),
                "\"education 3\"",
                null));
        education.add(education_1);
        RESUME_3.setSection(SectionType.EDUCATION, new OrganizationSection(education));
    } // Resume 3

    static {
        RESUME_4.setContacts(ContactType.FULL_NAME, RESUME_4.getFullName());
        RESUME_4.setContacts(ContactType.EMAIL_ADDRESS, "LeopoldCat@Fairytale.dom");
        RESUME_4.setContacts(ContactType.PHONE_NUMBER, "+7(444) 444-4444");
        RESUME_4.setContacts(ContactType.SKYPE, "Leopold");
        RESUME_4.setSection(SectionType.PERSONAL, new TextSection("Дружит со всеми"));
        RESUME_4.setSection(SectionType.OBJECTIVE, new TextSection("Добрый котя"));

        List<String> listSectionAchievement = new ArrayList<>();
        listSectionAchievement.add("ACHIEVEMENT");
        RESUME_4.setSection(SectionType.ACHIEVEMENT, new ListSection(listSectionAchievement));

        List<String> listSectionQualification = new ArrayList<>();
        listSectionQualification.add("QUALIFICATIONS");
        RESUME_4.setSection(SectionType.QUALIFICATIONS, new ListSection(listSectionQualification));

        List<Organization> experience = new ArrayList<>();
        Organization experience_1 = new Organization(new Link("\"experience 4\"", "http://www.\"experience 4\".ru/"));
        experience_1.getListItems().add(new Period(
                LocalDate.of(1997, 9, 1),
                LocalDate.of(2005, 1, 1),
                "\"experience 4\"",
                "\"experience 4\""));
        experience.add(experience_1);
        RESUME_4.setSection(SectionType.EXPERIENCE, new OrganizationSection(experience));

        List<Organization> education = new ArrayList<>();
        Organization education_1 = new Organization(new Link("\"education 4\"", "http://www.\"education 4\".ru/"));
        education_1.getListItems().add(new Period(
                LocalDate.of(1984, 9, 1),
                LocalDate.of(1987, 6, 1),
                "\"Рeducation 4\"",
                null));
        education.add(education_1);
        RESUME_4.setSection(SectionType.EDUCATION, new OrganizationSection(education));
    } // Resume 4

    static {
        RESUME_5.setContacts(ContactType.FULL_NAME, RESUME_5.getFullName());
        RESUME_5.setContacts(ContactType.EMAIL_ADDRESS, "BunRunner@Fairytale.dom");
        RESUME_5.setContacts(ContactType.PHONE_NUMBER, "+7(555) 555-5555");
        RESUME_5.setContacts(ContactType.SKYPE, "Runner");
        RESUME_5.setSection(SectionType.PERSONAL, new TextSection("Хлеб ему голова"));
        RESUME_5.setSection(SectionType.OBJECTIVE, new TextSection("Батон в молодости"));

        List<String> listSectionAchievement = new ArrayList<>();
        listSectionAchievement.add("ACHIEVEMENT");
        RESUME_5.setSection(SectionType.ACHIEVEMENT, new ListSection(listSectionAchievement));

        List<String> listSectionQualification = new ArrayList<>();
        listSectionQualification.add("QUALIFICATIONS");
        RESUME_5.setSection(SectionType.QUALIFICATIONS, new ListSection(listSectionQualification));

        List<Organization> experience = new ArrayList<>();
        Organization experience_1 = new Organization(new Link("\"experience 5\"", "http://www.\"experience 5\".ru/"));
        experience_1.getListItems().add(new Period(
                LocalDate.of(1997, 9, 1),
                LocalDate.of(2005, 1, 1),
                "\"experience 5\"",
                "\"experience 5\""));
        experience.add(experience_1);
        RESUME_5.setSection(SectionType.EXPERIENCE, new OrganizationSection(experience));

        List<Organization> education = new ArrayList<>();
        Organization education_1 = new Organization(new Link("\"education 5\"", "http://www.\"education 5\".ru/"));
        education_1.getListItems().add(new Period(
                LocalDate.of(1984, 9, 1),
                LocalDate.of(1987, 6, 1),
                "\"education 5\"",
                null));
        education.add(education_1);
        RESUME_5.setSection(SectionType.EDUCATION, new OrganizationSection(education));
    } // Resume 5

    static {
        RESUME_DUMMY.setContacts(ContactType.FULL_NAME, RESUME_DUMMY.getFullName());
        RESUME_DUMMY.setContacts(ContactType.EMAIL_ADDRESS, "RosenbaumWooden@Fairytale.dom");
        RESUME_DUMMY.setContacts(ContactType.PHONE_NUMBER, "+7(123) 456-7890");
        RESUME_DUMMY.setContacts(ContactType.SKYPE, "Wooden");
        RESUME_DUMMY.setSection(SectionType.PERSONAL, new TextSection("Любит погулять"));
        RESUME_DUMMY.setSection(SectionType.OBJECTIVE, new TextSection("Деревянный боцман, который спрятал у себя в шляпе Нильса"));

        List<String> listSectionAchievement = new ArrayList<>();
        listSectionAchievement.add("ACHIEVEMENT");
        RESUME_DUMMY.setSection(SectionType.ACHIEVEMENT, new ListSection(listSectionAchievement));

        List<String> listSectionQualification = new ArrayList<>();
        listSectionQualification.add("QUALIFICATIONS");
        RESUME_DUMMY.setSection(SectionType.QUALIFICATIONS, new ListSection(listSectionQualification));

        List<Organization> experience = new ArrayList<>();
        Organization experience_1 = new Organization(new Link("\"experience DUMMY\"", "http://www.\"experience DUMMY\".ru/"));
        experience_1.getListItems().add(new Period(
                LocalDate.of(1997, 9, 1),
                LocalDate.of(2005, 1, 1),
                "\"experience DUMMY\"",
                "\"experience DUMMY\""));
        experience.add(experience_1);
        RESUME_DUMMY.setSection(SectionType.EXPERIENCE, new OrganizationSection(experience));

        List<Organization> education = new ArrayList<>();
        Organization education_1 = new Organization(new Link("\"education DUMMY\"", "http://www.\"education DUMMY\".ru/"));
        education_1.getListItems().add(new Period(
                LocalDate.of(1984, 9, 1),
                LocalDate.of(1987, 6, 1),
                "\"education DUMMY\"",
                null));
        education.add(education_1);
        RESUME_DUMMY.setSection(SectionType.EDUCATION, new OrganizationSection(education));
    } // Resume DUMMY

}


