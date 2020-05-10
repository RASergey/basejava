package com.urise.webapp.storage;

import com.urise.webapp.model.ContactType;
import com.urise.webapp.model.Resume;
import com.urise.webapp.model.SectionType;
import com.urise.webapp.model.section.ListSection;
import com.urise.webapp.model.section.Organization;
import com.urise.webapp.model.section.OrganizationSection;
import com.urise.webapp.model.section.TextSection;

import java.time.Month;

public class ResumeTestData {
    public static final Resume RESUME_1 = new Resume("Григорий Кислин");
    public static final Resume RESUME_2 = new Resume("Горбунок Конёк");
    public static final Resume RESUME_3 = new Resume("Карлсон Чердачный");
    public static final Resume RESUME_4 = new Resume("Леопольд Кот");
    public static final Resume RESUME_5 = new Resume(RESUME_3.getUuid(), "Колобок Бегун");
    public static final Resume RESUME_DUMMY = new Resume("Розенбум Деревянный");

    static {
        RESUME_1.addContacts(ContactType.EMAIL_ADDRESS, "gkislin@yandex.ru");
        RESUME_1.addContacts(ContactType.PHONE_NUMBER, "+7(921) 855-0482");
        RESUME_1.addContacts(ContactType.SKYPE, "grigory.kislin");
        RESUME_1.addSection(SectionType.PERSONAL, new TextSection("Аналитический склад ума, сильная логика, креативность, инициативность. Пурист кода и архитектуры."));
        RESUME_1.addSection(SectionType.OBJECTIVE, new TextSection("Ведущий стажировок и корпоративного обучения по Java Web и Enterprise технологиям"));

        RESUME_1.addSection(SectionType.ACHIEVEMENT, new ListSection(
                "С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\"," + " \"Многомодульный maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). Удаленное взаимодействие (JMS/AKKA)\"." + " Организация онлайн стажировок и ведение проектов. Более 1000 выпускников.",
                "Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk.",
                "Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM. Интеграция с 1С, Bonita BPM, CMIS, LDAP. Разработка приложения управления окружением на стеке: Scala/Play/Anorm/JQuery. Разработка SSO аутентификации и авторизации различных ERP модулей, интеграция CIFS/SMB java сервера.",
                "Реализация c нуля Rich Internet Application приложения на стеке технологий JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Commet, HTML5, Highstock для алгоритмического трейдинга.",
                "Создание JavaEE фреймворка для отказоустойчивого взаимодействия слабо-связанных сервисов (SOA-base архитектура, JAX-WS, JMS, AS Glassfish). Сбор статистики сервисов и информации о состоянии через систему мониторинга Nagios. Реализация онлайн клиента для администрирования и мониторинга системы по JMX (Jython/ Django).",
                "Реализация протоколов по приему платежей всех основных платежных системы России (Cyberplat, Eport, Chronopay, Сбербанк), Белоруcсии(Erip, Osmp) и Никарагуа."
        ));

        RESUME_1.addSection(SectionType.QUALIFICATIONS, new ListSection(
                "JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2",
                "Version control: Subversion, Git, Mercury, ClearCase, Perforce",
                "DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle,",
                "MySQL, SQLite, MS SQL, HSQLDB",
                "Languages: Java, Scala, Python)/Jython/PL-Python, JavaScript, Groovy,",
                "XML/XSD/XSLT, SQL, C/C++, Unix shell scripts,",
                "Java Frameworks: Java 8 (Time API, Streams), Guava, Java Executor, MyBatis, Spring (MVC, Security, Data, Clouds, Boot), JPA (Hibernate, EclipseLink), Guice, GWT(SmartGWT, ExtGWT)/GXT), Vaadin, Jasperreports, Apache Commons, Eclipse SWT, JUnit, Selenium (htmlelements).",
                "Python: Django.",
                "JavaScript: jQuery, ExtJS, Bootstrap.js, underscore.js",
                "Scala: SBT, Play2, Specs2, Anorm, Spray, Akka",
                "Технологии: Servlet, JSP/JSTL, JAX-WS, REST, EJB, RMI, JMS, JavaMail, JAXB, StAX, SAX, DOM, XSLT, MDB, JMX, JDBC, JPA, JNDI, JAAS, SOAP, AJAX, Commet, HTML5, ESB, CMIS, BPMN2, LDAP, OAuth1, OAuth2, JWT.)",
                "Инструменты: Maven + plugin development, Gradle, настройка Ngnix,",
                "администрирование Hudson/Jenkins, Ant + custom task, SoapUI, JPublisher, Flyway, Nagios, iReport, OpenCmis, Bonita, pgBouncer.",
                "Отличное знание и опыт применения концепций ООП, SOA, шаблонов проектрирования, архитектурных шаблонов, UML, функционального программирования",
                "Родной русский, английский \"upper intermediate\""
        ));

        RESUME_1.addSection(SectionType.EXPERIENCE, new OrganizationSection(
                new Organization(
                        "Alcatel", "http://www.alcatel.ru/",
                        new Organization.Position(
                                1997, Month.SEPTEMBER,
                                2005, Month.JANUARY,
                                "Инженер по аппаратному и программному тестированию",
                                "Тестирование, отладка, внедрение ПО цифровой телефонной станции Alcatel 1000 S12 (CHILL, ASM).")),
                new Organization(
                        "Siemens AG", "https://www.siemens.com/ru/ru/home.html",
                        new Organization.Position(
                                2005, Month.SEPTEMBER,
                                2007, Month.FEBRUARY,
                                "Разработчик ПО",
                                "Разработка информационной модели, проектирование интерфейсов, реализация и отладка ПО на мобильной IN платформе Siemens @vantage (Java, Unix).")),
                new Organization(
                        "Enkata", "http://enkata.com/",
                        new Organization.Position(
                                2007, Month.MARCH,
                                2008, Month.JUNE,
                                "Разработчик ПО",
                                "Реализация клиентской (Eclipse RCP) и серверной (JBoss 4.2, Hibernate 3.0, Tomcat, JMS) частей кластерного J2EE приложения (OLAP, Data mining).")),
                new Organization(
                        "Yota", "https://www.yota.ru/",
                        new Organization.Position(
                                2008, Month.JUNE,
                                2010, Month.DECEMBER,
                                "Ведущий специалист",
                                "Дизайн и имплементация Java EE фреймворка для отдела \"Платежные Системы\" (GlassFish v2.1, v3, OC4J, EJB3, JAX-WS RI 2.1, Servlet 2.4, JSP, JMX, JMS, Maven2). Реализация администрирования, статистики и мониторинга фреймворка. Разработка online JMX клиента (Python)")),
                new Organization(
                        "Luxoft (Deutsche Bank)", "http://www.luxoft.ru/",
                        new Organization.Position(
                                2010, Month.DECEMBER,
                                2012, Month.APRIL,
                                "Ведущий программист",
                                "Участие в проекте Deutsche Bank CRM (WebLogic, Hibernate, Spring, Spring MVC, SmartGWT, GWT, Jasper, Oracle). Реализация клиентской и серверной части CRM. Реализация RIA-приложения для администрирования, мониторинга и анализа результатов в области алгоритмического трейдинга. JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Highstock, Commet, HTML5.")),
                new Organization(
                        "RIT Center", null,
                        new Organization.Position(
                                2012, Month.APRIL,
                                2014, Month.OCTOBER,
                                "Java архитектор",
                                "Организация процесса разработки системы ERP для разных окружений: релизная политика, версионирование, ведение CI (Jenkins), миграция базы (кастомизация Flyway), конфигурирование системы (pgBoucer, Nginx), AAA via SSO. Архитектура БД и серверной части системы. Разработка интергационных сервисов: CMIS, BPMN2, 1C (WebServices), сервисов общего назначения (почта, экспорт в pdf, doc, html). Интеграция Alfresco JLAN для online редактирование из браузера документов MS Office. Maven + plugin development, Ant, Apache Commons, Spring security, Spring MVC, Tomcat,WSO2, xcmis, OpenCmis, Bonita, Python scripting, Unix shell remote scripting via ssh tunnels, PL")),
                new Organization(
                        "Wrike", "https://www.wrike.com/",
                        new Organization.Position(
                                2014, Month.OCTOBER,
                                2016, Month.JANUARY,
                                "Старший разработчик (backend)",
                                "Проектирование и разработка онлайн платформы управления проектами Wrike (Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO.")),
                new Organization(
                        "Java Online Projects", "http://javaops.ru/",
                        new Organization.Position(
                                2013, Month.OCTOBER,
                                "Автор проекта.",
                                "Создание, организация и проведение Java онлайн проектов и стажировок."))));

        RESUME_1.addSection(SectionType.EDUCATION, new OrganizationSection(
                new Organization(
                        "Заочная физико-техническая школа при МФТИ", "http://www.school.mipt.ru/",
                        new Organization.Position(
                                1984, Month.SEPTEMBER,
                                1987, Month.JUNE,
                                "Закончил с отличием.",
                                null)),
                new Organization(
                        "Санкт-Петербургский национальный исследовательский университет информационных технологий, механики и оптики"
                        , "http://www.ifmo.ru/",
                        new Organization.Position(
                                1987, Month.SEPTEMBER,
                                1993, Month.JULY,
                                "Аспирантура (программист С, С++)",
                                null),
                        new Organization.Position(
                                1993, Month.SEPTEMBER,
                                1996, Month.JULY,
                                "Инженер (программист Fortran, C)",
                                null)),
                new Organization(
                        "Alcatel", "http://www.alcatel.ru/",
                        new Organization.Position(
                                1997, Month.SEPTEMBER,
                                1998, Month.MARCH,
                                "6 месяцев обучения цифровым телефонным сетям (Москва)",
                                null)),
                new Organization(
                        "Siemens AG", "http://www.siemens.ru/",
                        new Organization.Position(
                                2005, Month.JANUARY,
                                2005, Month.APRIL,
                                "3 месяца обучения мобильным IN сетям (Берлин)",
                                null)),
                new Organization(
                        "Luxoft", "http://www.luxoft-training.ru/training/catalog/course.html?ID=22366",
                        new Organization.Position(
                                2011, Month.MARCH,
                                2011, Month.APRIL,
                                "Курс \"Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML.\"",
                                null)),
                new Organization(
                        "Coursera", "https://www.coursera.org/course/progfun",
                        new Organization.Position(
                                2013, Month.MARCH,
                                2013, Month.MAY,
                                "\"Functional Programming Principles in Scala\" by Martin Odersky",
                                null))));
    } // Resume 1

    static {
        RESUME_2.addContacts(ContactType.EMAIL_ADDRESS, "HumpbackedHorse@Fairytale.dom");
        RESUME_2.addContacts(ContactType.PHONE_NUMBER, "+7(222) 222-2222");
        RESUME_2.addContacts(ContactType.SKYPE, "Horse");
        RESUME_2.addSection(SectionType.PERSONAL, new TextSection("Выполняет желания"));
        RESUME_2.addSection(SectionType.OBJECTIVE, new TextSection("Друг Ивана"));


        RESUME_2.addSection(SectionType.ACHIEVEMENT, new ListSection("ACHIEVEMENT"));
        RESUME_2.addSection(SectionType.QUALIFICATIONS, new ListSection("QUALIFICATIONS"));

        RESUME_2.addSection(SectionType.EXPERIENCE, new OrganizationSection(
                new Organization(
                        "\"experience 2\"", "http://www.experience 2.ru/", new Organization.Position(
                        1997, Month.SEPTEMBER,
                        2005, Month.JANUARY,
                        "\"experience 2\"",
                        null))));

        RESUME_2.addSection(SectionType.EDUCATION, new OrganizationSection(
                new Organization(
                        "\"education 2\"", "http://www.education 2.ru/",
                        new Organization.Position(
                                2013, Month.MARCH,
                                2013, Month.MAY,
                                "\"education 2\"",
                                null),
                        new Organization.Position(
                                1984, Month.MARCH,
                                1987, Month.MAY,
                                "\"education 2\"",
                                null))));
    } // Resume 2

    static {
        RESUME_3.addContacts(ContactType.EMAIL_ADDRESS, "KarlsonAttic@Fairytale.dom");
        RESUME_3.addContacts(ContactType.PHONE_NUMBER, "+7(333) 333-3333");
        RESUME_3.addContacts(ContactType.SKYPE, "Karlson");
        RESUME_3.addSection(SectionType.PERSONAL, new TextSection("Способен летать"));
        RESUME_3.addSection(SectionType.OBJECTIVE, new TextSection("Живёт на крыше"));

        RESUME_3.addSection(SectionType.ACHIEVEMENT, new ListSection("ACHIEVEMENT"));
        RESUME_3.addSection(SectionType.QUALIFICATIONS, new ListSection("QUALIFICATIONS"));

        RESUME_3.addSection(SectionType.EXPERIENCE, new OrganizationSection(
                new Organization(
                        "\"experience 3\"", "http://www.experience 3.ru/",
                        new Organization.Position(
                                1997, Month.SEPTEMBER,
                                2005, Month.JANUARY,
                                "\"experience 3\"",
                                null))));

        RESUME_3.addSection(SectionType.EDUCATION, new OrganizationSection(
                new Organization(
                        "\"education 3\"", "http://www.education 3.ru/",
                        new Organization.Position(
                                2013, Month.MARCH,
                                2013, Month.MAY,
                                "\"education 3\"",
                                null))));
    } // Resume 3

    static {
        RESUME_4.addContacts(ContactType.EMAIL_ADDRESS, "LeopoldCat@Fairytale.dom");
        RESUME_4.addContacts(ContactType.PHONE_NUMBER, "+7(444) 444-4444");
        RESUME_4.addContacts(ContactType.SKYPE, "Leopold");
        RESUME_4.addSection(SectionType.PERSONAL, new TextSection("Дружит со всеми"));
        RESUME_4.addSection(SectionType.OBJECTIVE, new TextSection("Добрый котя"));

        RESUME_4.addSection(SectionType.ACHIEVEMENT, new ListSection("ACHIEVEMENT"));
        RESUME_4.addSection(SectionType.QUALIFICATIONS, new ListSection("QUALIFICATIONS"));

        RESUME_4.addSection(SectionType.EXPERIENCE, new OrganizationSection(new Organization(
                "\"experience 4\"", "http://www.experience 4.ru/",
                new Organization.Position(
                        1997, Month.SEPTEMBER,
                        2005, Month.JANUARY,
                        "\"experience 4\"",
                        null))));

        RESUME_4.addSection(SectionType.EDUCATION, new OrganizationSection(new Organization(
                "\"education 4\"", "http://www.education 4.ru/",
                new Organization.Position(
                        2013, Month.MARCH,
                        2013, Month.MAY,
                        "\"education 4\"",
                        null))));
    } // Resume 4

    static {
        RESUME_5.addContacts(ContactType.EMAIL_ADDRESS, "BunRunner@Fairytale.dom");
        RESUME_5.addContacts(ContactType.PHONE_NUMBER, "+7(555) 555-5555");
        RESUME_5.addContacts(ContactType.SKYPE, "Runner");
        RESUME_5.addSection(SectionType.PERSONAL, new TextSection("Хлеб ему голова"));
        RESUME_5.addSection(SectionType.OBJECTIVE, new TextSection("Батон в молодости"));

        RESUME_5.addSection(SectionType.ACHIEVEMENT, new ListSection("ACHIEVEMENT"));
        RESUME_5.addSection(SectionType.QUALIFICATIONS, new ListSection("QUALIFICATIONS"));

        RESUME_5.addSection(SectionType.EXPERIENCE, new OrganizationSection(new Organization(
                "\"experience 5\"", "http://www.experience 5.ru/",
                new Organization.Position(
                        1997, Month.SEPTEMBER,
                        2005, Month.JANUARY,
                        "\"experience 5\"",
                        null))));

        RESUME_5.addSection(SectionType.EDUCATION, new OrganizationSection(new Organization(
                "\"education 5\"", "http://www.education 5.ru/",
                new Organization.Position(
                        2013, Month.MARCH,
                        2013, Month.MAY,
                        "\"education 5\"",
                        null))));
    } // Resume 5

    static {
        RESUME_DUMMY.addContacts(ContactType.EMAIL_ADDRESS, "RosenbaumWooden@Fairytale.dom");
        RESUME_DUMMY.addContacts(ContactType.PHONE_NUMBER, "+7(123) 456-7890");
        RESUME_DUMMY.addContacts(ContactType.SKYPE, "Wooden");
        RESUME_DUMMY.addSection(SectionType.PERSONAL, new TextSection("Любит погулять"));
        RESUME_DUMMY.addSection(SectionType.OBJECTIVE, new TextSection("Деревянный боцман, который спрятал у себя в шляпе Нильса"));

        RESUME_DUMMY.addSection(SectionType.ACHIEVEMENT, new ListSection("ACHIEVEMENT"));
        RESUME_DUMMY.addSection(SectionType.QUALIFICATIONS, new ListSection("QUALIFICATIONS"));

        RESUME_DUMMY.addSection(SectionType.EXPERIENCE, new OrganizationSection(new Organization(
                "\"experience DUMMY\"", "http://www.experience DUMMY.ru/",
                new Organization.Position(
                        1997, Month.SEPTEMBER,
                        2005, Month.JANUARY,
                        "\"experience DUMMY\"",
                        null))));

        RESUME_DUMMY.addSection(SectionType.EDUCATION, new OrganizationSection(new Organization(
                "\"education DUMMY\"", "http://www.education DUMMY.ru/",
                new Organization.Position(
                        2013, Month.MARCH,
                        2013, Month.MAY,
                        "\"education DUMMY\"",
                        null))));
    } // Resume DUMMY
}


